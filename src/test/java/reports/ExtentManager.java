package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	  public static ExtentReports extent;

	    public static ExtentReports getInstance() {

	        if (extent == null) {

	            ExtentSparkReporter spark =
	                    new ExtentSparkReporter("test-output/SparkReport.html");

	            spark.config().setOfflineMode(true);  // Add here

	            extent = new ExtentReports();
	            extent.attachReporter(spark);
	        }

	        return extent;
	    }

		public static ExtentReports getReport() {
			// TODO Auto-generated method stub
			 return getInstance();
		}
	
}
