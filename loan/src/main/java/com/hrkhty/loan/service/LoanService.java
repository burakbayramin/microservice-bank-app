package com.hrkhty.loan.service;

import com.hrkhty.loan.dto.LoanDto;

public interface LoanService {
    void createLoan(String mobileNumber);


    LoanDto fetchLoan(String mobileNumber);


    boolean updateLoan(LoanDto loansDto);


    boolean deleteLoan(String mobileNumber);
}
