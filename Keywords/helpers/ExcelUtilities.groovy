package helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.poi.EncryptedDocumentException
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.apache.poi.ss.usermodel.Row;

import internal.GlobalVariable

public class ExcelUtilities {
	
	public static int headerRow = 0;
	public static int startRow = 0;
	public static int endRow = 0;
	
	
	
	/**
	 * @param workbookName
	 * @param sheetName
	 * @param columnName
	 * @param rowNo
	 * @return String
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static String readDataFile(String workbookName, String sheetName, String columnName, int rowNo)
			throws EncryptedDocumentException, IOException {

		int columnNo = 0;
		String value = null;

		Workbook workbook = WorkbookFactory.create(new File("./src/test/resources/data/" + workbookName));
		Sheet sheet = workbook.getSheet(sheetName);

		DataFormatter formatter = new DataFormatter();
		Row firstRow = sheet.getRow(headerRow);
		for (Cell c : firstRow) {
			if (columnName.equals(formatter.formatCellValue(c))) {
				columnNo = c.getColumnIndex();
				break;
			}
		}
		rowNo = rowNo - 1;
		value = formatter.formatCellValue(sheet.getRow(rowNo).getCell(columnNo));
		workbook.close();

		return value;
	}
}
