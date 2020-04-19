package com.mkv.designpatterns.chainofresponsibility;

import com.mkv.designpatterns.model.CreditCardTypes;

public class AmericanExpressCardHandler extends CreditCardHandler {
	@Override
	public CreditCardTypes handleRequest(String creditCardNumber) {
		System.out.println("Inside American Express Card Handler");
		if(isCardValid(creditCardNumber)) {
			System.out.println("Valid American Express Card");
			return CreditCardTypes.AMERICANEXPRESS;
		}
		if(null != nextHandler)
			return nextHandler.handleRequest(creditCardNumber);
		return null;
	}

	private boolean isCardValid(String cardNumber){
		return cardNumber.charAt(0) == '3' &&
				(cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7') &&
				cardNumber.length() == 15;
	}
}
