package com.mkv.designpatterns.strategy;

import java.util.List;

import com.mkv.designpatterns.model.CreditCard;
import com.mkv.designpatterns.model.FileInputObject;
import com.mkv.designpatterns.model.FileOutputObject;

public interface FileStrategy {

	public List<FileInputObject> readFromFile(String fileName);

	public void writeToFile(List<CreditCard> creditCardList);
}
