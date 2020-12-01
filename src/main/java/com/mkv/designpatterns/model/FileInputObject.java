package com.mkv.designpatterns.model;

import java.io.File;
import java.util.Date;
import lombok.Data;

@Data
public class FileInputObject {
	String cardNumber;
	Date expirationDate;
	String nameOfCardHolder;

	public FileInputObject(){

	}

	public FileInputObject(String cardNumber, Date expirationDate, String nameOfCardHolder) {
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.nameOfCardHolder = nameOfCardHolder;
	}

	@Override
	public String toString() {
		return "FileInputObject{" +
				"cardNumber='" + cardNumber + '\'' +
				", expirationDate=" + expirationDate +
				", nameOfCardHolder='" + nameOfCardHolder + '\'' +
				'}';
	}
}
