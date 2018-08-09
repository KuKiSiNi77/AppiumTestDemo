package iwinnerExample;

import InitDriver.InitDriver;
import org.testng.annotations.Test;

public class XueQiu extends InitDriver {

    @Test
    public void demo() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(driver.getPageSource());
    }
}
