package BOs;

import POs.LandingPagePO;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumDriver;

public class LandingPageBO {

    LandingPagePO landingPagePO;

    public LandingPageBO(AppiumDriver appiumDriver) {
        landingPagePO = new LandingPagePO(appiumDriver);
    }

    public void verifyLandingPageIsInView() {
        Assert.isTrue(landingPagePO.isQuoteOfTheDayDisplayed(), "Landing Page is mpt in view");
    }

}
