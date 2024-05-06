

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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import internal.GlobalVariable
import objectPath.ObjectPathManagement

import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.BrowserType
import org.testng.Assert
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
import groovy.swing.factory.WidgetFactory
import helpers.PropertyReader
import helpers.WebActions
import static org.junit.Assert.assertTrue

import javax.crypto.EncryptedPrivateKeyInfo




class BuyProduct {

	PropertyReader reader  = new PropertyReader()
	WebActions webActions = new WebActions()
	ObjectPathManagement objectPathKeywords = new ObjectPathManagement()


	@Given("I click on (.*) from (.*)")
	def clickOnElement(String element,String pageName) {
		String objectPath = objectPathKeywords.getObjectPath(element, pageName)
		webActions.click(objectPath)
	}

	@And("Get the (.*) from (.*) and store in (.*)")
	def getTextOfTheElement(String element,String pageName,String propertyfile) {
		webActions.waitForPageLoad(10)
		if (element.contains("ProductName")) {
			String objectPath = objectPathKeywords.getObjectPath(element, pageName)
			String getTextValue = webActions.getText(objectPath)
			reader.writePropertyFileData("ProductName", getTextValue)
		}
		else if(element.contains("ProductPrice")){
			String objectPath = objectPathKeywords.getObjectPath(element, pageName)
			webActions.waitForElementPresent(objectPath, 20)
			String getTextValue = webActions.getText(objectPath)
			def numericValue = getTextValue.replaceAll(/\D/, '')
			println numericValue
			reader.writePropertyFileData("ProductPrice", numericValue)
		}

		else {
			String objectPath = objectPathKeywords.getObjectPath(element, pageName)
			webActions.waitForElementPresent(objectPath, 20)
			String getTextValue = webActions.getText(objectPath)
			reader.writePropertyFileData("PropertyKey", getTextValue)
		}
	}



	@Then("I verify alertpopup contains (.*) text")
	def verifyAlertText(String text) {
		String getElementText = webActions.getAlertText()
		println ("getElementText"+getElementText)
		Assert.assertEquals(getElementText, text)
		sleep(5000)
		webActions.acceptAlert()
	}


	@Then("I can see that (.*) from (.*) contains (.*)")
	def verifyAndAssertgetText(String element , String pageName,String text) {
		if (element.contains("Title")) {
			String objectPath1 = objectPathKeywords.getObjectPath(element, pageName)
			String getTextValue = webActions.getText(objectPath1)
			Assert.assertEquals(getTextValue,reader.readPropertyFileData("ProductName"))
		}

		else if (element.contains("Price")) {
			String objectPath1 = objectPathKeywords.getObjectPath(element, pageName)
			String getTextValue = webActions.getText(objectPath1)
			Assert.assertEquals(getTextValue,reader.readPropertyFileData("ProductPrice"))
		}
		else {
			String objectPath1 = objectPathKeywords.getObjectPath(element, pageName)
			String getTextValue = webActions.getText(objectPath1)
			Assert.assertEquals(getTextValue,text)
		}
	}


	@And("I type (.*) to the (.*) field in (.*)")
	def typeValueToTheTextBox(String value, String element,String pageName) {
		if(value.contains("randomName")) {
			String generateRandomName = webActions.generateRandomString(5)
			String objectPath = objectPathKeywords.getObjectPath(element, pageName)
			webActions.sendKeys(objectPath, generateRandomName)
			sleep(500)
		}
		else if(value.contains("randomNumber")) {
			String generateRandomNumber = webActions.generateRandomNumber()
			String objectPath = objectPathKeywords.getObjectPath(element, pageName)
			webActions.sendKeys(objectPath, generateRandomNumber)
		}
		else {
			String objectPath = objectPathKeywords.getObjectPath(element, pageName)
			webActions.sendKeys(objectPath, value)
		}
	}

	@And("I mouseover to the (.*) from (.*)")
	def mouseOverToTheElement(String element,String pageName) {
		String objectPath = objectPathKeywords.getObjectPath(element, pageName)
		webActions.mouseOverElement(objectPath)
		WebUI.delay(10)
	}

	@And("I use (.*) to delete the text field")
	def backspace(String backSpace) {
		webActions.deleteTextField()
	}


	@When("I minimize the browser window")
	def minimizeWindow() {
		webActions.zoomBrowser()
	}



	
}