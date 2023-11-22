package zw.co.equals.accountmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.equals.accountmanagementservice.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
