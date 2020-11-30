package com.mkv.designpatterns.strategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mkv.designpatterns.model.CreditCard;
import com.mkv.designpatterns.model.FileInputObject;
import com.mkv.designpatterns.model.FileOutputObject;
import com.mkv.designpatterns.util.Utility;

public class CSVFileStrategy implements FileStrategy {

	private static String COMMA_DELIMITER = ",";

	@Override
	public List<FileInputObject> readFromFile(String fileName) {
		FileInputObject fileInputObject;
		List<FileInputObject> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(COMMA_DELIMITER);
				// TODO: Convert string to Date for handling expiration
				fileInputObject = new FileInputObject(values[0], null, values[2]);
				list.add(fileInputObject);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void writeToFile(List<CreditCard> creditCardList) {
		List<FileOutputObject> fileOutputObjectList =
				Utility.creditCardToFileObjectMapper(creditCardList);
	}

	public static void main(String[] args) {
		CSVFileStrategy file = new CSVFileStrategy();
		System.out.println(file.readFromFile("test.csv"));
	}
}
