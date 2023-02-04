package pl.pjatk.s20685bank.Service;

import org.springframework.stereotype.Service;
import pl.pjatk.s20685bank.Model.Account;
import pl.pjatk.s20685bank.Repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServices {

    private final AccountRepository accountRepository;


    public AccountServices(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void save(Account account){
        accountRepository.save(account);
    }

    public List<Account> findAllAccount(){
        return accountRepository.getAll();
    }

    public Account findAccountById(long id){
        Optional<Account> optionalAccount = accountRepository.findAccountById(id);
        if (optionalAccount.isPresent()){
            return optionalAccount.get();
        }else throw new RuntimeException();
    }

    public Account withdraw(long id, double amount){
        if (amount > accountRepository.findAccountById(id).get().getAmount()){
            throw new RuntimeException("Not enough money on this Account");
        }
        return accountRepository.withdraw(id, amount);
    }
    public Account deposit(long id, double amount){
        return accountRepository.deposit(id, amount);
    }
}
