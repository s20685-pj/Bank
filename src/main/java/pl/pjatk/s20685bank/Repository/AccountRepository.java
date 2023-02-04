package pl.pjatk.s20685bank.Repository;

import pl.pjatk.s20685bank.Model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository {

    private final List<Account> accountList = new ArrayList<>();

    public void save(Account account){
        accountList.add(account);
    }

}
