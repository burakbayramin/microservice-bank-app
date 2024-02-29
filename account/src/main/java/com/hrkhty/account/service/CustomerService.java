package com.hrkhty.account.service;

import com.hrkhty.account.dto.CustomerDetailsDto;

public interface CustomerService {

    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
