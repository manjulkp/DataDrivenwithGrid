package com.philips.suite.bankmanager.testcases;

import java.net.MalformedURLException;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.philips.base.TestBase;
import com.philips.utilities.Constants;
import com.philips.utilities.DataProviders;
import com.philips.utilities.DataUtil;
import com.philips.utilities.ExcelReader;



public class AddCustomerTest extends TestBase {
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="bankManagerDP")
	public void addCustomerTest(Hashtable<String,String> data) throws MalformedURLException{
		
		super.setUp();
		test = rep.startTest("Add Customer Test"+"   "+data.get("browser"));		
		setExtentTest(test);
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("BankManagerSuite", "AddCustomerTest", data.get("Runmode"), excel);
		
		openBrowser(data.get("browser"));
		navigate("testsiteurl");
		
		click("bmlBtn_CSS");
		click("addCustBtn_CSS");
		type("firstname_CSS",data.get("firstname"));
		type("lastname_XPATH",data.get("lastname"));
		type("postcode_CSS",data.get("postcode"));
		click("addbtn_CSS");
		
		reportPass("Add customer test pass");
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
