package zw.co.equals.accountmanagementservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import zw.co.equals.accountmanagementservice.dto.AccountDto;
import zw.co.equals.accountmanagementservice.model.Account;
import zw.co.equals.accountmanagementservice.repository.AccountRepository;
import zw.co.equals.accountmanagementservice.service.AccountService;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    private final ModelMapper modelMapper;
    private final AccountRepository  accountRepository;

    public AccountServiceImpl(ModelMapper modelMapper, AccountRepository accountRepository) {
        this.modelMapper = modelMapper;
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        log.info("Creating an account: {}", accountDto);
        Account account = modelMapper.map(accountDto, Account.class);
        Account createdAccount = accountRepository.save(account);
        log.info("Successfully created an account: {}", createdAccount);
        return modelMapper.map(createdAccount, AccountDto.class);
    }
}
