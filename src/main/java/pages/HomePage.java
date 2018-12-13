package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = "//*[@id=\"cross-product-bar\"]/div/a[1]")
    private WebElement oneclick;
    @FindBy(xpath = "//*[@id=\"cross-product-bar\"]/div/a[2]")
    private WebElement twoclick;
    @FindBy(xpath = "//*[@id=\"cross-product-bar\"]/div/a[3]")
    private WebElement threeclick;

    public HomePage(WebDriver webDriver){
        super(webDriver);
    }
    public void openHomePage(){
        try {
            webDriver.get("http://booking.com");
            logger.info("homeTest was opened");
        }catch (Exception e){
            logger.error("Can not open homeTest");
            Assert.fail("Can not open homeTest");
        }
    }
    public void click1(){
        actionWithOurElements.clickOnElement(oneclick);
    }
    public void click2(){
        actionWithOurElements.clickOnElement(twoclick);
    }
    public void click3(){
        actionWithOurElements.clickOnElement(threeclick);
    }

}
