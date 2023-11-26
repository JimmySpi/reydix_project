package POs;

import io.appium.java_client.AppiumDriver;

public class CalendarPO extends BasePO{

    public CalendarPO(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public enum Locators {

        EDIT_DATE_BTN("xpath==//android.view.View[contains(@content-desc,'SELECT DATE')]/android.widget.Button[1]"),
        INPUT_DATE("xpath==//android.widget.EditText[@hint=\"Enter Date\"]"),
        OK_BTN("aid==OK");

        final String locator;

        Locators(String locator) { this.locator = locator;}
        String get() { return locator; }
        String getWithParams(String... args) {
            String locator_parameterized = locator;
            for (int i=0; i<args.length; i++) {
                locator_parameterized = locator_parameterized.replace("{"+i+"}", String.valueOf(args[i]));
            }
            return locator_parameterized;
        }
    }

    public void clickEdit() {
        click(Locators.EDIT_DATE_BTN.get());
    }

    public void setDate(String date) {
        input(Locators.INPUT_DATE.get(), date);
    }

    public void clickOk() {
        click(Locators.OK_BTN.get());
    }
}
