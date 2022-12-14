package uz.mohirdev.lesson.serivice;

import org.springframework.stereotype.Service;
import uz.mohirdev.lesson.entity.Account;
import uz.mohirdev.lesson.repository.AccountRepository;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account save(Account account){
        return accountRepository.save(account);
    }
}
