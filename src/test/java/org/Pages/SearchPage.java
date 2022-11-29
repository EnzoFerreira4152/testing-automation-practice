package org.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.Base.BasePage;

public class SearchPage extends BasePage {
    By searchBox = By.id("ciudad");
    By search = By.id("btn-buscador");
    By result = By.className("categoria");
    By seeDetailsButton = By.className("ver-detalle");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void search(String lugar) throws InterruptedException {
        writeField(lugar, searchBox);
        Thread.sleep(2000);
        enter(searchBox);
        click(search);
    }

    public String result() throws InterruptedException {
        Thread.sleep(1000);
        String res = findElement(result).getText();
        System.out.println("Card value: " + res);
        return res;
    }

    public void getIntoSeeDetails() {
        click(seeDetailsButton);
    }
}