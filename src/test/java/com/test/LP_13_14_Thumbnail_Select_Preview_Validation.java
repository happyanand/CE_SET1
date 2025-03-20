package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.pages.CensusInfo;
import com.pages.CustomerEngageFunctionalityValidations;
import com.pages.CustomersCreationPage;
import com.pages.Landing_Page;
import com.pages.SalesLeadPage;

import Utility.ExcelHelper;

public class LP_13_14_Thumbnail_Select_Preview_Validation extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	
	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	 CensusInfo DependentInfo = new CensusInfo();
	public void NewLandingpage_Thumbnail_Validations()
			throws ClassNotFoundException, Exception {
		CustomerEngageFunctionalityValidations consumerpage = new CustomerEngageFunctionalityValidations(driver);
		SalesLeadPage SalesLeadPage = new SalesLeadPage(driver);
		Landing_Page Landingpage = new Landing_Page(driver);
		CustomersCreationPage CustomersCreationPage = new CustomersCreationPage(driver);
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "TC CE1");
		int rowCount = tcTestData.getLastRowNum() - tcTestData.getFirstRowNum();

		if (tcTestData != null) {

			ApplicantInfo.Zipcode = tcTestData.getRow(1).getCell(1).getStringCellValue().toString();
	    	ApplicantInfo.Email=tcTestData.getRow(1).getCell(10).getStringCellValue().toString();
	        ApplicantInfo.DOB = tcTestData.getRow(1).getCell(3).getStringCellValue().toString();     

		}

		System.out.println("******* New landing page thumbnail,preview and select validations ***************");  
		consumerpage.login_CE_validations();
		SalesLeadPage.cttMinimize();
		Landingpage.Launch_Landing_page();
		Landingpage.New_landing_Page();
		Landingpage.Thumbnail_Validation();
		Landingpage.Select_Preview_Validations();
		consumerpage.logout_CE_validations();
		
		
	}

}
