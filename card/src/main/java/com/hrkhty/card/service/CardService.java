package com.hrkhty.card.service;

import com.hrkhty.card.dto.CardDto;

public interface CardService {


    void createCard(String mobileNumber);

    CardDto fetchCard(String mobileNumber);


    boolean updateCard(CardDto cardDto);

    boolean deleteCard(String mobileNumber);

}
