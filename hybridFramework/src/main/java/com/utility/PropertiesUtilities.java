package com.utility;

import java.io.FileInputStream;
import java.util.Properties;

import com.base.BaseClass;

public class PropertiesUtilities extends BaseClass {
	static public FileInputStream fis=null;
	public static String readproperty(String key){
		log.info("reading a property file for a key"+key);
	Properties prop=new Properties();
	try{
		fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		prop.load(fis);
		}
	catch(Exception e){
		log.error("value not find in config  file");
		e.printStackTrace();
		
	}
	log.info("value assigned for the key is found as>>"+prop.getProperty(key));
	return prop.getProperty(key);
	
	
	
	
	
	
	}
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir")+"src/main/resources/config.properties");
		
	
}
}
