package uz.mohirdev.lesson.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.mohirdev.lesson.entity.Account;
import uz.mohirdev.lesson.entity.Employee;
import uz.mohirdev.lesson.serivice.AccountService;

@RestController
@RequestMapping("/api")
public class AccountResource {
    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/account/save")
    public ResponseEntity save(@RequestBody Account account){
        Account result = accountService.save(account);
        return ResponseEntity.ok(result);
    }
}
