import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GoogleResultsPage {

    public By results = By.id("resultStats");
    WebDriver driver;

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: add more meaningful assertion
    public void assertResults() {
        WebElement resultsStatsElement = driver.findElement(results);
        boolean isElementDisplayed = resultsStatsElement.isDisplayed();
        boolean expectedResult = true;
        Assert.assertEquals(isElementDisplayed, expectedResult);
    }
}
