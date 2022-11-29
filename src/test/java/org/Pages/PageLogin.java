package org.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.Base.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageLogin extends BasePage {
	By email = By.name("email");
	By password = By.name("password");
	By buttonLogin = By.xpath("//a[@class='btn btn-secundario btn-xs'][normalize-space()='Iniciar sesión']");
	By buttonGetInto = By.xpath("//button[normalize-space()='Ingresar']");
	By result = By.className("form-feedback");
	By name = By.className("txt-nombre");
	By welcome = By.className("contenedor-buscador");

	public PageLogin(WebDriver driver) {
		super(driver);
	}

	private void clickBtnLogin() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(buttonLogin));
		click(buttonLogin);
	}

	private void insertEmail(String mail) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(email));
		writeField(mail, email);
	}

	private void insertPassword(String pass) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(password));
		writeField(pass, password);
	}

	private void clickBtnGetInto() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(buttonGetInto));
		click(buttonGetInto);
	}

	public void loginAs(String mail, String password) throws InterruptedException {
		clickBtnLogin();
		insertEmail(mail);
		insertPassword(password);
		clickBtnGetInto();
	}

	public String result() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(result));
		WebElement res = findElement(result);
		return res.getText();
	}

	public String nameLogin() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(name));
		WebElement nameLogin = findElement(name);
		return nameLogin.getText();
	}

	public String mainMessage() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(welcome));
		WebElement message = findElement(welcome);
		return message.getText();
	}

}