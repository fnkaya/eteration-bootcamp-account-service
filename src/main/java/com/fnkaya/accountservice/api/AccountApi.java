package com.fnkaya.accountservice.api;

import com.fnkaya.accountservice.api.path.ApiPath;
import com.fnkaya.accountservice.model.Account;
import com.fnkaya.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(ApiPath.ACCOUNT_URL)
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService service;

    @GetMapping(value = "{id}")
    public ResponseEntity<Account> get(@PathVariable(value = "id") Long id) {
        var account = service.get(id);

        return ResponseEntity.ok(account);
    }

    @GetMapping
    public ResponseEntity<Map<String, List<Account>>> getAll() {
        List<Account> accountList = service.getAll();

        return ResponseEntity.ok(Map.of("accountList", accountList));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Account account) {
        String response = service.create(account);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping(value = "list")
    public ResponseEntity<String> createAll(@RequestBody Map<String, List<Account>> map) {
        String response = service.createAll(map.get("accountList"));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping
    public ResponseEntity<Account> update(@RequestBody Account account) {
        var uAccount = service.update(account);

        return ResponseEntity.ok(uAccount);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        String response = service.delete(id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll(@RequestBody List<Long> idList) {
        String response = service.deleteAll(idList);

        return ResponseEntity.ok(response);
    }
}
