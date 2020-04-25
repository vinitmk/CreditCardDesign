package com.mkv.designpatterns.factory;

import java.util.Date;

import com.mkv.designpatterns.model.CreditCard;
import com.mkv.designpatterns.model.InvalidCC;

public class InvalidCardFactory implements CardFactory {
	@Override
	public CreditCard createCard(String cardNumber, Date expirationDate, String creditCardHolderName) {
		return new InvalidCC(cardNumber, creditCardHolderName, expirationDate);
	}
}
