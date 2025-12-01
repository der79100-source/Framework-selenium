package Raj.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	
	public List<HashMap<String,String>> getJsonDataToMap() throws Exception
	{
		//read JSON to String
		File file = new File("C:\\Users\\Appadurai\\eclipse-workspace\\FrameworkSelenium\\src\\test\\java\\Raj\\data\\purchaseorder.json");
		String Jsoncontent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		
		//String to HashMap -- uses Jackson Databind dependency
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(Jsoncontent, new TypeReference<List<HashMap<String, String>>>(){});
		
		return data;
		
		//FileUtils.readFileToString(null, null)
//readFileToString(new File("C:\\Users\\Appadurai\\eclipse-workspace\\FrameworkSelenium\\src\\test\\java\\Raj\\data\\purchaseorder.json"));
	}
}
