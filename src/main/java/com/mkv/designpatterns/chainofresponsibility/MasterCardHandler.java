package com.mkv.designpatterns.chainofresponsibility;

import com.mkv.designpatterns.model.CreditCardTypes;

public class MasterCardHandler extends CreditCardHandler {
	@Override
	public CreditCardTypes handleRequest(String creditCardNumber) {
		System.out.println("Inside Master Card Handler");
		if(isCardValid(creditCardNumber)) {
			System.out.println("Valid Mastercard Card");
			return CreditCardTypes.MasterCard;
		}
		if(null != nextHandler)
			return nextHandler.handleRequest(creditCardNumber);
		return null;
	}

	private boolean isCardValid(String cardNumber){
		return cardNumber.charAt(0) == '5' &&
				(cardNumber.charAt(1) >= '1' && cardNumber.charAt(1) <= '5') &&
				cardNumber.length() == 16;
	}
}
