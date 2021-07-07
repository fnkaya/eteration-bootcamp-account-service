package com.fnkaya.accountservice.service;

import com.fnkaya.accountservice.model.Account;
import com.fnkaya.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public Account get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Verilen id değerine sahip bir kayır bulunamadı."));
    }

    public List<Account> getAll() {
        return repository.findAll(Sort.by("email"));
    }

    public String create(Account account) {
        repository.save(account);
        return "Kayıt işlemi başarılı.";
    }

    public Account update(Account account) {
        Account accountDb = get(account.getId());
        accountDb.setEmail(account.getEmail());
        accountDb.setPassword(account.getPassword());

        return repository.save(accountDb);
    }

    public String delete(Long id) {
        repository.delete(get(id));

        return "Kayıt başarıyla silindi.";
    }
}
