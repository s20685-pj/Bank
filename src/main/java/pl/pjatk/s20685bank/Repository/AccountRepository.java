package pl.pjatk.s20685bank.Repository;

import pl.pjatk.s20685bank.Model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepository {

    private final List<Account> accountList = new ArrayList<>();

    public void save(Account account){
        accountList.add(account);
    }

    public List<Account> getAll(){
        return this.accountList;
    }

    public Optional<Account> findAccountById(long id){
        return accountList.stream()
                .filter(account -> account.getId() == id)
                .findFirst();
    }

    public Account withdraw(long id, double amount){
        Account account = findAccountById(id).get();
        account.setAmount(account.getAmount() - amount);
        return account;
    }
    public Account deposit(long id, double amount){
        Account account = findAccountById(id).get();
        account.setAmount(account.getAmount() + amount);
        return account;
    }
}
