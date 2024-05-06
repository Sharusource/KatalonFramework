
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import org.openqa.selenium.WebDriver

import org.openqa.selenium.By

import com.kms.katalon.core.testobject.TestObject

import org.openqa.selenium.WebElement



def static "objectPath.ObjectPathManagement.getObjectPath"(
    	String element	
     , 	String page	) {
    (new objectPath.ObjectPathManagement()).getObjectPath(
        	element
         , 	page)
}


def static "helpers.PropertyReader.readPropertyFileData"(
    	String key	) {
    (new helpers.PropertyReader()).readPropertyFileData(
        	key)
}


def static "helpers.PropertyReader.writePropertyFileData"(
    	String key	
     , 	String value	) {
    (new helpers.PropertyReader()).writePropertyFileData(
        	key
         , 	value)
}


def static "helpers.FirstQuery.connectDB"(
    	String url	
     , 	String dbname	
     , 	String port	
     , 	String username	
     , 	String password	) {
    (new helpers.FirstQuery()).connectDB(
        	url
         , 	dbname
         , 	port
         , 	username
         , 	password)
}


def static "helpers.FirstQuery.executeQuery"(
    	String queryString	) {
    (new helpers.FirstQuery()).executeQuery(
        	queryString)
}


def static "helpers.FirstQuery.executeQuery1"(
    	String queryString	) {
    (new helpers.FirstQuery()).executeQuery1(
        	queryString)
}

 /***
	 * Get Risk title
	 */ 
def static "helpers.FirstQuery.executeQueryRisk"(
    	String queryString	) {
    (new helpers.FirstQuery()).executeQueryRisk(
        	queryString)
}

 /***
	 * Get Action Outcome
	 */ 
def static "helpers.FirstQuery.executeQueryAction"(
    	String queryString	) {
    (new helpers.FirstQuery()).executeQueryAction(
        	queryString)
}


def static "helpers.FirstQuery.closeDatabaseConnection"() {
    (new helpers.FirstQuery()).closeDatabaseConnection()
}

 /**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	 * @param queryString a SQL statement
	 * @return single value result of SQL statement
	 */ 
def static "helpers.FirstQuery.execute"(
    	String queryString	) {
    (new helpers.FirstQuery()).execute(
        	queryString)
}

 /**
	 * Refresh browser
	 */ 
def static "helpers.WebActions.refreshBrowser"() {
    (new helpers.WebActions()).refreshBrowser()
}

 /**
	 * Zoom out browser
	 */ 
def static "helpers.WebActions.zoomBrowser"() {
    (new helpers.WebActions()).zoomBrowser()
}


def static "helpers.WebActions.undoTextFieldUsingKeyBoard"() {
    (new helpers.WebActions()).undoTextFieldUsingKeyBoard()
}


def static "helpers.WebActions.deleteTextField"() {
    (new helpers.WebActions()).deleteTextField()
}

 /******
	 *
	 */ 
def static "helpers.WebActions.waitForLoaderAndClickElement"(
    	WebDriver driver	
     , 	By loaderLocator	
     , 	By elementLocator	) {
    (new helpers.WebActions()).waitForLoaderAndClickElement(
        	driver
         , 	loaderLocator
         , 	elementLocator)
}

 /**
	 * Click element
	 * @param to Katalon test object
	 */ 
def static "helpers.WebActions.clickElement"(
    	String locator	) {
    (new helpers.WebActions()).clickElement(
        	locator)
}


def static "helpers.WebActions.mouseOverElement"(
    	String testObject	) {
    (new helpers.WebActions()).mouseOverElement(
        	testObject)
}


def static "helpers.WebActions.verifyElePresent"(
    	String locator	) {
    (new helpers.WebActions()).verifyElePresent(
        	locator)
}


def static "helpers.WebActions.refreshUntilElementExistsByXPath"(
    	String xpath	
     , 	int timeoutSeconds	) {
    (new helpers.WebActions()).refreshUntilElementExistsByXPath(
        	xpath
         , 	timeoutSeconds)
}

 /**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */ 
def static "helpers.WebActions.getHtmlTableRows"(
    	TestObject table	
     , 	String outerTagName	) {
    (new helpers.WebActions()).getHtmlTableRows(
        	table
         , 	outerTagName)
}


def static "helpers.WebActions.clickEleWithText"(
    	String objRepoPath	
     , 	String eleText	) {
    (new helpers.WebActions()).clickEleWithText(
        	objRepoPath
         , 	eleText)
}


def static "helpers.WebActions.verifyEleVisibilityWithText"(
    	String objRepoPath	
     , 	String eleText	) {
    (new helpers.WebActions()).verifyEleVisibilityWithText(
        	objRepoPath
         , 	eleText)
}


def static "helpers.WebActions.generateRandomString"(
    	int length	) {
    (new helpers.WebActions()).generateRandomString(
        	length)
}


def static "helpers.WebActions.verifyEleNonVisibilityWithText"(
    	String objRepoPath	
     , 	String eleText	) {
    (new helpers.WebActions()).verifyEleNonVisibilityWithText(
        	objRepoPath
         , 	eleText)
}


def static "helpers.WebActions.clickByJS"(
    	String objRepoPath	
     , 	String eleText	) {
    (new helpers.WebActions()).clickByJS(
        	objRepoPath
         , 	eleText)
}


def static "helpers.WebActions.clickByJS1"(
    	String objRepoPath	) {
    (new helpers.WebActions()).clickByJS1(
        	objRepoPath)
}


def static "helpers.WebActions.scrollUpJS"(
    	String objRepoPath	
     , 	int dim	) {
    (new helpers.WebActions()).scrollUpJS(
        	objRepoPath
         , 	dim)
}


def static "helpers.WebActions.moveToElementAction"(
    	String objRepoPath	) {
    (new helpers.WebActions()).moveToElementAction(
        	objRepoPath)
}


def static "helpers.WebActions.scrollPage"(
    	WebDriver driver	
     , 	int pixels	
     , 	String direction	) {
    (new helpers.WebActions()).scrollPage(
        	driver
         , 	pixels
         , 	direction)
}


def static "helpers.WebActions.scrollPageToElement"(
    	TestObject to	) {
    (new helpers.WebActions()).scrollPageToElement(
        	to)
}


def static "helpers.WebActions.scrollToHeader"(
    	WebDriver driver	) {
    (new helpers.WebActions()).scrollToHeader(
        	driver)
}


def static "helpers.WebActions.temporaryZoomOut"(
    	WebDriver driver	
     , 	double zoomLevel	) {
    (new helpers.WebActions()).temporaryZoomOut(
        	driver
         , 	zoomLevel)
}


def static "helpers.WebActions.getTextWithEle"(
    	String objRepoPath	
     , 	String eleText	) {
    (new helpers.WebActions()).getTextWithEle(
        	objRepoPath
         , 	eleText)
}


def static "helpers.WebActions.waitForElementVisibleWithText"(
    	String objRepoPath	
     , 	String eleText	) {
    (new helpers.WebActions()).waitForElementVisibleWithText(
        	objRepoPath
         , 	eleText)
}


def static "helpers.WebActions.mouseOverEleWithText"(
    	String objRepoPath	
     , 	String eleText	) {
    (new helpers.WebActions()).mouseOverEleWithText(
        	objRepoPath
         , 	eleText)
}

 /**
	 * Send Keys
	 * @param Katalon testObject path
	 */ 
def static "helpers.WebActions.sendKeys"(
    	String testObject	
     , 	String value	) {
    (new helpers.WebActions()).sendKeys(
        	testObject
         , 	value)
}

 /**
	 * Drag and Drop
	 * @param  FromTestObject path, ToTestObject path
	 */ 
def static "helpers.WebActions.dragandDrop"(
    	String fromObject	
     , 	String toObject	) {
    (new helpers.WebActions()).dragandDrop(
        	fromObject
         , 	toObject)
}

 /**
	 * Upload File
	 * @param Katalon Object Path, WindowTitle, Filpath
	 */ 
def static "helpers.WebActions.uploadFile"(
    	String testObject	
     , 	String windowTitle	
     , 	String FilePath	) {
    (new helpers.WebActions()).uploadFile(
        	testObject
         , 	windowTitle
         , 	FilePath)
}

 /**
	 * Select Dropdown by Visible text
	 * @param Katalon Object Path, text
	 */ 
def static "helpers.WebActions.selectDropdownbyVisibleText"(
    	String testObject	
     , 	String text	) {
    (new helpers.WebActions()).selectDropdownbyVisibleText(
        	testObject
         , 	text)
}

 /**
	 * Select Dropdown by Visible text
	 * @param Katalon Object Path, text
	 */ 
def static "helpers.WebActions.selectDropdownbyValue"(
    	String testObject	
     , 	String text	) {
    (new helpers.WebActions()).selectDropdownbyValue(
        	testObject
         , 	text)
}

 /**
	 * Select Dropdown by Index
	 * @param Katalon Object Path, index
	 */ 
def static "helpers.WebActions.selectDropdownbyIndex"(
    	String testObject	
     , 	int index	) {
    (new helpers.WebActions()).selectDropdownbyIndex(
        	testObject
         , 	index)
}

 /**
	 * Verify element is displayed
	 * @param Katalon testObject path
	 */ 
def static "helpers.WebActions.verifyElementDisplayed"(
    	String testObject	) {
    (new helpers.WebActions()).verifyElementDisplayed(
        	testObject)
}

 /**
	 * Verify element is Selected
	 * @param Katalon testObject path
	 */ 
def static "helpers.WebActions.verifyElementSelected"(
    	String testObject	) {
    (new helpers.WebActions()).verifyElementSelected(
        	testObject)
}

 /**
	 * Verify element is Enabled
	 * @param Katalon testObject path
	 */ 
def static "helpers.WebActions.verifyElementEnabled"(
    	String testObject	) {
    (new helpers.WebActions()).verifyElementEnabled(
        	testObject)
}

 /**
	 * GetText
	 * @param Katalon testObject path
	 */ 
def static "helpers.WebActions.getText"(
    	String testObject	) {
    (new helpers.WebActions()).getText(
        	testObject)
}

 /**
	 * GetTagName
	 * @param Katalon testObject path
	 */ 
def static "helpers.WebActions.getTagName"(
    	String testObject	) {
    (new helpers.WebActions()).getTagName(
        	testObject)
}

 /**
	 * Get Element Attribute Value
	 * @param Katalon testObject path
	 */ 
def static "helpers.WebActions.getAttribute"(
    	String testObject	
     , 	String attributName	) {
    (new helpers.WebActions()).getAttribute(
        	testObject
         , 	attributName)
}

 /**
	 * clear Textbox
	 * @param Katalon testObject path
	 */ 
def static "helpers.WebActions.clear"(
    	String testObject	) {
    (new helpers.WebActions()).clear(
        	testObject)
}

 /**
	 //	 * getalert text
	 //	 *
	 //	 */ 
def static "helpers.WebActions.getAlertText"() {
    (new helpers.WebActions()).getAlertText()
}

 /**
	 * accept alert
	 * 
	 */ 
def static "helpers.WebActions.acceptAlert"() {
    (new helpers.WebActions()).acceptAlert()
}

 /**
	 * GetTitle
	 */ 
def static "helpers.WebActions.getTitle"() {
    (new helpers.WebActions()).getTitle()
}

 /**
	 * Geturl
	 */ 
def static "helpers.WebActions.getPageUrl"() {
    (new helpers.WebActions()).getPageUrl()
}

 /**
	 * Getpagesource
	 */ 
def static "helpers.WebActions.getPageSource"() {
    (new helpers.WebActions()).getPageSource()
}

 /**
	 * Getsize
	 * @param Katalon testObject path
	 */ 
def static "helpers.WebActions.getSize"(
    	String testObject	) {
    (new helpers.WebActions()).getSize(
        	testObject)
}

 /**
	 * Get text from dropdown
	 * @param Katalon testObject path,element dropdown , optiontext
	 */ 
def static "helpers.WebActions.getDropdownText"(
    	WebElement dropdown	
     , 	String testObject	
     , 	String optionText	
     , 	int timeout	) {
    (new helpers.WebActions()).getDropdownText(
        	dropdown
         , 	testObject
         , 	optionText
         , 	timeout)
}

 /**
	 * scroll to top of the page
	 *
	 */ 
def static "helpers.WebActions.scrollToTopPage"() {
    (new helpers.WebActions()).scrollToTopPage()
}

 /**
	 * scroll to bottom of the page
	 *
	 */ 
def static "helpers.WebActions.scrollToBottomPage"() {
    (new helpers.WebActions()).scrollToBottomPage()
}

 /**
	 * scroll horizontal of the page
	 * @param pixel
	 *
	 */ 
def static "helpers.WebActions.scrollToHorizontalPage"(
    	int pixels	) {
    (new helpers.WebActions()).scrollToHorizontalPage(
        	pixels)
}

 /**
	 * jsclick
	 * @param Katalon testObject path,timeout second
	 *
	 */ 
def static "helpers.WebActions.jsClick"(
    	String testObject	
     , 	int timeout	) {
    (new helpers.WebActions()).jsClick(
        	testObject
         , 	timeout)
}

 /**
	 * wait for element present
	 * @param Katalon testObject path,timeout second
	 *
	 */ 
def static "helpers.WebActions.waitForElementPresent"(
    	String testObject	
     , 	int timeout	) {
    (new helpers.WebActions()).waitForElementPresent(
        	testObject
         , 	timeout)
}

 /**
	 * wait for element not present
	 * @param Katalon testObject path,timeout second
	 *
	 */ 
def static "helpers.WebActions.waitForElementNotPresent"(
    	String testObject	
     , 	int timeout	) {
    (new helpers.WebActions()).waitForElementNotPresent(
        	testObject
         , 	timeout)
}

 /**
	 * wait for page load
	 * @param Katalon testObject path
	 *
	 */ 
def static "helpers.WebActions.waitForPageLoad"(
    	int timeout	) {
    (new helpers.WebActions()).waitForPageLoad(
        	timeout)
}

 /**
	 * wait for element visible
	 * @param Katalon testObject path
	 *
	 */ 
def static "helpers.WebActions.WaitForElementVisible"(
    	String testObject	
     , 	int timeout	) {
    (new helpers.WebActions()).WaitForElementVisible(
        	testObject
         , 	timeout)
}

 /**
	 * wait for element Invisible
	 * @param Katalon testObject path
	 *
	 */ 
def static "helpers.WebActions.WaitForElementInVisible"(
    	String testObject	
     , 	int timeout	) {
    (new helpers.WebActions()).WaitForElementInVisible(
        	testObject
         , 	timeout)
}

 /**
	 * click
	 * @param Katalon testObject path
	 *
	 */ 
def static "helpers.WebActions.click"(
    	String testObject	) {
    (new helpers.WebActions()).click(
        	testObject)
}

 /**
	 * switch to frame
	 * @param xpath
	 *
	 */ 
def static "helpers.WebActions.switchToFrame"(
    	String xpath	) {
    (new helpers.WebActions()).switchToFrame(
        	xpath)
}
