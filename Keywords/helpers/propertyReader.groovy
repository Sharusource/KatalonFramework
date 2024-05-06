package helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import java.util.Properties
import java.io.FileInputStream

public class PropertyReader {

	Properties properties = new Properties()

	@Keyword
	def String readPropertyFileData(String key) {
		String value
		try {
			KeywordUtil.logInfo("Property value based on the Key")
			FileInputStream fis = new FileInputStream('console.properties')
			properties.load(fis)
			value = properties.getProperty(key)
		}catch (Exception e) {
			e.printStackTrace()
			KeywordUtil.markFailed("Fail to click on element")
		}
		return value
	}

	@Keyword
	def String writePropertyFileData(String key,String value) {
		try {
			Properties props = new Properties()
			FileInputStream input = new FileInputStream('console.properties')
			props.load(input)
			input.close()

			FileOutputStream out = new FileOutputStream('console.properties')
			props.setProperty(key, value)
			props.store(out, null)

			out.close()
		} catch (Exception e) {
			println("Error writing property to file: ${e.message}")
		}
	}
}
