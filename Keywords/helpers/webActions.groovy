package helpers

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Robot
import java.awt.event.KeyEvent
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.WaitForElementVisibleKeyword

public class WebActions {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		//		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		//		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Zoom out browser
	 */
	@Keyword
	def zoomBrowser() {

		Robot robot = new Robot()

		for (int i = 0; i < 5; i++) {
			// how many times you want CRTL+'-' pressed - this gets zoom to 50%
			robot.keyPress(KeyEvent.VK_CONTROL)
			robot.keyPress(KeyEvent.VK_SUBTRACT)
			robot.keyRelease(KeyEvent.VK_SUBTRACT)
			robot.keyRelease(KeyEvent.VK_CONTROL)
		}
	}

	@Keyword
	def undoTextFieldUsingKeyBoard() {

		Robot robot = new Robot()

		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyRelease(KeyEvent.VK_CONTROL)

		// Press and release Z key
		robot.keyPress(KeyEvent.VK_Z)
		robot.keyRelease(KeyEvent.VK_Z)
		WebUI.delay(10)
	}

	@Keyword
	def deleteTextField() {

		Robot robot = new Robot()

		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyPress(KeyEvent.VK_BACK_SPACE)
		sleep(10)
		// Press and release Z key
		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyRelease(KeyEvent.VK_BACK_SPACE)
	}




	/******
	 *
	 */
	@Keyword
	def waitForLoaderAndClickElement(WebDriver driver, By loaderLocator, By elementLocator) {

		// WebDriverWait with ExpectedConditions for invisibility
		WebDriverWait wait = new WebDriverWait(driver, 10)
		// Check if loader is visible
		if (wait.until(ExpectedConditions.presenceOfElementLocated(loaderLocator)).isDisplayed()) {
			// Wait for loader to disappear (becomes invisible)
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator))
		}

		// Click on the element after loader disappears
		driver.findElement(elementLocator).click()
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(String locator) {
		try {
			WebElement element = DriverFactory.getWebDriver().findElement(By.xpath(locator))
			element.click()
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	//	@Keyword
	//	def static void waitForLoaderToDisappear(TestObject loaderObject, int timeout = 10) {
	//		// Get the WebDriver instance
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//
	//		// Get the locator from the TestObject
	//		By locator = loaderObject.getObjectId()
	//
	//		println 'locator'
	//		// Wait for the element to disappear using WebDriverWait
	//		WebDriverWait wait = new WebDriverWait(webDriver, timeout)
	//		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator))
	//
	//		// Perform the desired WebUI action
	//		WebUI.click(findTestObject(loaderObject)) // Replace with your target object
	//	}


	@Keyword
	def mouseOverElement(String testObject) {
		try {
			TestObject object= findTestObject(testObject)
			WebElement element = WebUiCommonHelper.findWebElement(object, 3)
			Actions actions = new Actions(DriverFactory.getWebDriver())
			actions.moveToElement(element).perform()
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	@Keyword
	def verifyElePresent(String locator) {
		try {
			WebElement element = DriverFactory.getWebDriver().findElement(By.xpath(locator))
			element.isDisplayed()
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	@Keyword
	public static boolean refreshUntilElementExistsByXPath(String xpath, int timeoutSeconds) {

		WebDriver driver = DriverFactory.getWebDriver()
		int attempts = 0;
		while (attempts < timeoutSeconds) {
			try {
				// Attempt to find the element
				new WebDriverWait(driver, timeoutSeconds).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
				return true;
			} catch (Exception e) {
				// Element not found, refresh the page and retry
				driver.navigate().refresh();
				attempts++;
			}
		}

		// Timeout reached, element not found
		return false;
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	@Keyword
	def clickEleWithText(String objRepoPath, String eleText) {
		//		TestObject obj = findTestObject(objRepoPath)
		//		obj.addProperty('eleText', ConditionType.EQUALS, eleText)
		//		WebUI.click(obj)
		TestObject obj = findTestObject(objRepoPath)
		List<String> xpaths = obj.getActiveXpaths()
		if (xpaths.isEmpty()) {
			println("Test object does not have any xpath locators associated with it")
		}
		String originalXpath = xpaths.get(0)
		String updatedXpath = originalXpath.replace('${eleText}', eleText)
		println(updatedXpath)
		obj.setXpaths([updatedXpath])
		WebUI.click(obj)
	}

	@Keyword
	def verifyEleVisibilityWithText(String objRepoPath, String eleText) {
		TestObject obj = findTestObject(objRepoPath)
		obj.addProperty('eleText', ConditionType.EQUALS, eleText)
		WebUI.verifyElementVisible(obj)
	}

	@Keyword
	def generateRandomString(int length) {
		String chars = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		Random rand = new Random();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i=0; i <length; i++) {
			stringBuilder.append(chars.charAt(rand.nextInt(chars.length())));
		}
		return stringBuilder.toString();
	}

	@Keyword
	def verifyEleNonVisibilityWithText(String objRepoPath, String eleText) {
		// Retrieve the Test Object from the Object Repository
		TestObject obj = findTestObject(objRepoPath)

		// Set the parameter value for the Test Object
		obj.addProperty('eleText', ConditionType.EQUALS, eleText)
		// Click on the button
		WebUI.verifyElementNotPresent(obj,0)
	}

	@Keyword
	def clickByJS(String objRepoPath, String eleText) {
		// Get the JavaScript executor instance
		JavascriptExecutor js = ((JavascriptExecutor) DriverFactory.getWebDriver())

		// Find the web element you want to click
		TestObject elementToClick = findTestObject(objRepoPath)
		elementToClick.addProperty('eleText', ConditionType.EQUALS, eleText)
		// Execute JavaScript code to click on the element
		js.executeScript("arguments[0].click();", Arrays.asList(elementToClick))
	}

	@Keyword
	def clickByJS1(String objRepoPath) {
		// Get the JavaScript executor instance
		JavascriptExecutor js = ((JavascriptExecutor) DriverFactory.getWebDriver())

		// Find the web element you want to click
		TestObject elementToClick = findTestObject(objRepoPath)

		// Execute JavaScript code to click on the element
		js.executeScript("arguments[0].click();", Arrays.asList(elementToClick))
	}

	@Keyword
	def scrollUpJS(String objRepoPath, int dim) {
		JavascriptExecutor js = ((JavascriptExecutor) DriverFactory.getWebDriver())
		TestObject sidebarElement = findTestObject(objRepoPath)

		// Execute JavaScript code to scroll the sidebar element up
		js.executeScript("arguments[0].scrollTop -= "+dim+";", Arrays.asList(sidebarElement))
	}

	@Keyword
	def moveToElementAction(String objRepoPath) {
		TestObject elementToClick = findTestObject(objRepoPath)
		Actions actions = new Actions(DriverFactory.getWebDriver())
		actions.moveToElement(WebUI.findWebElement(elementToClick, 0)).perform()
		WebUI.click(elementToClick)
	}

	@Keyword
	def scrollPage(WebDriver driver, int pixels, String direction) {
		JavascriptExecutor js = (JavascriptExecutor) driver
		if (direction == "up") {
			js.executeScript("window.scrollBy(0, -" + pixels + ");")
		} else if (direction == "down") {
			js.executeScript("window.scrollBy(0, " + pixels + ");")
		} else {
			println("Invalid scroll direction provided. Please provide 'up' or 'down'.")
		}
	}

	@Keyword
	def scrollPageToElement(TestObject to) {
		// Get the WebElement of the target element
		WebElement element = WebUiBuiltInKeywords.findWebElement(to, 2)
		// Execute JavaScript to scroll to the target element
		((JavascriptExecutor) DriverFactory.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element)
	}

	@Keyword
	def scrollToHeader(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, 0);");
	}

	@Keyword
	def temporaryZoomOut(WebDriver driver, double zoomLevel) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("document.body.style.transform='scale(" + zoomLevel + ")';");
	}

	@Keyword
	def getTextWithEle(String objRepoPath, String eleText) {
		TestObject obj = findTestObject(objRepoPath)
		obj.addProperty('text', ConditionType.CONTAINS, eleText)
		return WebUI.getText(obj)
	}

	@Keyword
	def waitForElementVisibleWithText(String objRepoPath, String eleText) {
		TestObject obj = findTestObject(objRepoPath)
		obj.addProperty('text', ConditionType.EQUALS, eleText)
		WebElement element = WebUiCommonHelper.findWebElement(obj, 10)
		return element
	}

	//	@Keyword
	//	def mouseOverEleWithText(String objRepoPath, String eleText) {
	//	    WebElement element = waitForElementVisibleWithText(objRepoPath, eleText)
	//	    JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
	//		js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover', { bubbles: true }))", element)
	//	}

	@Keyword
	def mouseOverEleWithText(String objRepoPath, String eleText) {
		String replacedLocator = objRepoPath.replace('${eleText}', eleText)
		println(replacedLocator)
		WebElement element = WebUI.waitForElementVisible(findTestObject(replacedLocator), 10)

		Actions actions = new Actions(DriverFactory.getWebDriver())
		actions.moveToElement(element).perform()
	}

	/*--------------------------------------New Methods--------------------------------------------------*/

	/**
	 * Send Keys
	 * @param Katalon testObject path
	 */
	@Keyword
	def sendKeys(String testObject, String value) {
		try {
			TestObject object= findTestObject(testObject)
			WebElement element = WebUiCommonHelper.findWebElement(object, 3)
			element.clear()
			element.sendKeys(value)
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * Drag and Drop
	 * @param  FromTestObject path, ToTestObject path
	 */
	@Keyword
	def dragandDrop(String fromObject,String toObject) {

		try {
			TestObject objectFrom= findTestObject(fromObject)
			TestObject objectTo= findTestObject(toObject)

			//WebElement on which drag and drop operation needs to be performed
			WebElement fromElement = WebUiCommonHelper.findWebElement(objectFrom, 3)

			//WebElement to which the above object is dropped
			WebElement toElement = WebUiCommonHelper.findWebElement(objectTo, 3)

			//Creating object of Actions class to build composite actions
			Actions builder = new Actions(DriverFactory.getWebDriver())

			//Building a drag and drop action
			Action dragAndDrop = builder.clickAndHold(fromElement)
					.moveToElement(toElement)
					.release(toElement)
					.build();

			//Performing the drag and drop action
			dragAndDrop.perform();
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * Upload File
	 * @param Katalon Object Path, WindowTitle, Filpath
	 */
	@Keyword
	def uploadFile(String testObject,String windowTitle, String FilePath) {

		try {
			TestObject object= findTestObject(testObject)

			WebUI.switchToWindowTitle(windowTitle)

			WebUI.uploadFile(object,FilePath)
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * Select Dropdown by Visible text
	 * @param Katalon Object Path, text
	 */
	@Keyword
	def selectDropdownbyVisibleText(String testObject,String text) {

		try {
			TestObject object= findTestObject(testObject)

			WebElement identifier = WebUiCommonHelper.findWebElement(object, 3)
			Select select = new Select(identifier);
			select.selectByVisibleText(text);
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * Select Dropdown by Visible text
	 * @param Katalon Object Path, text
	 */
	@Keyword
	def selectDropdownbyValue(String testObject,String text) {

		try {
			TestObject object= findTestObject(testObject)

			WebElement identifier = WebUiCommonHelper.findWebElement(object, 3)
			Select select = new Select(identifier);
			select.selectByValue(text)
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * Select Dropdown by Index
	 * @param Katalon Object Path, index
	 */
	@Keyword
	def selectDropdownbyIndex(String testObject, int index) {

		try {
			TestObject object= findTestObject(testObject)

			WebElement identifier = WebUiCommonHelper.findWebElement(object, 3)
			Select select = new Select(identifier);
			select.selectByIndex(index)
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * Verify element is displayed
	 * @param Katalon testObject path
	 */
	@Keyword
	def verifyElementDisplayed(String testObject) {
		def flag = false

		try {
			TestObject object= findTestObject(testObject)
			WebElement element = WebUiCommonHelper.findWebElement(object, 3)
			flag =  element.isDisplayed()
		} catch (Exception e) {
			e.printStackTrace()
		}
		return flag
	}

	/**
	 * Verify element is Selected
	 * @param Katalon testObject path
	 */
	@Keyword
	def verifyElementSelected(String testObject) {
		def flag = false

		try {
			TestObject object= findTestObject(testObject)
			WebElement element = WebUiCommonHelper.findWebElement(object, 3)
			flag =  element.isSelected()
		} catch (Exception e) {
			e.printStackTrace()
		}
		return flag
	}

	/**
	 * Verify element is Enabled
	 * @param Katalon testObject path
	 */
	@Keyword
	def verifyElementEnabled(String testObject) {
		def flag = false

		try {
			TestObject object= findTestObject(testObject)
			WebElement element = WebUiCommonHelper.findWebElement(object, 3)
			flag =  element.isEnabled()
		} catch (Exception e) {
			e.printStackTrace()
		}
		return flag
	}

	/**
	 * GetText
	 * @param Katalon testObject path
	 */
	@Keyword
	def getText(String testObject) {
		def flag = false

		try {
			TestObject object= findTestObject(testObject)
			WebElement element = WebUiCommonHelper.findWebElement(object, 3)
			flag =  element.getText()
			println("Gettext : "+element.getText())
		} catch (Exception e) {
			e.printStackTrace()
		}
		return flag
	}

	/**
	 * GetTagName
	 * @param Katalon testObject path
	 */
	@Keyword
	def getTagName(String testObject) {
		def flag = false

		try {
			TestObject object= findTestObject(testObject)
			WebElement element = WebUiCommonHelper.findWebElement(object, 3)
			flag =  element.getTagName()
		} catch (Exception e) {
			e.printStackTrace()
		}
		return flag
	}

	/**
	 * Get Element Attribute Value
	 * @param Katalon testObject path
	 */
	@Keyword
	def getAttribute(String testObject, String attributName) {
		def flag = false

		try {
			TestObject object= findTestObject(testObject)
			WebElement element = WebUiCommonHelper.findWebElement(object, 3)
			flag =  element.getAttribute(attributName)
		} catch (Exception e) {
			e.printStackTrace()
		}
		return flag
	}

	/**
	 * clear Textbox
	 * @param Katalon testObject path
	 */
	@Keyword
	def clear(String testObject) {

		try {
			TestObject object= findTestObject(testObject)
			WebElement element = WebUiCommonHelper.findWebElement(object, 3)
			element.clear()
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	//	/**
	//	 * getalert text
	//	 *
	//	 */
	//	@Keyword
	//	def getAlertText() {
	//
	//		try {
	//			WebDriver driver = DriverFactory.getWebDriver()
	//			WebUI.waitForAlert(10)
	//			def accAlertMessage = driver.switchTo().alert().getText();
	//			println("accAlertMessage:"+accAlertMessage)
	//		} catch (Exception e) {
	//			e.printStackTrace()
	//		}
	//	}

	/**
	 //	 * getalert text
	 //	 *
	 //	 */
	@Keyword
	def getAlertText() {
		waitForAlert(10)
		verifyAlertPresent(5)
		WebDriver driver = DriverFactory.getWebDriver()
		def alertText = driver.switchTo().alert().getText();
		println alertText
		return alertText
	}



	/**
	 * accept alert
	 * 
	 */
	@Keyword
	def acceptAlert() {

		try {
			WebDriver driver = DriverFactory.getWebDriver()
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	//adding more *********************************************

	/**
	 * GetTitle
	 */
	@Keyword
	def getTitle() {
		String value = "";
		try {
			value = DriverFactory.getWebDriver().getTitle();
		} catch (Exception e) {
			Assert.assertFalse(true, "FAILED:- Got Page Title : " + e.toString());
		}
		return value;
	}

	/**
	 * Geturl
	 */
	@Keyword
	def getPageUrl() {
		String value = "";
		try {
			value = DriverFactory.getWebDriver().getCurrentUrl();
		} catch (Exception e) {
			Assert.assertFalse(true, "FAILED:- to get page url : " + e.toString());
		}
		return value;
	}

	/**
	 * Getpagesource
	 */
	@Keyword
	def getPageSource() {
		String value = "";
		try {
			value = DriverFactory.getWebDriver().getPageSource();
		} catch (Exception e) {
			Assert.assertFalse(true, "FAILED:- to get page source : " + e.toString());
		}
		return value;
	}

	/**
	 * close browser
	 */
	def closeBrowser() {
		try {
			DriverFactory.getWebDriver().close();
		} catch (Exception e) {
			Assert.assertFalse(true, "FAIL:- to close driver: " + e.toString());
		}
	}

	/**
	 * quit browser
	 */
	def quitBrowser() {
		try {
			DriverFactory.getWebDriver().quit();
		} catch (Exception e) {
			Assert.assertFalse(true, "FAIL:- to quit driver: " + e.toString());
		}
	}

	/**
	 * navigate to url
	 * @param url
	 */
	def navigateToURl(String url) {
		try {
			DriverFactory.getWebDriver().navigate().to(url);
		} catch (Exception e) {
			Assert.assertFalse(true, "FAIL:- to navigate to url: " + e.toString());
		}
	}

	/**
	 * navigate foward
	 */
	def navigateForward() {
		try {
			DriverFactory.getWebDriver().navigate().forward();
		} catch (Exception e) {
			Assert.assertFalse(true, "FAIL:- to navigate forward: " + e.toString());
		}
	}

	/**
	 * navigate backward
	 */
	def navigatebackward() {
		try {
			DriverFactory.getWebDriver().navigate().back();
		} catch (Exception e) {
			Assert.assertFalse(true, "FAIL:- to navigate backward: " + e.toString());
		}
	}



	/**
	 * Getsize
	 * @param Katalon testObject path
	 */
	@Keyword
	def getSize(String testObject) {
		def flag = false

		try {
			TestObject object= findTestObject(testObject)
			WebElement element = WebUiCommonHelper.findWebElement(object, 3)
			flag =  element.getSize()
		} catch (Exception e) {
			e.printStackTrace()
		}
		return flag
	}


	/**
	 * Get text from dropdown
	 * @param Katalon testObject path,element dropdown , optiontext
	 */
	@Keyword
	def getDropdownText(WebElement dropdown,String testObject,String optionText,int timeout ) {
		try {
			TestObject object= findTestObject(testObject)
			List<WebElement> options = WebUiCommonHelper.findWebElement(object,timeout )
			for (WebElement option : options) {
				if (option.getText().equals(optionText)) {
					return option.getText()
				}
			}
		} catch (Exception e) {
			e.printStackTrace()
		}

		return null
	}


	/**
	 * scroll to top of the page
	 *
	 */
	@Keyword
	def scrollToTopPage() {
		WebUI.delay(5)
		JavascriptExecutor js = ((JavascriptExecutor) DriverFactory.getWebDriver())
		js.executeScript('window.scrollTo(0,0);')
	}

	/**
	 * scroll to bottom of the page
	 *
	 */
	@Keyword
	def scrollToBottomPage() {
		WebUI.delay(5)
		JavascriptExecutor js = ((JavascriptExecutor) DriverFactory.getWebDriver())
		js.executeScript('window.scrollTo(0, document.body.scrollHeight);')
	}

	/**
	 * scroll horizontal of the page
	 * @param pixel
	 *
	 */
	@Keyword
	def scrollToHorizontalPage(int pixels) {
		JavascriptExecutor js = ((JavascriptExecutor) DriverFactory.getWebDriver())
		js.executeScript("window.scrollBy(arguments[0],0)", pixels)
	}


	/**
	 * jsclick
	 * @param Katalon testObject path,timeout second
	 *
	 */
	@Keyword
	def jsClick(String testObject,int timeout) {
		try {
			TestObject object= findTestObject(testObject)
			WebElement element = WebUiCommonHelper.findWebElement(object, timeout)
			JavascriptExecutor js = ((JavascriptExecutor) DriverFactory.getWebDriver())
			js.executeScript('arguments[0].click();', element)
		}
		catch (Exception e) {
			e.printStackTrace()
			Assert.assertFalse(true, e.toString());
		}
	}

	/**
	 * wait for element present
	 * @param Katalon testObject path,timeout second
	 *
	 */
	@Keyword
	def waitForElementPresent(String testObject,int timeout) {
		DriverFactory.getWebDriver().manage().timeouts().implicitlyWait(20, java.util.concurrent.TimeUnit.SECONDS)

		try {
			TestObject object= findTestObject(testObject)
			WebUI.waitForElementPresent(object,timeout)
		}
		catch (InterruptedException ex) {
			System.out.println("element is not present on the page");
		}
	}


	/**
	 * wait for element not present
	 * @param Katalon testObject path,timeout second
	 *
	 */
	@Keyword
	def waitForElementNotPresent(String testObject,int timeout) {
		DriverFactory.getWebDriver().manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS)

		try {
			TestObject object= findTestObject(testObject)
			WebUI.waitForElementNotPresent(object,timeout)
		}
		catch (InterruptedException ex) {
			println("element is present on the page")
		}
	}

	/**
	 * wait for page load
	 * @param Katalon testObject path
	 *
	 */
	@Keyword
	def waitForPageLoad(int timeout) {
		for (int i = 0; i < 60; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				println "Page has not loaded yet "
			}
			// again check page state
			if (((JavascriptExecutor) DriverFactory.getWebDriver()).executeScript("return document.readyState").toString()
					.equals("complete")) {
				break;
			}
		}
	}



	/**
	 * wait for element visible
	 * @param Katalon testObject path
	 *
	 */
	@Keyword
	def WaitForElementVisible(String testObject,int timeout) {
		DriverFactory.getWebDriver().manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS)

		try {
			TestObject object= findTestObject(testObject)
			WebUI.waitForElementVisible(object,timeout)
		}
		catch (InterruptedException e) {
			Assert.assertFalse(true, "Element is not Visible " + testObject + ": " + e.toString());
		}
	}


	/**
	 * wait for element Invisible
	 * @param Katalon testObject path
	 *
	 */
	@Keyword
	def WaitForElementInVisible(String testObject,int timeout) {

		DriverFactory.getWebDriver().manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS)
		try {
			TestObject object= findTestObject(testObject)
			WebUI.waitForElementVisible(object,timeout)
		}
		catch (InterruptedException e) {
			Assert.assertFalse(true, "Element is Visible " + testObject + ": " + e.toString());
		}
	}


	/**
	 * click
	 * @param Katalon testObject path
	 *
	 */
	@Keyword
	def click(String testObject) {
		TestObject object= findTestObject(testObject)
		try {
			waitForElementPresent(testObject,3)
			WebElement element = WebUiCommonHelper.findWebElement(object, 3)
			element.click()
		} catch (Exception e) {
			Assert.assertFalse(true, e.toString());
		}
	}


	/**
	 * switch to frame
	 * @param xpath
	 *
	 */
	@Keyword
	def switchToFrame(String xpath) {
		try {
			WebElement frameElement = DriverFactory.getWebDriver().findElement(By.xpath(xpath))
			DriverFactory.getWebDriver().switchTo().frame(frameElement)
		} catch (Exception e) {
			throw new RuntimeException("Failed to switch to frame: " + e.getMessage())
		}
	}


	/**
	 * Verify if the specified text is present in the page source.
	 * @param text The text to be verified.
	 * @return true if the text is present, false otherwise.
	 */
	def boolean verifyTextInPage(String text) {
		// Get the page source
		String pageSource = DriverFactory.getWebDriver().getPageSource()

		// Check if the text is present in the page source
		if (pageSource.contains(text)) {
			println("Text '$text' is present in the page source.")
			return true
		} else {
			println("Text '$text' is not present in the page source.")
			return false
		}
	}


	/**
	 * max window
	 */
	def maximize_Window() {
		WebUI.maximizeWindow()
	}


	/**
	 * wait for alert
	 */
	def waitForAlert(int timeout) {
		try {
			WebUI.waitForAlert(timeout)
		}
		catch(Exception e) {
		}
	}

	/**
	 * verify alert present
	 */
	def verifyAlertPresent(int timeout) {
		if(WebUI.verifyAlertPresent(timeout)) {
			println "Alert is present in the webpage"
		}
		else {
			println "Alert is not present in the webpage"
		}
	}


	/**
	 * generate random number
	 */
	def generateRandomNumber() {
		Random rand = new Random()
		StringBuilder number = new StringBuilder()
		number.append(rand.nextInt(9) + 1)
		// Generate the remaining 15 digits
		for (int i = 0; i < 15; i++) {
			number.append(rand.nextInt(10))
		}
		return number.toString()
	}

	def setEncryptedText(String testObject,String value) {
		TestObject object= findTestObject(testObject)
		try {
			WebUI.setEncryptedText(object, value)
		} catch (Exception e) {
			e.printStackTrace()
		}
	}
}
