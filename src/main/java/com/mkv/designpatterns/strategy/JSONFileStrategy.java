package com.mkv.designpatterns.strategy;

import java.util.List;

import com.mkv.designpatterns.model.CreditCard;
import com.mkv.designpatterns.model.FileInputObject;
import com.mkv.designpatterns.model.FileOutputObject;
import com.mkv.designpatterns.util.Utility;

public class JSONFileStrategy implements FileStrategy {

	@Override
	public List<FileInputObject> readFromFile(String fileName) {
		return null;
	}

	@Override
	public void writeToFile(List<CreditCard> creditCardList) {
		List<FileOutputObject> fileOutputObjectList = Utility.creditCardToFileObjectMapper(creditCardList);

	}
}
