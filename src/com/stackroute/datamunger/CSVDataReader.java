package com.stackroute.datamunger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.file.fileheader.HeaderRow;

public class CSVDataReader extends DataReader
{
	Header header;
	
	String fileName;

	public CSVDataReader(String fileName) {
		this.fileName=fileName;
	}
	@Override
	public Header getHeader() {
		
		BufferedReader bufferreader=null;
	
		try {
			bufferreader = new BufferedReader(new FileReader(fileName));
		
		 header=new Header();
		
		if(bufferreader!=null)
		{
			String row=bufferreader.readLine();
			String rowvalues[]=row.split(",");
			int colindex=0;
			for(String columnName:rowvalues)
			{
				header.put(columnName,colindex);
				colindex++;
			}
			
		}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return header;

			}

	@Override
	public Object getColumnType() {
		
		return null;
	}

	@Override
	public DataRow getDataRow() {
		
		return null;
	}

}
