import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMainPage {

    public static By searchInput = By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input");
    WebDriver driver;

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void submitSearch() {
        WebElement searchInput = driver.findElement(GoogleMainPage.searchInput);
        searchInput.submit();
    }

    public void typeQuery(String queryText) {
        WebElement searchInput = driver.findElement(GoogleMainPage.searchInput);
        searchInput.sendKeys(queryText);
    }

    public void openMainPage() {
        String url = "https://google.com";
        driver.get(url);
    }

}
