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
                .orElseThrow(() -> new IllegalArgumentException("Verilen id değerine sahip bir kayıt bulunamadı."));
    }

    public List<Account> getAll() {
        return repository.findAll();
    }

    public String create(Account account) {
        repository.save(account);
        return "Kayıt işlemi başarılı.";
    }

    public String createAll(List<Account> accountList) {
        repository.saveAll(accountList);
        return "Toplu kayıt işlemi başarılı.";
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

    public String deleteAll(List<Long> idList) {
        List<Account> accountList = repository.findAllById(idList);
        repository.deleteAll(accountList);

        return "Tüm kayıtlar başarıyla silindi.";
    }
}
