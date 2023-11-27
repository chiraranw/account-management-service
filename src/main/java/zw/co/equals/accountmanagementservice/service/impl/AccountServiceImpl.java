package zw.co.equals.accountmanagementservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import zw.co.equals.accountmanagementservice.dto.*;
import zw.co.equals.accountmanagementservice.exception.AccountNotFoundException;
import zw.co.equals.accountmanagementservice.exception.InvalidRequestException;
import zw.co.equals.accountmanagementservice.model.Account;
import zw.co.equals.accountmanagementservice.model.AccountType;
import zw.co.equals.accountmanagementservice.repository.AccountRepository;
import zw.co.equals.accountmanagementservice.service.AccountService;
import zw.co.equals.accountmanagementservice.service.RabbitMQService;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    private final ModelMapper modelMapper;
    private final AccountRepository accountRepository;
    private final RabbitMQService rabbitMQService;

    public AccountServiceImpl(ModelMapper modelMapper, AccountRepository accountRepository, RabbitMQService rabbitMQService) {
        this.modelMapper = modelMapper;
        this.accountRepository = accountRepository;
        this.rabbitMQService = rabbitMQService;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public AccountDto create(AccountDto accountDto) {
        log.info("Creating an account: {}", accountDto);
        Account account = modelMapper.map(accountDto, Account.class);
        Account createdAccount = accountRepository.save(account);
        log.info("Successfully created an account: {}", createdAccount);
        accountRepository.flush();

       rabbitMQService
                .creditAccount(Request.builder()
                        .accountNumber(accountDto.getAccountNumber())
                        .requestType(RequestType.CREDIT)
                        .amount(new BigDecimal(10)) // TODO: 27/11/2023 from db
                        .build());

        return modelMapper.map(createdAccount, AccountDto.class);
    }

    @Override
    public UpdateAccountResponse updateAccountType(UpdateAccountTypeRequest updateAccountTypeRequest) {

        log.info("Updating account type for: {} ", updateAccountTypeRequest.getAccountType());
        Account account = accountRepository
                .findAccountByAccountNumber(updateAccountTypeRequest.getAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException(" Could not find specified account: " + updateAccountTypeRequest.getAccountNumber()));

        if (account.getType().name().equals(updateAccountTypeRequest.getAccountType())) {
            log.error("Account is already of the specified type : {}", updateAccountTypeRequest);
            throw new InvalidRequestException("Account is already of the specified type : " + updateAccountTypeRequest.getAccountType());
        }
        account.setType(AccountType.valueOf(updateAccountTypeRequest.getAccountType()));
        accountRepository.save(account);
        log.info("Account has been updated successfully: {}", account);
        return UpdateAccountResponse.builder()
                .accountType(account.getType())
                .status(HttpStatus.OK.value())
                .accountNumber(account.getAccountNumber())
                .build();
    }
}
