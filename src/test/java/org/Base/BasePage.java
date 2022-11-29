package org.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}

	public void getLink(String url) {
		driver.get(url);
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public void writeField(String inputText, By locator) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(inputText);
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void enter(By locator) {
		driver.findElement(locator).sendKeys(Keys.ENTER);
	}

	public void arrowDown(By locator) {
		driver.findElement(locator).sendKeys(Keys.ARROW_DOWN);
	}

	public void arrowUp(By locator) {
		driver.findElement(locator).sendKeys(Keys.ARROW_UP);
	}

}