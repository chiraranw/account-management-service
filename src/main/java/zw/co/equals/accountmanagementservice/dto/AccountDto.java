package zw.co.equals.accountmanagementservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto extends BaseDto{
    @NotBlank
    private String accountNumber;
    @NotBlank
    private String type;
    private String status;
    @NotBlank
    private String description;
    @NotBlank
    private BigDecimal currentBalance;
    @NotNull
    private UserDto user;
}