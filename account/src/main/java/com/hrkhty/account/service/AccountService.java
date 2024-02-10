package com.hrkhty.account.service;

import com.hrkhty.account.dto.CustomerDto;

public interface AccountService {

    void createAccount(CustomerDto customerDto);

    CustomerDto getAccountByMobileNumber(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
