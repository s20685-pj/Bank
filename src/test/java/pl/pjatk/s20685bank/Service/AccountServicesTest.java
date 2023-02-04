package pl.pjatk.s20685bank.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.pjatk.s20685bank.Model.Account;
import pl.pjatk.s20685bank.Repository.AccountRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccountServicesTest {


    private final AccountRepository AccountRepository = mock(AccountRepository.class);
    private final AccountServices AccountService = new AccountServices(AccountRepository);

    private Account Account1, Account2, Account3;
    private List<Account> accountList;

    @BeforeEach
        //given
    void setUp() {
        Account1 = new Account(1, "John",  200.00);
        Account2 = new Account(2, "Emmy",  150.00);
        Account3 = new Account(3, "Hugh",  160.00);
        accountList = List.of(Account1, Account2, Account3);
    }


    @Test
    void Shouldsave() {
        //given
        //when
        assertDoesNotThrow(() -> AccountService.save(Account1));
        when(AccountRepository.findAccountById(1)).thenReturn(Optional.of(Account1));
        Optional<Account> AccountFound = AccountRepository.findAccountById(1);
        //then
        assertTrue(AccountFound.isPresent());
        assertEquals(AccountFound.get(), Account1);
    }

    @Test
    void ShouldfindAllAccount() {
        //given
        Account testkAccount = new Account(1,"Tomasz",200.00);
        //when
        Mockito.when(AccountService.findAllAccount()).thenReturn(accountList);
        List<Account> query = AccountService.findAllAccount();
        //then
        Assertions.assertEquals(query, accountList);
    }

    @Test
    void findAccountById() {
        //when
        Mockito.when(AccountRepository.findAccountById(1)).thenReturn(Optional.of(Account1));
        Optional<Account> result = AccountRepository.findAccountById(1);
        //then
        Assertions.assertEquals(result, Account1);
    }
}
