package com.mkv.designpatterns.model;

import java.util.Date;

public class DiscoverCC extends CreditCard {

    public DiscoverCC(String cardNumber, Date expirationDate, String creditCardHolderName){
        super(CreditCardTypes.DISCOVER.name(), cardNumber, expirationDate, creditCardHolderName);
        System.out.println("Discover Credit Card Object Created");
    }

}
