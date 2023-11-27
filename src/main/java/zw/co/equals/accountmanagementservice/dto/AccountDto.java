package zw.co.equals.accountmanagementservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto extends BaseDto{
    @NotBlank
    @Size(min = 13, message = "Account min length is 13")
    @Size(max = 13, message = "Account max length is 13")
    private String accountNumber;
    @NotBlank
    private String type;
    private String status;
    @NotBlank
    private String description;
    @NotNull
    private BigDecimal currentBalance;
    @NotNull
    private UserDto user;
}