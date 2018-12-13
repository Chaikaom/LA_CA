package homeTest;

import org.junit.Test;
import parentTest.ParentTest;

public class HomeTest extends ParentTest {
    @Test
    public void Start() throws InterruptedException{
        homePage.openHomePage();
        homePage.click1();
        homePage.click2();
        homePage.click3();
        windowsPage.SwitchWindows();
//        windowsPage.NewWindows();
//        windowsPage.NewWindows();
    }
}
