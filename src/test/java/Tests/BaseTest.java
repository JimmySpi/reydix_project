package Tests;

import TestContext.TestDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    AppiumDriver appiumDriver;
    static AppiumDriverLocalService service;

    @BeforeSuite
    public void startAppiumServer() throws IOException, InterruptedException {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    @BeforeClass
    public void beforeClass(ITestContext context) throws IOException, InterruptedException {
        if(!service.isRunning()) service.start();
        String device = context.getCurrentXmlTest().getParameter("device");
        //if(device.toLowerCase().startsWith("emulator")) { startEmulator(device); }
        TestDriver.initializeDriver(device);
        appiumDriver = TestDriver.getDriverInstance();
    }

    @AfterClass
    public void afterClass() {
        appiumDriver.quit();
        service.stop();
    }

    @AfterSuite
    public void closeAppiumServer() throws IOException, InterruptedException {
        service.close();
    }

    private void startEmulator(String device) {

        String emulator_name = "";
        switch (device) {
            case "emulator_android14":
                emulator_name = "androidem1";
                break;
        }
        //String sdkPath = "C:\\Users\\Jimmy\\AppData\\Local\\Android\\sdk";
        String emulatorPath = "C:\\Users\\Jimmy\\.android\\avd\\" + emulator_name+ ".adv";

        System.out.println("Starting emulator for '" + emulator_name + "' ...");
        String[] aCommand = new String[] { emulatorPath, "-avd", emulator_name };
        try {
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(150, TimeUnit.SECONDS);
            System.out.println("Emulator launched successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
