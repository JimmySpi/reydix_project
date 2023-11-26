package POs;

import io.appium.java_client.AppiumDriver;

public class LandingPagePO extends BasePO {

    public LandingPagePO(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public enum Locators {

        QUOTE_OF_THE_DAY("aid==Quote of the day");

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

    public boolean isQuoteOfTheDayDisplayed() {
        return isDisplayed(Locators.QUOTE_OF_THE_DAY.get());
    }

}
