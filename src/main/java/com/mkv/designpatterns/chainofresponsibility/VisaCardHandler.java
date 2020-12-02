package com.mkv.designpatterns.chainofresponsibility;

import com.mkv.designpatterns.model.CreditCardTypes;

public class VisaCardHandler extends CreditCardHandler {

	@Override
	public CreditCardTypes handleRequest(String creditCardNumber) {
	//	System.out.println("Inside Visa Card Handler");
		if(isCardValid(creditCardNumber)) {
		//	System.out.println("Valid Visa Card");
			return CreditCardTypes.Visa;
		}
		if(null != nextHandler)
			return nextHandler.handleRequest(creditCardNumber);
		return null;
	}

	private boolean isCardValid(String cardNumber){
		return (cardNumber.length() == 13 || cardNumber.length() == 16) &&
				cardNumber.charAt(0) == '4';
	}
}
