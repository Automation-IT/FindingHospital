package com.FindingHospital.utilities;

import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReport {

	public static ExtentReports report;
	Properties p = new Properties();

	public static ExtentReports getReportInstance() {
		if (report == null) {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "/extentReportFile.html");
			report = new ExtentReports();
			report.attachReporter(htmlReporter);

			report.setSystemInfo("OS", "Windows 10");

			htmlReporter.config().setDocumentTitle("Hackathon project - Finding Hospitals");
			/*
			 * htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			 * htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
			 */
		}
		return report;
	}

}