package com.mkv.designpatterns.model;

import java.util.Date;

public class InvalidCC extends CreditCard {
	public InvalidCC(String cardNumber, String creditCardHolderName, Date expirationDate) {
		super(cardNumber, creditCardHolderName, expirationDate, CreditCardTypes.Invalid);
	}
}
