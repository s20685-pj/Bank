package pl.pjatk.s20685bank.Service;

import org.springframework.stereotype.Service;
import pl.pjatk.s20685bank.Model.Account;
import pl.pjatk.s20685bank.Repository.AccountRepository;

@Service
public class AccountServices {

    private final AccountRepository accountRepository;


    public AccountServices(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void save(Account account){
        accountRepository.save(account);
    }
}
