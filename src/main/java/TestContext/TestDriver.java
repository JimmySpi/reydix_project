package TestContext;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class TestDriver {

    private static AppiumDriver appiumDriver;
    private static Properties app_properties;
    private static Properties device_properties;
    private static DesiredCapabilities capabilities;
    private static URL appiumServer;

    public static void initializeDriver(String device) throws IOException {

        app_properties = new Properties();
        app_properties.load(new FileInputStream("src/main/resources/app.properties"));
        device_properties = new Properties();
        device_properties.load(new FileInputStream("src/main/resources/"+device+".properties"));

        capabilities = new DesiredCapabilities();

        app_properties.stringPropertyNames().forEach( prop ->
            capabilities.setCapability(prop, app_properties.getProperty(prop))
        );
        device_properties.stringPropertyNames().forEach( prop ->
            capabilities.setCapability(prop, device_properties.getProperty(prop))
        );

        appiumServer = new URL("http://localhost:4723");
        appiumDriver = new AppiumDriver(appiumServer, capabilities);
    }

    public static AppiumDriver getDriverInstance() {
        return appiumDriver;
    }

}
