package com.yape.mobile.screens;


import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class HomeScreenBookings extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    public WebElement btnClose;

    public void iniciar() {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        btnClose.click();
    }


}
