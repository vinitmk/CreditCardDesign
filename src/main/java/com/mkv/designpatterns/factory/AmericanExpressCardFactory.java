package com.mkv.designpatterns.factory;

import java.util.Date;

import com.mkv.designpatterns.model.AmExCC;
import com.mkv.designpatterns.model.CreditCard;

public class AmericanExpressCardFactory implements CardFactory {
	@Override
	public CreditCard createCard(String cardNumber, Date expirationDate, String creditCardHolderName) {
		return new AmExCC(cardNumber, expirationDate, creditCardHolderName);
	}
}
