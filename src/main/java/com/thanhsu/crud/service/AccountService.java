package com.thanhsu.crud.service;
import com.thanhsu.crud.entity.Account;
import com.thanhsu.crud.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class AccountService {
    private final AccountRepository repository;
    public AccountService(AccountRepository repository) { this.repository = repository; }
    public Optional<Account> authenticate(String email, String password) { return repository.findByEmailAndPassword(email, password); }
    public long count() { return repository.count(); }
    public void save(Account account) { repository.save(account); }
}
