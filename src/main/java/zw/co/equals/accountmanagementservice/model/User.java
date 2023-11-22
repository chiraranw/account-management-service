package zw.co.equals.accountmanagementservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class User extends BaseEntity{
    private String username;
    private String firstName;
    private String lastName;
    private String address;
    private String mobile;
    private String email;
}
