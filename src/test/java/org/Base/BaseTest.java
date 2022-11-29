package org.Base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.ExtentReport.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import org.Factory.IPageFactory;
import org.Pages.PageLogin;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;

public class BaseTest {
    protected static final String APP_URL = "http://fe.deitech.online/";
    protected static WebDriver driver;

    protected static ExtentReports report;
    protected static ExtentSparkReporter spark;
    protected static ExtentTest test;

    @BeforeAll
    public static void setup(){
        // Setup WebDriver Selenium variables
        String path = ".\\src\\test\\resources\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);

        // Setup Extent Report
        report = ExtentFactory.getInstance();
        spark = new ExtentSparkReporter("target/spark.html");
        report.attachReporter(spark);
    }
    @BeforeEach
    public void setDriver(){
        driver = new ChromeDriver();
        driver.get(APP_URL);
        driver.manage().window().maximize();
    }
    @AfterEach
    public void driverQuit(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
    @AfterAll
    public static void tearDown() {
        report.flush();
    }

}
