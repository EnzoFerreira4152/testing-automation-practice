package org.Tests;

import org.Base.BaseTest;
import org.Pages.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class TestSearch extends BaseTest {

    @Test
    void testSearch_PuntaDelEste() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search("punta del este");
        Assertions.assertEquals("CASA DE PLAYA\nVilla Kantounes Studio Ostria", searchPage.result());
    }

    @Test
    void testSearch_Carilo() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search("carilo");
        Assertions.assertEquals("CASA\nIncreíble Casa c/ Piscina, WiFi, Bosque y Playa en Carilo", searchPage.result());
    }
}