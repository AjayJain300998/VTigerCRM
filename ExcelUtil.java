package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public String getDataFromExcel(String Sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("src\\test\\resources\\OrganizationAndContacts.xlsx");
		Workbook wbf = WorkbookFactory.create(file);
		Sheet sheet1 = wbf.getSheet(Sheetname);
		Row row = sheet1.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		
		return value;
		
	}

}
