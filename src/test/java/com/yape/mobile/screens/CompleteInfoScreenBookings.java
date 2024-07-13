package com.yape.mobile.screens;


import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;


public class CompleteInfoScreenBookings extends PageObject {

    @AndroidFindBy(id = "com.booking:id/first_name")
    private WebElement firstNameInput;

    @AndroidFindBy(id = "com.booking:id/last_name")
    private WebElement lastNameInput;

    @AndroidFindBy(id = "com.booking:id/email")
    private WebElement emailInput;

    @AndroidFindBy(id = "com.booking:id/country")
    private WebElement countryInput;

    @AndroidFindBy(id = "com.booking:id/mobile")
    private WebElement mobileInput;

    @AndroidFindBy(id = "com.booking:id/purpose")
    private WebElement purposeInput;

    @AndroidFindBy(id = "com.booking:id/submit_button")
    private WebElement submitButton;


    public void fillReservationForm(String firstname, String lastname,
                                    String email, String country,
                                    String mobile, String purpose) {
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        emailInput.sendKeys(email);
        countryInput.sendKeys(country);
        mobileInput.sendKeys(mobile);
        purposeInput.sendKeys(purpose);
        submitButton.click();
    }


}
