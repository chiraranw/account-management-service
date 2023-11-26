package zw.co.equals.accountmanagementservice.service;

import zw.co.equals.accountmanagementservice.dto.AccountDto;
import zw.co.equals.accountmanagementservice.dto.UpdateAccountTypeRequest;

public interface AccountService {
    AccountDto create(AccountDto accountDto);
    AccountDto updateAccountType(UpdateAccountTypeRequest updateAccountTypeRequest);

}
