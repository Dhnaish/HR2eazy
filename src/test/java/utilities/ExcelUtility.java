package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    private static final String EXCEL_PATH =
            System.getProperty("user.dir") + "/src/test/resources/TestingDatas.xlsx";

    public static String getData(int row, int cell) throws IOException {

        try (FileInputStream file = new FileInputStream(EXCEL_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheet("Sheet1");

            DataFormatter formatter = new DataFormatter();

            return formatter.formatCellValue(
                    sheet.getRow(row).getCell(cell));
        }
    }

    public static int getRowCount() throws IOException {

        try (FileInputStream file = new FileInputStream(EXCEL_PATH);
             Workbook workbook = WorkbookFactory.create(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            return sheet.getLastRowNum();
        }
    }
}
