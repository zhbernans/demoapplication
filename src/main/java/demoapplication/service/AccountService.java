package demoapplication.service;


import demoapplication.model.Account;
import demoapplication.repository.AccountRepo;
import demoapplication.repository.RoleRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService{

    private final AccountRepo accountRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder passwordEncoder;


    public AccountService(AccountRepo accountRepo,RoleRepo roleRepo, BCryptPasswordEncoder passwordEncoder){
        this.accountRepo=accountRepo;
        this.roleRepo=roleRepo;
        this.passwordEncoder=passwordEncoder;
    }

    public Account getById(Long id){
        return accountRepo.findById(id).orElse(null);
    }

    public Account getByUsername(String username){
        return accountRepo.findByUsername(username);}

    public Account save(Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepo.save(account);
    }

    public void delete(Long id){
        accountRepo.deleteById(id);
    }
}