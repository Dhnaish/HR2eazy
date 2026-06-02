package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("test-output/SparkReport.html");

            spark.config().setOfflineMode(true);

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }

    public static ExtentReports getReport() {
        return getInstance();
    }
}
