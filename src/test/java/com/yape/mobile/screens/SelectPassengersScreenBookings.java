package com.yape.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class SelectPassengersScreenBookings extends PageObject {
    private AppiumDriver driver;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView")
    private WebElement selectInputPassenger;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement cantRoomText;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.Button[2]")
    private WebElement addRooms;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement cantAdultsText;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.Button[2]")
    private WebElement addAdults;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[3]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement cantChildrenText;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[3]/android.widget.LinearLayout/android.widget.Button[2]")
    private WebElement addChildren;
    @AndroidFindBy(id = "android:id/numberpicker_input")
    private WebElement agePickerInput;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement btnOK;
    @AndroidFindBy(id = "com.booking:id/group_config_apply_button")
    private WebElement btnApply;
    @AndroidFindBy(id = "com.booking:id/facet_search_box_legacy_theme_cta_border_top")
    private WebElement btnSearch;

    public SelectPassengersScreenBookings(WebDriver driver) {
        this.driver = (AppiumDriver) ((WebDriverFacade) driver).getProxiedDriver();
    }

    public void selectPassenger() {
        selectInputPassenger.click();
    }

    private int getElementCount(WebElement element) {
        return Integer.parseInt(element.getText());
    }

    private void selectElements(int desiredCount, WebElement countElement, WebElement addButton) {
        int currentCount = getElementCount(countElement);

        if (currentCount < desiredCount) {
            for (int i = currentCount; i < desiredCount; i++) {
                addButton.click();
            }
        }
    }

    public void selectRooms(int habitacion) {
        selectElements(habitacion, cantRoomText, addRooms);
    }

    public void selectAdults(int cantAdultos) {
        selectElements(cantAdultos, cantAdultsText, addAdults);
    }


    public void selectChildren(int cantNinos, int edadNinos) {
        if (edadNinos <= 17) {
            for (int i = 0; i < cantNinos; i++) {
                addChildren.click();
                setAgePicker(edadNinos);
                btnOK.click();
            }
        }
    }

    public void selectApply() {
        btnApply.click();
    }

    private void setAgePicker(int desiredAge) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(agePickerInput));

        while (true) {
            try {
                String ageText = agePickerInput.getText().trim();

                if (ageText.startsWith(String.valueOf(desiredAge))) {
                    break;
                }
                swipeNumberPicker(Integer.parseInt(ageText.replaceAll("[^0-9]", "")) < desiredAge);
            } catch (NoSuchElementException e) {
                System.out.println("Element not found: " + e.getMessage());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Number format exception: " + e.getMessage());
                swipeNumberPicker(true);
            }
        }
    }

    private void swipeNumberPicker(boolean swipeUp) {
        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        int startX = agePickerInput.getLocation().getX() + (agePickerInput.getSize().getWidth() / 2);
        int startY = agePickerInput.getLocation().getY() + (agePickerInput.getSize().getHeight() / 2);
        int endY = swipeUp ? startY - 105 : startY + 105;

        action.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    public void selectSearch() {
        btnSearch.click();
    }
}
