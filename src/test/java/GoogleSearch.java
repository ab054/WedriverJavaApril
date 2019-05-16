import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearch {

    WebDriver driver;

    //TODO: run this test in DEBUGGER
    @Test
    public void test001() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();


        openMainPage();
        typeQuery();
        submitSearch();
        waitForResults();
        assertResultPage();
    }

    private void waitForResults() {
        By resultsStatsElement = By.id("resultStats");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsStatsElement));
    }

    //TODO: add more meaningful assertion
    private void assertResultPage() {
        WebElement resultsStatsElement = driver.findElement(By.id("resultStats"));
        boolean isElementDisplayed = resultsStatsElement.isDisplayed();
        boolean expectedResult = true;
        Assert.assertEquals(isElementDisplayed, expectedResult);
    }

    private void submitSearch() {
        WebElement searchInput = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input"));
        searchInput.submit();
    }

    private void typeQuery() {
        WebElement searchInput = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input"));
        searchInput.sendKeys("portnov computer school");
    }

    private void openMainPage() {
        String url = "https://google.com";
        driver.get(url);
    }
}
