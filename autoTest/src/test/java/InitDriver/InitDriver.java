package InitDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

/**
 * 测试用例的父类
 */
public class InitDriver {

    public static AppiumDriver driver;

    /**
     * 初始化启动
     *
     * @param udid 设备唯一标志
     * @param port Appium server通信的端口
     */
    @BeforeClass
    @Parameters({"udid", "port", "platformName", "appPackage", "appActivity", "isAppBrand", "androidProcess"})
    public static void setUp(String udid, int port, String platformName,
                             String appPackage, String appActivity,
                             boolean isAppBrand, String androidProcess) throws Throwable {
        System.out.println("udid:" + udid + ",port:" + port);

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", platformName);
        caps.setCapability("deviceName", udid);
        caps.setCapability("udid", udid);
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);
        caps.setCapability("noReset", true);
        caps.setCapability("showChromedriverLog", true);

        if (isAppBrand) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("androidProcess", androidProcess);
            caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        }

        caps.setCapability("browserName", "");

        driver = new AppiumDriver(new URL("http://127.0.0.1:" + port + "/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void afterClass() {
        // 每一个用例完毕结束这次测试
        driver.quit();
    }
}