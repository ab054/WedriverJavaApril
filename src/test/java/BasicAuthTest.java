import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BasicAuthTest {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void openBrowser() {
        driver = new FirefoxDriver();
    }


    @Test
    public void test001() {
        String login = "admin";
        String passw = "admin";

        openBasicAuthPage(login, passw);
        assertThatAuthenticated();
    }

    @Test
    public void test002() {
        String login = "adminqweqwe";
        String passw = "adminqweqweqweq";

        openBasicAuthPage(login, passw);
        assertThatAuthenticated();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @DataProvider(name = "dataForAuthTest")
    public Object[][] dataForTest() {
        return new Object[][]{
                {"admin", "admin"},
                {"admin3424234", "admin1233213"},
                {"12321", "123123"},
                {"2131", "admi12321#@#@@!@!n1233213"},
        };
    }

    @Test(dataProvider = "dataForAuthTest")
    public void test002WithDP(String paramValue1, String paramValue2) {
        String login = paramValue1;
        String passw = paramValue2;

        openBasicAuthPage(login, passw);
        assertThatAuthenticated();
    }

    private void assertThatAuthenticated() {
        boolean isContainCongrats = driver.getPageSource().contains("Congrat");
        Assert.assertTrue(isContainCongrats);
    }

    private void openBasicAuthPage(String login, String password) {
        String url = "https://" + login + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(url);
    }
}
