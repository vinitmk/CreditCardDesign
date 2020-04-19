package com.mkv.designpatterns.model;

import java.util.Date;

public class MasterCC extends CreditCard {

    public MasterCC(String cardNumber, Date expirationDate, String creditCardHolderName){
        super(CreditCardTypes.MASTERCARD.name(), cardNumber,expirationDate,creditCardHolderName);
        System.out.println("Master Credit Card Object Created");
    }
}
