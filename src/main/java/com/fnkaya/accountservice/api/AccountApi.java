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

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> get(@PathVariable(value = "id") Long id) {
        Account account = service.get(id);

        return ResponseEntity.ok(account);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Account>>> getAll() {
        List<Account> accountList = service.getAll();

        return ResponseEntity.ok(Map.of("accountList", accountList));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody Account account) {
        String response = service.create(account);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Account> update(@RequestBody Account account) {
        Account uAccount = service.update(account);

        return ResponseEntity.ok(uAccount);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        String response = service.delete(id);

        return ResponseEntity.ok(response);
    }
}
