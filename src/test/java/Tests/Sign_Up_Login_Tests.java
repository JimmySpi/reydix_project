package Tests;

import BOs.LandingPageBO;
import BOs.LoginBO;
import BOs.SignUpBO;
import TestObjects.UserInfo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sign_Up_Login_Tests extends BaseTest{

    LoginBO loginBO;
    SignUpBO signUpBO;
    LandingPageBO landingPageBO;
    UserInfo userInfo1;

    @BeforeClass
    public void load() {
        loginBO = new LoginBO(appiumDriver);
        signUpBO = new SignUpBO(appiumDriver);
        landingPageBO = new LandingPageBO(appiumDriver);
    }

    @BeforeClass(dependsOnMethods = "load")
    public void loader() {
        userInfo1 = UserInfo.getUserInfo1();
    }

    @Test
    public void login_failed_attempt() {
        loginBO.loginWith(userInfo1.getUser_name(), userInfo1.getPassword());
        loginBO.verifyLoginFailedAlert();
    }

    @Test(dependsOnMethods = "login_failed_attempt")
    public void sign_up_successful() {
        loginBO.signUp();
        signUpBO.fillSignUpFormAndSubmit(userInfo1.getName(), userInfo1.getSurName(), userInfo1.getBirthdate(), userInfo1.getGender(), userInfo1.getWeight(),
                userInfo1.getUser_name(), userInfo1.getPassword(), userInfo1.getEmail());
        signUpBO.verifySignUpSuccessfulAlert();
    }

    @Test(dependsOnMethods = "sign_up_successful")
    public void login_successful() {
        loginBO.loginWith(userInfo1.getUser_name(), userInfo1.getPassword());
        landingPageBO.verifyLandingPageIsInView();
    }

}
