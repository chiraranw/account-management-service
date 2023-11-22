package zw.co.equals.accountmanagementservice.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto{
    private String username;
    private String firstName;
    private String lastName;
    private String address;
    private String mobile;
    private String email;
}