package BOs;

import POs.SignUpPO;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumDriver;

public class SignUpBO {

    SignUpPO signUpPO;

    public SignUpBO(AppiumDriver appiumDriver) {
        signUpPO = new SignUpPO(appiumDriver);
    }

    public void fillSignUpFormAndSubmit(String name, String surName, String birthdate, String gender, String weight, String username, String password, String email) {
        signUpPO.setName(name);
        signUpPO.setSurName(surName);
        signUpPO.setBirthdate(birthdate);
        signUpPO.selectGender(gender);
        signUpPO.setWeight(weight);
        signUpPO.setUsername(username);
        signUpPO.setPassword(password);
        signUpPO.setEmail(email);
        signUpPO.clickSignUpButton();
    }

    public void verifySignUpSuccessfulAlert() {
        Assert.isTrue(signUpPO.isSignUpSuccessfulAlertDisplayed(), "Sign up Successful alert not displayed");
    }

}
