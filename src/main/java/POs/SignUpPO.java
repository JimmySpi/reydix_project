package POs;

import io.appium.java_client.AppiumDriver;

public class SignUpPO extends BasePO {

    CalendarPO calendarPO;
    public SignUpPO(AppiumDriver appiumDriver) {
        super(appiumDriver);
        calendarPO = new CalendarPO(appiumDriver);
    }

    public enum Locators {

        SIGN_UP_INPUT_FIELD("xpath==//android.view.View[@content-desc=\"{0}\"]/following-sibling::android.widget.EditText"),
        BIRTHDATE_FIELD("xpath==//android.view.View[@content-desc=\"{0}\"]/following-sibling::android.view.View"),
        SIGN_UP_SELECT_FIELD("xpath==//android.view.View[@content-desc=\"{0}\"]/following-sibling::android.widget.Button"),
        SIGN_UP_SELECT_OPTION("xpath==//android.view.View[@content-desc=\"{0}\"]"),
        SIGN_UP_BTN("xpath==//android.widget.Button[@content-desc=\"Sign up\"]");


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

    public void setName(String name) {
        input(Locators.SIGN_UP_INPUT_FIELD.getWithParams("Name"), name);
    }

    public void setSurName(String surName) {
        input(Locators.SIGN_UP_INPUT_FIELD.getWithParams("Surname"), surName);
    }

    public void setBirthdate(String birthdate) {
        click(Locators.BIRTHDATE_FIELD.getWithParams("Birthdate"));
        calendarPO.clickEdit();
        calendarPO.setDate(birthdate);
        calendarPO.clickOk();
    }

    public void selectGender(String gender) {
        select(Locators.SIGN_UP_SELECT_FIELD.getWithParams("Gender"), Locators.SIGN_UP_SELECT_OPTION.getWithParams(gender));
    }

    public void setWeight(String weight) {
        input(Locators.SIGN_UP_INPUT_FIELD.getWithParams("Weight"), weight);
    }

    public void setUsername(String username) {
        input(Locators.SIGN_UP_INPUT_FIELD.getWithParams("Username"), username);
    }

    public void setPassword(String password) {
        input(Locators.SIGN_UP_INPUT_FIELD.getWithParams("Password"), password);
    }

    public void setEmail(String email) {
        input(Locators.SIGN_UP_INPUT_FIELD.getWithParams("Email"), email);
    }

    public void clickSignUpButton() {
        click(Locators.SIGN_UP_BTN.get());
    }

    public boolean isSignUpSuccessfulAlertDisplayed() {
        return isDisplayed("aid==Account created");
    }
}
