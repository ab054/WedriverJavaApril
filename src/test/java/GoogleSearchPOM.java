import org.testng.annotations.Test;

public class GoogleSearchPOM extends BaseTest {

    @Test
    public void test001() {
        String textValue = "portnov computer school";

        GoogleMainPage googleMainPage = new GoogleMainPage(driver);
        GoogleResultsPage googleResultsPage = new GoogleResultsPage(driver);

        googleMainPage.openMainPage();
        googleMainPage.typeQuery(textValue);
        googleMainPage.submitSearch();
        waitForElement(googleResultsPage.results);
        googleResultsPage.assertResults();
    }

}
