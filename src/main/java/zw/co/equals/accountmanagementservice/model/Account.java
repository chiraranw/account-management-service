package zw.co.equals.accountmanagementservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Account extends BaseEntity{
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    @Column(unique = true)
    private String accountNumber;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private String description;
    private BigDecimal currentBalance;
}
