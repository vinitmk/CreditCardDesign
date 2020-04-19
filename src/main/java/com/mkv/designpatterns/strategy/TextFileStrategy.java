package com.mkv.designpatterns.strategy;

import java.util.List;

import com.mkv.designpatterns.model.FileInputObject;
import com.mkv.designpatterns.model.FileOutputObject;

public class TextFileStrategy implements FileStrategy {

	@Override
	public List<FileInputObject> readFromFile(String fileName) {
		return null;
	}

	@Override
	public void writeToFile(List<FileOutputObject> fileObjects) {

	}
}
