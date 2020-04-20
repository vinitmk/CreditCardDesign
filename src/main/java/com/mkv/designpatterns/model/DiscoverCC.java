package com.mkv.designpatterns.model;

import java.util.Date;

public class DiscoverCC extends CreditCard {

    public DiscoverCC(String cardNumber, Date expirationDate, String creditCardHolderName){
        super(cardNumber, creditCardHolderName, expirationDate, CreditCardTypes.Discover);
        System.out.println("Discover Credit Card Object Created");
    }

}
