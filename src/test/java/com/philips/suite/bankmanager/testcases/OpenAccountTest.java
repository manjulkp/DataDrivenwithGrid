package com.philips.suite.bankmanager.testcases;

import java.net.MalformedURLException;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.philips.utilities.Constants;
import com.philips.utilities.DataUtil;
import com.philips.utilities.ExcelReader;


public class OpenAccountTest extends com.philips.base.TestBase {
	
	
	
	@Test(dataProviderClass=com.philips.utilities.DataProviders.class,dataProvider="bankManagerDP")
	public void openAccountTest(Hashtable<String,String> data) throws MalformedURLException{
	
		super.setUp();
		test = rep.startTest("Open Account Test"+"   "+data.get("browser"));
		setExtentTest(test);
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("BankManagerSuite", "OpenAccountTest", data.get("Runmode"), excel);
		openBrowser(data.get("browser"));
		navigate("testsiteurl");
		click("bmlBtn_CSS");
		click("openaccount_CSS");
		select("customer_CSS",data.get("customer"));
		select("currency_CSS",data.get("currency"));
		click("process_CSS");
		reportPass("Open Account test pass");
	}
	
	@AfterMethod
	public void tearDown(){
		
		if(rep!=null){
			
			rep.endTest(getExtTest());
			rep.flush();
		}
		getDriver().quit();
	}
	
	
	

}
