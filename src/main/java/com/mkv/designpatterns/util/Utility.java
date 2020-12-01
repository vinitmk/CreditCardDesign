package com.mkv.designpatterns.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mkv.designpatterns.model.CreditCard;
import com.mkv.designpatterns.model.CreditCardTypes;
import com.mkv.designpatterns.model.FileInputObject;
import com.mkv.designpatterns.model.FileOutputObject;
import org.json.simple.JSONObject;

public class Utility {

	public static List<FileOutputObject> creditCardToFileObjectMapper(List<CreditCard> creditCardList){
		FileOutputObject fileOutputObject;
		List<FileOutputObject> fileOutputObjectList = new ArrayList<>();

		for (CreditCard creditCard: creditCardList) {
			fileOutputObject = new FileOutputObject();
			fileOutputObject.setCardNumber(creditCard.getCardNumber());
			fileOutputObject.setCardType(creditCard.getType().name());
			if(creditCard.getType() != CreditCardTypes.Invalid)
				fileOutputObject.setError("None");
			else
				fileOutputObject.setError("Invalid");
			fileOutputObjectList.add(fileOutputObject);
		}
		return fileOutputObjectList;
	}

	public static FileInputObject parseCreditCardObject(JSONObject creditCard) throws java.text.ParseException {
		FileInputObject inputObject = new FileInputObject();

		inputObject.setNameOfCardHolder((String) creditCard.get("NameOfCardholder"));
		inputObject.setCardNumber(Long.toString((Long) creditCard.get("CardNumber")));
		inputObject.setExpirationDate(new SimpleDateFormat("mm/dd/yyyy").parse((String)creditCard.get("ExpirationDate")));
		return inputObject;
	}

	public static FileInputObject parseCreditCardObject(String cardNumber, String expDate, String name) throws ParseException {
		FileInputObject inputObject = new FileInputObject();
		inputObject.setCardNumber(cardNumber);
		inputObject.setExpirationDate(new SimpleDateFormat("mm/dd/yyyy").parse(expDate));
		inputObject.setNameOfCardHolder(name);

		return inputObject;
	}
}
