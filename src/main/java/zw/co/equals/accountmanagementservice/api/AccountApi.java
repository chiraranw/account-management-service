package zw.co.equals.accountmanagementservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.equals.accountmanagementservice.dto.AccountDto;
import zw.co.equals.accountmanagementservice.service.AccountService;

@RestController
@RequestMapping("/api/v1.0/account")
public class AccountApi {

    private final AccountService accountService;

    public AccountApi(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/create")
    public ResponseEntity<AccountDto> create(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.create(accountDto), HttpStatus.CREATED);
    }


}
