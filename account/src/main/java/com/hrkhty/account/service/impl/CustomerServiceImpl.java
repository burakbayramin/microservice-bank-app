package com.hrkhty.account.service.impl;

import com.hrkhty.account.dto.AccountDto;
import com.hrkhty.account.dto.CardDto;
import com.hrkhty.account.dto.CustomerDetailsDto;
import com.hrkhty.account.dto.LoanDto;
import com.hrkhty.account.entity.Account;
import com.hrkhty.account.entity.Customer;
import com.hrkhty.account.exception.ResourceNotFoundException;
import com.hrkhty.account.repository.AccountRepository;
import com.hrkhty.account.repository.CustomerRepository;
import com.hrkhty.account.service.CustomerService;
import com.hrkhty.account.service.client.CardFeignClient;
import com.hrkhty.account.service.client.LoanFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import com.hrkhty.account.mapper.AccountMapper;
import com.hrkhty.account.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private CardFeignClient cardFeignClient;
    private LoanFeignClient loanFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountDto(AccountMapper.mapToAccountDto(account, new AccountDto()));

        ResponseEntity<LoanDto> loansDtoResponseEntity = loanFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoanDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardDto> cardsDtoResponseEntity = cardFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
