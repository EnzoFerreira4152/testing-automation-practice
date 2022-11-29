package org.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.Base.BasePage;

public class ReservationPage extends BasePage {
     By categoryText = By.className("producto-header-categoria");
     By titleText = By.xpath("//h2[@class='producto-header-titulo']");
     By reserveButton = By.className("btn-reserva");
     By cities = By.id("ciudad");
     By vaccinated = By.id("vacunado-covid");
     By observations = By.id("observaciones");
     By checkIn = By.xpath("//div[@aria-label='Choose Saturday, November 19th, 2022']");
     By checkOut = By.xpath("//div[@aria-label='Choose Saturday, November 26th, 2022']");
     By selectSchedule = By.id("horario");
     By confirmReserveButton = By.className("btn-confirmar-reserva");
     By reserveMessage = By.xpath("//h4[contains(text(),'Lamentablemente la reserva no ha podido realizarse')]");

     public ReservationPage(WebDriver driver) {
          super(driver);
     }

     public String category() throws InterruptedException {
          wait.until(ExpectedConditions.presenceOfElementLocated(categoryText));
          String res = findElement(categoryText).getText();
          System.out.println("Card value: " + res);
          return res;
     }

     public String title() throws InterruptedException {
          Thread.sleep(1000);
          String res = findElement(titleText).getText();
          System.out.println("Card value: " + res);
          return res;
     }

     public void selectSchedule() {
          click(selectSchedule);
          arrowDown(selectSchedule);
          enter(selectSchedule);
     }

     public void completeReserve(String ciudad, String observation) throws InterruptedException {
          click(reserveButton);
          Thread.sleep(1000);
          writeField(ciudad, cities);
          click(vaccinated);
          writeField(observation, observations);
          click(checkIn);
          click(checkOut);
          selectSchedule();
          click(confirmReserveButton);
     }

     public String failMessage() throws InterruptedException {
          Thread.sleep(1000);
          String res = findElement(reserveMessage).getText();
          System.out.println("Card value: " + res);
          return res;
     }
}