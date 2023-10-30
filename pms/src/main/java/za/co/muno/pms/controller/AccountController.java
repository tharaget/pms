package za.co.muno.pms.controller;

import org.springframework.web.bind.annotation.*;
import za.co.muno.pms.entity.Account;
import za.co.muno.pms.service.AccountService;

@RestController
@RequestMapping("api/users")
@CrossOrigin("*")
public class AccountController
{
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(path = "login")
    public Account login(@RequestBody Account account )
    {

        Account loginAccount = this.accountService.findAccountByUsernameAndPassword(account.getUsername(), account.getPassword());
        if( loginAccount == null )
        {
            throw new IllegalArgumentException("Wrong username and password");
        }
        System.out.println(loginAccount);
        return loginAccount;
    }
}
