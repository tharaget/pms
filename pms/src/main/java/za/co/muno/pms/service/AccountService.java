package za.co.muno.pms.service;

import org.springframework.stereotype.Service;
import za.co.muno.pms.entity.Account;
import za.co.muno.pms.repository.AccountRepository;

@Service
public class AccountService
{
    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }


    public Account findAccountByUsernameAndPassword( String username, String password )
    {
        return this.accountRepository.findAccountByUsernameAndPassword(username,password);
    }
}
