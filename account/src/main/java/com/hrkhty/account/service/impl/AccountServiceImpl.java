package com.hrkhty.account.service.impl;

import com.hrkhty.account.repository.AccountRepository;
import com.hrkhty.account.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;


}
