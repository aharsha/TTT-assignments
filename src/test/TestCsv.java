package test;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;


import com.stackroute.datamunger.CSVDataReader;
import com.stackroute.datamunger.Header;

public class TestCsv {
	
	static Header header;
static Map<String,Integer> expectedHeaders,actualHeaders ;
	static String queryString;
static CSVDataReader cSVDataReader;
	@BeforeClass
	public static void intialise() throws Exception {

		
		queryString = "d://emp.csv";
		
		cSVDataReader=new CSVDataReader(queryString);
		

		//query = queryParser.parseQuery(queryString);
		
		
		expectedHeaders = new LinkedHashMap<String,Integer>();
	
	        
		actualHeaders = new LinkedHashMap<String,Integer>();
		actualHeaders=cSVDataReader.getHeader();
	}

@Test
	public void testHeaders() throws Exception {
	expectedHeaders.put("EmpId",0);
	expectedHeaders.put("Name",1);
	expectedHeaders.put("City",2);
	expectedHeaders.put("Salary",3);
	expectedHeaders.put("Dept",4);
		assertEquals("File Headers are correct",expectedHeaders,actualHeaders);

	}
}
