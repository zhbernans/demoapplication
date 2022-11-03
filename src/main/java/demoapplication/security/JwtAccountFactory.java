package demoapplication.security;

import demoapplication.model.Account;
import demoapplication.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtAccountFactory {
    private JwtAccountFactory() {
    }

    public static JwtAccount create(Account account) {
        return new JwtAccount(
                account.getId(),
                account.getUsername(),
                account.getPassword(),
                mapToGrantedAuthorities(List.of(account.getRole()))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> listRole) {
        return listRole.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toList());
    }
}
