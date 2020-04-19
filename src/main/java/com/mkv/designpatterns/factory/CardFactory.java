package com.mkv.designpatterns.factory;

import java.util.Date;

import com.mkv.designpatterns.model.CreditCard;

public interface CardFactory {
    public CreditCard createCard(String cardNumber, Date expirationDate, String creditCardHolderName);
}
