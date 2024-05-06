import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.digester.ObjectParamRule

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable
import objectPath.ObjectPathManagement

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.cucumber.keyword.internal.CucumberGlueGenerator

import helpers.WebActions
import helpers.PropertyReader

class Hooks {

	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */

	WebActions webactions = new WebActions()
	ObjectPathManagement objectPathManagement = new ObjectPathManagement()

	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		
//		to run the feature file
		CucumberGlueGenerator.addDefaultPackages();

		//Launch browser and navigate to URL
		PropertyReader reader = new PropertyReader()

		WebUI.openBrowser('')
		WebUI.navigateToUrl(reader.readPropertyFileData("appURL"))

		WebUI.maximizeWindow()


//		webactions.click(objectPathManagement.getObjectPath("LoginHeader","LoginPage"))
//		webactions.sendKeys(objectPathManagement.getObjectPath("UsernameField", "LoginPage"),reader.readPropertyFileData("userName"))
//		webactions.sendKeys(objectPathManagement.getObjectPath("PasswordField", "LoginPage"),reader.readPropertyFileData("password"))
//
//		webactions.click(objectPathManagement.getObjectPath("LoginButton","LoginPage"))
		
//		String currentUrl = WebUI.getUrl()
//		String expectedSubstring = 'index.html'
//		assert currentUrl.contains(expectedSubstring)
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		WebUI.closeBrowser()
	}

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
	}
}