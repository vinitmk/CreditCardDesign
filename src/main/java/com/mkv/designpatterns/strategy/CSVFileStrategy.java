package com.mkv.designpatterns.strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import com.mkv.designpatterns.model.CreditCard;
import com.mkv.designpatterns.model.FileInputObject;
import com.mkv.designpatterns.model.FileOutputObject;
import com.mkv.designpatterns.util.Utility;

public class CSVFileStrategy implements FileStrategy {

	@Override
	public List<FileInputObject> readFromFile(String fileName) {
		List<FileInputObject> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String COMMA_DELIMITER = ",";
				String[] values = line.split(COMMA_DELIMITER);
				list.add(Utility.parseCreditCardObject(values[0], values[1], values[2]));
			}
		}
		catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void writeToFile(List<CreditCard> creditCardList) {
//		List<FileOutputObject> fileOutputObjectList =
//				Utility.creditCardToFileObjectMapper(creditCardList);
	}

//	public static void main(String[] args) {
//		CSVFileStrategy file = new CSVFileStrategy();
//		System.out.println(file.readFromFile("test.csv"));
//	}
}
