package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class Utilities {
	public static Properties prop;

	public static Properties getProperty() throws IOException {

    Properties prop = new Properties();

    String configPath = System.getProperty("user.dir")
            + "/src/test/resources/config.properties";

    FileInputStream file = new FileInputStream(configPath);

    prop.load(file);
    file.close();

    return prop;
}
	
	 @DataProvider(name = "leaveData")
	 public Object[][] leaveData() throws Exception {

	     int rows = ExcelUtility.getRowCount();

	     Object[][] data = new Object[rows][4];

	     for (int i = 1; i <= rows; i++) {
	         data[i - 1][0] = ExcelUtility.getData(i, 0); // UserName
	         data[i - 1][1] = ExcelUtility.getData(i, 1); // Password
	         data[i - 1][2] = ExcelUtility.getData(i, 3); // FromDate
	         data[i - 1][3] = ExcelUtility.getData(i, 4); // ToDate
	     }

	     return data;
	 }
	 @DataProvider(name = "PermissionData")
	 public Object[][] PermissionData() throws Exception {

	     int rows = ExcelUtility.getRowCount();

	     Object[][] data = new Object[rows][3];

	     for (int i = 1; i <= rows; i++) {
	         data[i - 1][0] = ExcelUtility.getData(i, 0); // UserName
	         data[i - 1][1] = ExcelUtility.getData(i, 1); // Password
	         data[i - 1][2] = ExcelUtility.getData(i, 2); // PermissionDate
	        
	     }

	     return data;
	 }
	 @DataProvider(name = "SingleClaimData")
	 public Object[][] SingleClaimData() throws Exception {

	     int rows = ExcelUtility.getRowCount();

	     Object[][] data = new Object[rows][4];

	     for (int i = 1; i <= rows; i++) {
	         data[i - 1][0] = ExcelUtility.getData(i, 0); // UserName
	         data[i - 1][1] = ExcelUtility.getData(i, 1); // Password
	         data[i - 1][2] = ExcelUtility.getData(i, 5); // ClaimDate
	         data[i - 1][3] = ExcelUtility.getData(i, 6); // ReceiptDate
	        
	     }

	     return data;
	 }
	 @DataProvider(name = "MultipleClaimData")
	 public Object[][] MultipleClaimData() throws Exception {

	     int rows = ExcelUtility.getRowCount();

	     Object[][] data = new Object[rows][5];

	     for (int i = 1; i <= rows; i++) {
	         data[i - 1][0] = ExcelUtility.getData(i, 0); // UserName
	         data[i - 1][1] = ExcelUtility.getData(i, 1); // Password
	         data[i - 1][2] = ExcelUtility.getData(i, 5); // ClaimDate
	         data[i - 1][3] = ExcelUtility.getData(i, 6); // ReceiptDate
	         data[i - 1][4] = Integer.parseInt(ExcelUtility.getData(i, 7)); // Amount
	        
	     }

	     return data;
	 }
	
	
}
