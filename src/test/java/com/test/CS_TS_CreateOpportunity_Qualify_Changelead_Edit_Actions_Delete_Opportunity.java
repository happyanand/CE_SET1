package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.BasePackage.Base_Class;
import com.pages.CensusInfo;
import com.pages.CustomerEngageFunctionalityValidations;
import com.pages.Customer_Validations;
import com.pages.SalesLeadPage;

import Utility.ExcelHelper;

public class CS_TS_CreateOpportunity_Qualify_Changelead_Edit_Actions_Delete_Opportunity extends Base_Class {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	
	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	 CensusInfo DependentInfo = new CensusInfo();
	public void New_Opportunity__validation(CensusInfo ApplicantInfo)
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

		System.out.println("******* Createlead_Convert_Opportunity validation_Qualifyopportunity_Changedealstatus ***************");		  
		consumerpage.login_CE_validations();
		SalesLeadPage.cttMinimize();
		SalesLeadPage.Lead_Qualify_and_Convert();
		SalesLeadPage.Home_Redirection();
		SalesLeadPage.Opportunity_redirection();
		SalesLeadPage.Qualify_Opportunity();
		SalesLeadPage.Changedealstatus();
		SalesLeadPage.Edit_Opportunity();
		SalesLeadPage.opportunityActions();
		SalesLeadPage.Delete_Opportunity();
		consumerpage.logout_CE_validations();
	}
}
