package zw.co.equals.accountmanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.equals.accountmanagementservice.model.AccountType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountResponse {
    private int status;
    private String accountNumber;
    private AccountType accountType;
}
