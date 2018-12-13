package parentTest;

import io.qameta.allure.Step;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected HomePage homePage;
    protected WindowsPage windowsPage;


    Logger logger = Logger.getLogger(getClass());

    protected String browser = System.getProperty("browser");
    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

      homePage = new HomePage(webDriver);
      windowsPage = new WindowsPage(webDriver);
    }

//    @After
//    public void tearDown() {
//        webDriver.quit();
//    }

    @Step
    protected void checkAC(String message, boolean actual, boolean expected) {
        if (!(actual == expected)) {
            logger.error("AV failed:" + message);
        }
        Assert.assertEquals(message, expected, actual);
    }

}
