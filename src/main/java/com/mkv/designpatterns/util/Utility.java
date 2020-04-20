package com.mkv.designpatterns.util;

import java.util.ArrayList;
import java.util.List;

import com.mkv.designpatterns.model.CreditCard;
import com.mkv.designpatterns.model.CreditCardTypes;
import com.mkv.designpatterns.model.FileOutputObject;

public class Utility {

	public static List<FileOutputObject> creditCardToFileObjectMapper(List<CreditCard> creditCardList){
		FileOutputObject fileOutputObject = null;
		List<FileOutputObject> fileOutputObjectList = new ArrayList<>();

		for (CreditCard creditCard: creditCardList) {
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
}
