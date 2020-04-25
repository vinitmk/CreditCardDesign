package com.mkv.designpatterns.strategy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mkv.designpatterns.model.CreditCard;
import com.mkv.designpatterns.model.FileInputObject;
import com.mkv.designpatterns.model.FileOutputObject;
import com.mkv.designpatterns.util.Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileStrategy implements FileStrategy {

	@Override
	public List<FileInputObject> readFromFile(String fileName) {
		List<FileInputObject> inputRows = new ArrayList<>();
		FileInputObject inputObject = null;
		JSONParser jsonParser = new JSONParser();
		try(FileReader fileReader = new FileReader(fileName)){

			Object obj = jsonParser.parse(fileReader);

			JSONArray ccList = (JSONArray) obj;
			for(Object cc: ccList){
				inputRows.add(parseCreditCardObject( (JSONObject) cc ));
			}

		} catch (FileNotFoundException | ParseException e){
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return inputRows;
	}

	private FileInputObject parseCreditCardObject(JSONObject creditCard) throws java.text.ParseException {
		FileInputObject inputObject = new FileInputObject();

		inputObject.setNameOfCardHolder((String) creditCard.get("NameOfCardholder"));
		inputObject.setCardNumber(Long.toString((Long) creditCard.get("CardNumber")));
		inputObject.setExpirationDate(new SimpleDateFormat("mm/dd/yyyy").parse((String)creditCard.get("ExpirationDate")));
		return inputObject;
	}

	@Override
	public void writeToFile(List<CreditCard> creditCardList) {
		List<FileOutputObject> fileOutputObjectList = Utility.creditCardToFileObjectMapper(creditCardList);

	}

	public static void main(String[] args){

		String file = "/Users/vkallampad/Downloads/Sample.json";

		List<FileInputObject> fileList = new JSONFileStrategy().readFromFile(file);
		for (FileInputObject fileDetails: fileList) {
			System.out.println(fileDetails.getCardNumber());
			System.out.println(fileDetails.getExpirationDate());
			System.out.println(fileDetails.getNameOfCardHolder());
		}
	}
}
