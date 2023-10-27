package za.co.muno.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.muno.pms.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByUsernameAndPassword(String username, String password);
}
