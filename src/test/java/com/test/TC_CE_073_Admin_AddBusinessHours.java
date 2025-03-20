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
import com.pages.IncomeInfo;
import com.pages.SalesLeadPage;

import Common.Dateformatter;
import Common.Main;
import Utility.ExcelHelper;
public class TC_CE_073_Admin_AddBusinessHours extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo(); 
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	
	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	 CensusInfo DependentInfo = new CensusInfo();
	public void EG_TC_CE73(CensusInfo ApplicantInfo)
			throws ClassNotFoundException, Exception {
		CustomerEngageFunctionalityValidations consumerpage = new CustomerEngageFunctionalityValidations(driver);
		SalesLeadPage SalesLeadPage = new SalesLeadPage(driver);
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "TC CE2");
		int rowCount = tcTestData.getLastRowNum() - tcTestData.getFirstRowNum();

		if (tcTestData != null) {

			ApplicantInfo.Zipcode = tcTestData.getRow(1).getCell(1).getStringCellValue().toString();
	    	ApplicantInfo.Email=tcTestData.getRow(1).getCell(10).getStringCellValue().toString();
	        ApplicantInfo.DOB = tcTestData.getRow(1).getCell(3).getStringCellValue().toString();     
	        ApplicantInfo.LastName = tcTestData.getRow(1).getCell(8).getStringCellValue().toString();

		}

		System.out.println("******* Customer Engage Agency Agent_License TC CE046 ***************");		  
		consumerpage.login_CE_validations();
		SalesLeadPage.cttMinimize(); 
		consumerpage.admin_AddBuissnessHour();
		consumerpage.logout_CE_validations(); 
		
	}

}
