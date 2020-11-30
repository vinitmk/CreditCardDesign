package com.mkv.designpatterns.strategy;

import lombok.Data;
import org.apache.commons.io.FilenameUtils;

@Data
public class FileContext {

	FileStrategy strategy;

	public void chooseFileStrategy(String inputFileName){
		String fileExt = FilenameUtils.getExtension(inputFileName);

		switch(fileExt){
		case "csv": strategy = new CSVFileStrategy();
					break;
		case "json": strategy = new JSONFileStrategy();
					break;
		case "xml": strategy = new XMLFileStrategy();
					break;
		default: strategy = null;
		}
	}
}
