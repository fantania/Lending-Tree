package com.fantine.model;

import org.apache.commons.lang3.RandomStringUtils;


public class IdGenerator {
	
	
	private static long last = 0;
	private static final long MAX = 100000L;
	
	public static long getID()
	{
		 // 10 digits.
		  long id = System.currentTimeMillis() % MAX;
		  if ( id <= last ) {
		    id = (last + 1) % MAX;
		  }
		  return last = id;
	}
	
	//@Test
	public static String generateId() {
	    String generatedString = RandomStringUtils.randomAlphanumeric(5);
	 
	    return generatedString;
	}

}
