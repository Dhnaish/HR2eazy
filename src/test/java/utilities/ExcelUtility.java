package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static String getData(int row, int cell) throws IOException {

	 String excelPath = System.getProperty("user.dir") + "/TestingDatas.xlsx";

		FileInputStream file = new FileInputStream(excelPath);

	    XSSFWorkbook workbook = new XSSFWorkbook(file);

	    XSSFSheet sheet = workbook.getSheet("Sheet1");

	    DataFormatter formatter = new DataFormatter();

	    String data = formatter.formatCellValue(
	            sheet.getRow(row).getCell(cell));

	    workbook.close();

	    return data;
    }


public static int getRowCount() throws IOException {
    FileInputStream fis = new FileInputStream("src\\test\\resources\\TestingDatas.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
    Sheet sheet = wb.getSheetAt(0);

    int rowCount = sheet.getLastRowNum(); // excluding header

    wb.close();
    fis.close();

    return rowCount;
}
}
