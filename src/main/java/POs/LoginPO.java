package POs;

import io.appium.java_client.AppiumDriver;

public class LoginPO extends BasePO {

    public enum Locators {

        LOGIN_INPUT_FIELD("xpath==//android.widget.EditText[@hint=\"{0}\"]"),
        SIGN_IN_BTN("xpath==//android.widget.Button[@content-desc=\"Sign in\"]"),
        SIGN_UP_LINK_BTN("aid==Sign up");

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

    public LoginPO(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void setUsername(String username) {
        input(Locators.LOGIN_INPUT_FIELD.getWithParams("Enter your name"), username);
    }

    public void setPassword(String password) {
        input(Locators.LOGIN_INPUT_FIELD.getWithParams("Enter your password"), password);
    }

    public void clickLoginButton() {
        click(Locators.SIGN_IN_BTN.get());
    }

    public void clickSignUpButton() {
        click(Locators.SIGN_UP_LINK_BTN.get());
    }

    public boolean isLoginFailedAlertDisplayed() {
        return isDisplayed("aid==Login failed");
    }

}
