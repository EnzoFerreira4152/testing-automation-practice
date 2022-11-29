package org.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.Base.BasePage;
import org.Base.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.Pages.PageLogin;
import org.Pages.ReservationPage;
import org.Pages.SearchPage;

class TestReservation extends BaseTest {

     @Test
     void failedReservation() throws InterruptedException {
          PageLogin pageLogin = new PageLogin(driver);
          SearchPage searchPage = new SearchPage(driver);
          ReservationPage reservationPage = new ReservationPage(driver);

          pageLogin.loginAs("space@interbanking.com.ar", "123456");
          assertEquals("Sergio Pace", pageLogin.nameLogin());
          System.out.println("Nombre del usuario logueado: " + pageLogin.nameLogin());
          assertEquals("Buscá ofertas en casas, departamentos y mucho más\n¿A dónde vamos?\nBuscar", pageLogin.mainMessage());
          System.out.println("Mensaje de principal de Digital Booking: " + pageLogin.mainMessage());

          searchPage.search("san isidro");
          assertEquals("DEPARTAMENTO\nNuevo Exclusivo Loft con Piscina, Parking y BBQ!", searchPage.result());

          searchPage.getIntoSeeDetails();
          assertEquals("DEPARTAMENTO", reservationPage.category());
          assertEquals("Nuevo Exclusivo Loft con Piscina, Parking y BBQ!", reservationPage.title());

          reservationPage.completeReserve("CABA", "Esto es una Prueba");
          assertEquals("Lamentablemente la reserva no ha podido realizarse. Por favor, intente más tarde", reservationPage.failMessage());
     }

}