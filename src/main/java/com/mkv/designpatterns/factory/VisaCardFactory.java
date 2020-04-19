package com.mkv.designpatterns.factory;

import java.util.Date;

import com.mkv.designpatterns.model.CreditCard;
import com.mkv.designpatterns.model.VisaCC;

public class VisaCardFactory implements CardFactory {

	@Override
	public CreditCard createCard(String cardNumber, Date expirationDate, String creditCardHolderName) {
		return new VisaCC(cardNumber, expirationDate, creditCardHolderName);
	}
}
