package com.yape.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class SelectItemScreenBookings extends PageObject {
    private AppiumDriver driver;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView")
    private WebElement recyclerView;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement recyclerView2;
    @AndroidFindBy(id = "com.booking:id/bui_banner_close_button")
    private WebElement closePopup;


    public SelectItemScreenBookings(WebDriver driver) {
        this.driver = (AppiumDriver) ((WebDriverFacade) driver).getProxiedDriver();
    }

    public void selectSecondItem(int item) {
        scrollToSecondItem(item);

    }

    private boolean isRecyclerView2Visible() {
        try {
            return recyclerView2.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void scrollToSecondItem(int item) {

        for (int i = 0; i < item; i++) {
            if (i <= item - 1) {
                closePopup.click();
            }

            swipeUp();
        }

        if (isRecyclerView2Visible()) {
            recyclerView2.click();

        }
    }

    private void swipeUp() {
        TouchAction action = new TouchAction(driver);
        int startX = recyclerView.getLocation().getX() + (recyclerView.getSize().getWidth() / 2);
        int startY = recyclerView.getLocation().getY() + (recyclerView.getSize().getHeight() / 2);
        int endY = startY - 180;

        action.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }
}
