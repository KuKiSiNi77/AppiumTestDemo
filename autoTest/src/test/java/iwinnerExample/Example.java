package iwinnerExample;

import InitDriver.InitDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

public class Example extends InitDriver {
    /**
     * 测试步骤
     * 1. 在微信界面点击"我"，进入个人画面
     * 2. 点击"卡包"，再次点击"查看全部"，表示所有会员卡
     * 3. 点击"风筝卡"进入风筝卡会员界面
     * 4. 点击界面的"储值"，进入"储值·鼓励金"小程序
     * <p>
     * 通过使用`@Test(priority = 1)`控制每个用例的执行顺序
     * 没有注明`(priority = 1)`默认值为0，最优先执行
     */
    @Test
    public void testOne() throws Throwable {

        driver.findElementByXPath("//*[@resource-id='com.tencent.mm:id/cdj' and @text='我']").click();
        driver.findElementByXPath("//*[@text='卡包']").click();
        driver.findElementByXPath("//*[contains(@text,'查看全部')]").click();

        Thread.sleep(5000);
        for (Object el : driver.findElementsByXPath("//*[@resource-id='com.tencent.mm:id/a1_']")) {
            System.out.println(((MobileElement) el).getText());
        }

        driver.findElementByXPath("//*[@text='风筝卡']").click();
        driver.findElementByXPath("//*[@text='储值']").click();
        Thread.sleep(5000);
        System.out.println("获取元素\n" + driver.getPageSource());
    }
}
