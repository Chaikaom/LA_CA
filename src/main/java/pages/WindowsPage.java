package pages;

import javafx.scene.control.Tab;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class WindowsPage extends  ParentPage{

    public WindowsPage(WebDriver webDriver){ super(webDriver);
    }
    public void NewWindows() throws InterruptedException{
        Thread.sleep(6000);
        Actions action =new Actions(webDriver);
        try {
            action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
            logger.info("Window was switched");
        }catch (Exception e){
            logger.error("Can not switch");
            Assert.fail("Can not switch");
        }
    }
    public void SwitchWindows() throws  InterruptedException{
        Thread.sleep(6000);
        ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs2.get(1));
        webDriver.switchTo().window((String) tabs2.get(0));
        webDriver.switchTo().window((String) tabs2.get(2));
    }
}
