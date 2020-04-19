package com.mkv.designpatterns.factory;

import java.util.Date;

import com.mkv.designpatterns.model.CreditCard;
import com.mkv.designpatterns.model.MasterCC;

public class MasterCardFactory implements CardFactory {
	@Override
	public CreditCard createCard(String cardNumber, Date expirationDate, String creditCardHolderName) {
		return new MasterCC(cardNumber, expirationDate, creditCardHolderName);
	}
}
