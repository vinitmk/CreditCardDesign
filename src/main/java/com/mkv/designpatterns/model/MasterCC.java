package com.mkv.designpatterns.model;

import java.util.Date;

public class MasterCC extends CreditCard {

    public MasterCC(String cardNumber, Date expirationDate, String creditCardHolderName){
        super(cardNumber, creditCardHolderName, expirationDate, CreditCardTypes.MasterCard);
       // System.out.println("Master Credit Card Object Created");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
