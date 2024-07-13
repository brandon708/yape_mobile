package com.yape.mobile.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class SelectDesiredRoomsScreenBookings extends PageObject {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.view.ViewGroup")
    private WebElement clicNext;

    @AndroidFindBy(id = "com.booking:id/rooms_item_select_text_view")
    private WebElement selectFirstOption;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.Button")
    private WebElement clickReserve;

    public void clickNext() {
        clicNext.click();
    }

    public void selectFirstOption() {
        selectFirstOption.click();
    }

    public void clickReserva() {
        clickReserve.click();
    }
}
