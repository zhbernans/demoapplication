package demoapplication.security;

import demoapplication.model.Account;
import demoapplication.service.AccountService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtAccountDetailService implements UserDetailsService {

    private final AccountService accountService;

    public JwtAccountDetailService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.getByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Account not found!");
        } else {
            return JwtAccountFactory.create(account);
        }
    }
}
