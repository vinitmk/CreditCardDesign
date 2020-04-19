package com.mkv.designpatterns.model;

import java.util.Date;
import lombok.Data;

@Data
public class FileInputObject {
	String cardNumber;
	Date expirationDate;
	String nameOfCardHolder;
}
