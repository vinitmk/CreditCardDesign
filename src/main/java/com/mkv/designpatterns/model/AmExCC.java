package com.mkv.designpatterns.model;

import java.util.Date;

public class AmExCC extends CreditCard {

    public AmExCC(String cardNumber, Date expirationDate, String creditCardHolderName){
        super(cardNumber, creditCardHolderName, expirationDate, CreditCardTypes.AmericanExpress);
        System.out.println("American Express Credit Card Object Created");
    }
}
