package com.mkv.designpatterns.model;

import java.util.Date;

public class VisaCC extends CreditCard {

    public VisaCC(String cardNumber, Date expirationDate, String creditCardHolderName){
        super(cardNumber, creditCardHolderName, expirationDate, CreditCardTypes.Visa);
      //  System.out.println("Visa Credit Card Object Created");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
