import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandlesTest {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    //TODO: create a different scenario
    @Test
    public void test002() {
    }

    //TODO: refactor into user actions steps
    @Test
    public void test0001() {
        driver.get("https://the-internet.herokuapp.com/windows");

        String linkText = "Click here";

        By linkByText = By.linkText("Click Here");

        WebElement linkElement = driver.findElement(linkByText);

        linkElement.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> allWindowHandles = driver.getWindowHandles();

        boolean isTwoWindowOpened = allWindowHandles.size() == 2;

        Assert.assertTrue(isTwoWindowOpened);

        String windowHandle1 = (String) allWindowHandles.toArray()[0];
        String windowHandle2 = (String) allWindowHandles.toArray()[1];

        driver.switchTo().window(windowHandle2);

        String pageSource = driver.getPageSource();

        String textToCheck = "New Window";

        boolean isTextThere = pageSource.contains(textToCheck);

        Assert.assertTrue(isTextThere);

        driver.switchTo().window(windowHandle1);

        String windowTitle = driver.getTitle();
        String titlePartialText = "Internet";
        boolean isTitleContainText = windowTitle.contains(titlePartialText);
        Assert.assertTrue(isTitleContainText);
    }
}
