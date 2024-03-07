package com.hrkhty.account.service.client;

import com.hrkhty.account.dto.LoanDto;
import jakarta.validation.constraints.Pattern;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("loan")
public interface LoanFeignClient {

    @GetMapping(value = "/api/loans", consumes = "application/json")
    public ResponseEntity<LoanDto> fetchLoanDetails(@RequestHeader("bank-correlation-id") String correlationId, @RequestParam String mobileNumber);
}
