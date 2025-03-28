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

import Common.Dateformatter;
import Common.Main;
import Utility.ExcelHelper;
public class TC_CE_002_Landingpage_Validation extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	
	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	 CensusInfo DependentInfo = new CensusInfo();
	public void EG_TC_CE2(CensusInfo ApplicantInfo)
			throws ClassNotFoundException, Exception {
		CustomerEngageFunctionalityValidations consumerpage = new CustomerEngageFunctionalityValidations(driver);
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "TC CE1");
		int rowCount = tcTestData.getLastRowNum() - tcTestData.getFirstRowNum();
  
		
		if (tcTestData != null) {

			ApplicantInfo.Zipcode = tcTestData.getRow(1).getCell(1).getStringCellValue().toString();
	    	ApplicantInfo.Email=tcTestData.getRow(1).getCell(10).getStringCellValue().toString();
	        ApplicantInfo.DOB = tcTestData.getRow(1).getCell(3).getStringCellValue().toString();     

		}

		System.out.println("******* Customer Engage LandingPage Validation TC CE002 ***************");	
		//methods
		consumerpage.login_CE_validations();
	    consumerpage.landing_page_validations_MarketingTile();
     	consumerpage.landing_page_validations_SaleTile();
	    consumerpage.landing_page_validations_CustomerTile();
	    consumerpage.landing_page_validation_AgencyTile();
	    consumerpage.landing_page_validation_ServiceTile();
	    consumerpage.landing_page_validation_IVR_ManagementTile();
		consumerpage.landing_page_validation_AdminTile();
		consumerpage.landing_page_validation_ReportTile();
		consumerpage.landing_page_validation_DashBoardTile();
		consumerpage.landing_page_validation_CommissionTile();
		
		
		
		consumerpage.logout_CE_validations();
		
	}

}
