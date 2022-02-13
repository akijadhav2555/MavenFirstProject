package com.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class LoginTest extends BaseClass {
	@BeforeSuite
	public void setup(){
		intialisation();
		reportinit();
	}
	@AfterSuite
	public void tearDown(){
		driver.close();
		report.flush();
	}
	@Test
	public void test01(){
		test=report.createTest("test 01");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	@Test
	public void test02(){
		test=report.createTest("test 02");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@Test
	public void test03(){
		test=report.createTest("test 03");
		throw new SkipException("skipping test case");
		
	}
	
	@Test
	public void test04(){
		test=report.createTest("test 03");
		throw new SkipException("skipping test case");
		
	}

}
