package com.mkv.designpatterns.chainofresponsibility;

import com.mkv.designpatterns.model.CreditCardTypes;

public class DiscoverCardHandler extends CreditCardHandler {
	@Override
	public CreditCardTypes handleRequest(String creditCardNumber) {
//		System.out.println("Inside Discover Card Handler");
		if(isCardValid(creditCardNumber)){
//			System.out.println("Valid Discover Card");
			return CreditCardTypes.Discover;
		}
		if(null != nextHandler)
			return nextHandler.handleRequest(creditCardNumber);
		return null;

	}

	private boolean isCardValid(String cardNumber){
		return cardNumber.charAt(0) == '6' &&
				cardNumber.charAt(1) == '0' &&
				cardNumber.charAt(2) == '1' &&
				cardNumber.charAt(3) == '1' &&
				cardNumber.length() == 16;
	}
}
