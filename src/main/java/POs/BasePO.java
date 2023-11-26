package POs;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePO {

    AppiumDriver appiumDriver;
    WebDriverWait wait;

    BasePO(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10000));
    }

    public void click(String locator) {
        waitForElement(locator);
        WebElement element = appiumDriver.findElement(locatorProcess(locator));
        element.click();
    }

    public void input(String locator, String text) {
        waitForElement(locator);
        WebElement element = appiumDriver.findElement(locatorProcess(locator));
        element.click();
        element.clear();
        element.sendKeys(text);
        appiumDriver.navigate().back();
    }

    public void select(String select_locator, String option_locator) {
        waitForElement(select_locator);
        WebElement select_element = appiumDriver.findElement(locatorProcess(select_locator));
        select_element.click();
        waitForElement(option_locator);
        WebElement option_element = appiumDriver.findElement(locatorProcess(option_locator));
        option_element.click();
    }

    public String getText(String locator) {
        waitForElement(locator);
        WebElement element = appiumDriver.findElement(locatorProcess(locator));
        return element.getText();
    }

    public boolean isDisplayed(String locator) {
        WebElement element = appiumDriver.findElement(locatorProcess(locator));
        return element.isDisplayed();
    }

    public void waitForElement(String locator) {
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(locatorProcess(locator))));
        wait.until(ExpectedConditions.elementToBeClickable(appiumDriver.findElement(locatorProcess(locator))));
    }


    private By locatorProcess(String locator) {
        By by = null;
        String locator_payload = locator.split("==")[1];
        String locator_strategy = locator.split("==")[0];
        switch (locator_strategy) {
            case "xpath":
                by = AppiumBy.xpath(locator_payload);
                break;
            case "aid":
                by = AppiumBy.accessibilityId(locator_payload);
                break;
        }
        return by;
    }

}
