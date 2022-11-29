package org.Factory;

import org.openqa.selenium.WebDriver;

public interface IPageFactory <T>{
    T newPage(WebDriver driver);
}
