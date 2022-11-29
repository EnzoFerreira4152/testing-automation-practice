package org.ExtentReport;

import com.aventstack.extentreports.ExtentReports;

public class ExtentFactory {

    public static ExtentReports getInstance(){
        ExtentReports extent = new ExtentReports();
        extent.setSystemInfo("OS", "Windows");
        return extent;
    }

}
