package test;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.file.fileheader.HeaderRow;
import com.file.fileheader.Query;
import com.file.fileheader.QueryParser;

public class TestCsv {
	static Query query;
	static QueryParser queryParser;
	static HeaderRow headerRow;
	static Map<String,Integer> expectedHeaders,actualHeaders ;
	static String queryString;

	@BeforeClass
	public static void intialise() throws Exception {

		queryString = "select empid,empname from  d://emp.csv where empid=101 and empname='raju' order by empname";
		
		queryParser = new QueryParser();

		query = queryParser.parseQuery(queryString);
		headerRow = query.getHeaderRow(query);
		
		expectedHeaders = new LinkedHashMap<String,Integer>();
	
	        
		actualHeaders = new LinkedHashMap<String,Integer>();
		actualHeaders=headerRow.getFirstRow();
	}

@Test
	public void testHeaders() throws Exception {
	expectedHeaders.put("empid",0);
	expectedHeaders.put("empname",1);
	expectedHeaders.put("empsal",2);
	expectedHeaders.put("empdept",4);
		assertEquals("File Headers are correct",expectedHeaders,actualHeaders);

	}
}
