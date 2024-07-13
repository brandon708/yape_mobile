package com.yape.mobile.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SearchDateScreenBookings extends PageObject {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='startDate']")
    private WebElement selectStartDate;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='finalDate']")
    private WebElement selectFinalDate;
    @AndroidFindBy(id = "com.booking:id/facet_date_picker_confirm")
    private WebElement btnConfirm;


    private String convertDate(String inputDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        Date date = inputFormat.parse(inputDate);
        return outputFormat.format(date);
    }


    public void selectDate(String startDate, String finalDate) throws ParseException {
        String formattedStartDate = convertDate(startDate);
        String formattedFinalDate = convertDate(finalDate);

        WebElement startElement = find(By.xpath("//android.view.View[@content-desc='" + formattedStartDate + "']"));
        startElement.click();

        WebElement finalElement = find(By.xpath("//android.view.View[@content-desc='" + formattedFinalDate + "']"));
        finalElement.click();
        btnConfirm.click();
    }
}
