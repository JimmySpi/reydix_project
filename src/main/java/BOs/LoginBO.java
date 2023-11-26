package BOs;

import POs.LoginPO;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumDriver;

public class LoginBO {

    LoginPO loginPO;

    public LoginBO(AppiumDriver appiumDriver) {
        loginPO = new LoginPO(appiumDriver);
    }

    public void loginWith(String username, String password) {
        loginPO.setUsername(username);
        loginPO.setPassword(password);
        loginPO.clickLoginButton();
    }

    public void signUp() {
        loginPO.clickSignUpButton();
    }

    public void verifyLoginFailedAlert() {
        Assert.isTrue(loginPO.isLoginFailedAlertDisplayed(), "Login failed alert not displayed");
    }

}
