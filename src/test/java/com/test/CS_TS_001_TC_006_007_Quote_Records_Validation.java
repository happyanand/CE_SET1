
package com.test;

import java.text.SimpleDateFormat;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Test;

import com.pages.CensusInfo;
//import com.pages.FindApplicationPage;
import com.pages.CustomerEngageFunctionalityValidations;
import com.pages.Customer_Validations;
import com.pages.IncomeInfo;
import com.pages.SalesLeadPage;

import Common.Dateformatter;
import Common.Main;
import Utility.ExcelHelper;
public class CS_TS_001_TC_006_007_Quote_Records_Validation extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	
	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	 CensusInfo DependentInfo = new CensusInfo();
	public void Quote_validation(CensusInfo ApplicantInfo)
			throws ClassNotFoundException, Exception {
		CustomerEngageFunctionalityValidations consumerpage = new CustomerEngageFunctionalityValidations(driver);
		
		SalesLeadPage SalesLeadPage = new SalesLeadPage(driver);
		Customer_Validations Customer_Validations = new Customer_Validations(driver);
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "TC CE1");
		int rowCount = tcTestData.getLastRowNum() - tcTestData.getFirstRowNum();

		if (tcTestData != null) {

			ApplicantInfo.Zipcode = tcTestData.getRow(1).getCell(1).getStringCellValue().toString();
	    	ApplicantInfo.Email=tcTestData.getRow(1).getCell(10).getStringCellValue().toString();
	        ApplicantInfo.DOB = tcTestData.getRow(1).getCell(3).getStringCellValue().toString();     

		}

		System.out.println("******* Customer Engage Login Logout Validation TC CE001 ***************");		  
		consumerpage.login_CE_validations();
		SalesLeadPage.cttMinimize();
		Customer_Validations.Customer_Quote_validation();
		SalesLeadPage.Home_Redirection();
		Customer_Validations.check_quote();
		Customer_Validations.create_policy();
		Customer_Validations.policy_validation();
		consumerpage.logout_CE_validations();
		
	}

}
