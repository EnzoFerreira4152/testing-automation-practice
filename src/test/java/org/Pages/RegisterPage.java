package org.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.Base.BasePage;

public class RegisterPage extends BasePage {
    By bottomCrearCuenta = By.xpath("//*[@id=\'root\']/header/nav/a[1]");
    By firstName = By.id("firstName");
    By lastname = By.name("lastName");
    By email = By.name("email");
    By password = By.name("password");
    By repeatPassword = By.name("repassword");
    By bottomFinish = By.xpath("//*[@id=\'root\']/main/div/form/button");
    By bottomLogin = By.xpath("//*[@id=\'root\']/header/nav/a[2]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerUser() {
        click(bottomCrearCuenta);
        writeField("SergioF", firstName);
        writeField("Prueba27", lastname);
        writeField("prueba27@prueba.com", email);
        writeField("pass123", password);
        writeField("pass123", repeatPassword);
        click(bottomFinish);
    }
}