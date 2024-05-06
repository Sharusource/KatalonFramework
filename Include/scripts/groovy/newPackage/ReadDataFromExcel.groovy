package newPackage
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import objectPath.ObjectPathManagement

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import helpers.PropertyReader
import helpers.WebActions



class ReadDataFromExcel {

	PropertyReader reader  = new PropertyReader()
	WebActions webActions = new WebActions()
	ObjectPathManagement objectPathKeywords = new ObjectPathManagement()

	@And("Read (.*) from excel and pass it to the (.*) in (.*)")
	def getData_Pass_Into_InputField(String value,String element,String pageName){
		String objectPath = objectPathKeywords.getObjectPath(element, pageName)

//		for(def row=1;row<=findTestData('LoginData').getRowNumbers();row++) 
//		use this for loop if you have multiple row of data in exceldata file

			if(value.contains("username")) {
				println(findTestData('LoginData').getValue('username', 1))
				webActions.sendKeys(objectPath,findTestData('LoginData').getValue('username', 1))
			}
			else if(value.contains("password")) {
				println(findTestData('LoginData').getValue('password', 2))
				webActions.sendKeys(objectPath,findTestData('LoginData').getValue('password', 1))
			}
		
	}
}