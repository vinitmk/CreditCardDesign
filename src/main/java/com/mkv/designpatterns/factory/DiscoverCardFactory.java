package com.mkv.designpatterns.factory;

import java.util.Date;

import com.mkv.designpatterns.model.CreditCard;
import com.mkv.designpatterns.model.DiscoverCC;

public class DiscoverCardFactory implements CardFactory {
	@Override
	public CreditCard createCard(String cardNumber, Date expirationDate, String creditCardHolderName) {
		return new DiscoverCC(cardNumber, expirationDate, creditCardHolderName);
	}
}
