package com.mkv.designpatterns.model;

import java.util.Date;

public class AmExCC extends CreditCard {

    public AmExCC(String cardNumber, Date expirationDate, String creditCardHolderName){
        super(CreditCardTypes.AMERICANEXPRESS.name(), cardNumber, expirationDate, creditCardHolderName);
        System.out.println("American Express Credit Card Object Created");
    }
}
