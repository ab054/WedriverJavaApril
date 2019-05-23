import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GoogleSearch {

    WebDriver driver;

    //TODO: run this test in DEBUGGER

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }

    @Test
    public void test001() {
        String textValue = "portnov computer school";

        openMainPage();
        typeQuery(textValue);
        submitSearch();
        waitForResults();
        assertResultPage();
    }

    @Test
    public void test002() {
        String textValue = "#@#@!$!!#!@!";


        openMainPage();
        typeQuery(textValue);
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

    private void typeQuery(String queryText) {
        WebElement searchInput = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input"));
        searchInput.sendKeys(queryText);
    }

    private void openMainPage() {
        String url = "https://google.com";
        driver.get(url);
    }
}
