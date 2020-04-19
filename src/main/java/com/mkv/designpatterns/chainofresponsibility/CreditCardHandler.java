package com.mkv.designpatterns.chainofresponsibility;

import com.mkv.designpatterns.model.CreditCardTypes;

public abstract class CreditCardHandler {

	protected CreditCardHandler nextHandler;

	public void setNextHandler(CreditCardHandler handler){
		nextHandler = handler;
	}

	public abstract CreditCardTypes handleRequest(String creditCardNumber);
}
