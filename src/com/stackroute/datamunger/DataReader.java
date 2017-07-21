package com.stackroute.datamunger;

public abstract class DataReader {

 
	public  abstract Header getHeader();
	
	
	public  abstract Object getColumnType();
	
	
	public abstract DataRow getDataRow();
	
}


