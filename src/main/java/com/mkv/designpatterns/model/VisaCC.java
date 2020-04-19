package com.mkv.designpatterns.model;

import lombok.Data;

import java.util.Date;
@Data
public class VisaCC extends CreditCard {

    public VisaCC(String cardNumber, Date expirationDate, String creditCardHolderName){
        super(CreditCardTypes.VISA.name(), cardNumber, expirationDate, creditCardHolderName);
        System.out.println("Visa Credit Card Object Created");
    }
}
