package com.mkv.designpatterns.strategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.mkv.designpatterns.model.CreditCard;
import com.mkv.designpatterns.model.FileInputObject;
import com.mkv.designpatterns.model.FileOutputObject;
import com.mkv.designpatterns.util.Utility;

public class XMLFileStrategy implements FileStrategy {

	private static final String CREDIT_CARD = "creditcard";
	private static final String CREDIT_CARD_NUMBER = "cardNumber";
	private static final String CREDIT_CARD_EXP_DATE = "expirationDate";
	private static final String CREDIT_CARD_CARDHOLDER_NAME = "nameOfCardHolder";

	@Override
	public List<FileInputObject> readFromFile(String fileName) {
		String creditCardNumber = "", creditCardName = "", expDate = "";
		List<FileInputObject> fileInputObjects = new ArrayList<>();
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();

		try {
			InputStream in = new FileInputStream(fileName);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					String elementName = startElement.getName().getLocalPart();
					switch(elementName) {
						case CREDIT_CARD_NUMBER:
							event = eventReader.nextEvent();
							creditCardNumber = event.asCharacters().getData();
							break;
						case CREDIT_CARD_CARDHOLDER_NAME:
							event = eventReader.nextEvent();
							creditCardName = event.asCharacters().getData();
							break;
						case CREDIT_CARD_EXP_DATE:
							event = eventReader.nextEvent();
							expDate = event.asCharacters().getData();
					}
				}
				if(event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equals(CREDIT_CARD))
            			fileInputObjects.add(Utility.parseCreditCardObject(creditCardNumber, expDate, creditCardName));
				}
			}
		} catch (FileNotFoundException | XMLStreamException | ParseException e) {
			e.printStackTrace();
		}
		return fileInputObjects;
	}

	@Override
	public void writeToFile(List<CreditCard> creditCardList) {
//		List<FileOutputObject> fileOutputObjectList =
//				Utility.creditCardToFileObjectMapper(creditCardList);
		//System.out.println("inside xml write to file");
		for(CreditCard c: creditCardList)
			System.out.println(c);
	}

//	public static void main(String[] args) {
//		XMLFileStrategy xml = new XMLFileStrategy();
//		List<FileInputObject> list = xml.readFromFile("test.xml");
//
//		for(FileInputObject f: list)
//			System.out.println(f);
//	}
}
