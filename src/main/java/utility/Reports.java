package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports configureReports() {

		ExtentReports reports = new ExtentReports();
		ExtentSparkReporter html = new ExtentSparkReporter("NaptoolReports.html");
		reports.attachReporter(html);
		reports.setSystemInfo("Project", "Naaptol");
		reports.setSystemInfo("CreatedBy", "Kiran");
		return reports;
	}

}