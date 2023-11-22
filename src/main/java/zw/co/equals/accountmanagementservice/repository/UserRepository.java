package zw.co.equals.accountmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.equals.accountmanagementservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
