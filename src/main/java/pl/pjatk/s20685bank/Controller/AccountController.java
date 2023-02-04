package pl.pjatk.s20685bank.Controller;

import org.springframework.web.bind.annotation.*;
import pl.pjatk.s20685bank.Model.Account;
import pl.pjatk.s20685bank.Service.AccountServices;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class AccountController {

    private final AccountServices accountServices;

    public AccountController(AccountServices accountServices) {
        this.accountServices = accountServices;

    }

    @PostMapping("/register")
    public void registerNewUserAccount(Account account){
        accountServices.save(account);
    }

    @GetMapping("/FindAll")
    public List<Account> findAllUserAccounts(Account account){
            return this.accountServices.findAllAccount();
        }

    @GetMapping("/FindById")
    public Account findById(@RequestParam long id){
        return this.accountServices.findAccountById(id);
    }

    @GetMapping("/withdraw")
    public Account withdraw(@RequestParam long id, @RequestParam double amount){
        return(Account)accountServices.withdraw(id, amount);
    }
    @PostMapping("/Deposit")
    public Account deposit(@RequestParam long id, @RequestParam double amount){
        return(Account)accountServices.deposit(id, amount);
    }
}
