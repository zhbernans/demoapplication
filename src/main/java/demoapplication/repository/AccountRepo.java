package demoapplication.repository;

import demoapplication.model.Account;
import demoapplication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
