package stepdefinitions;

import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

import static manager.DriverManager.getDriver;
import static org.junit.Assert.assertTrue;

public class CommonDefinitionSteps {

    private final HomePage homePage = new PageFactoryManager().getHomePage();
    private final WebDriver driver = getDriver();

    @And("User opens {string} page")
    public void openPage(final String url) {
        driver.get(url);
    }

    @And("User switches to new opened tab in browser")
    public void userSwitchesToNewOpenedTabInBrowser() {
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    @And("User sees {string} on the top navigation bar")
    public void verifyFirstNameOnTheTopNavigationBar(final String expectedFirstName) {
        String accountFirstName = homePage.getAccountNameText();
        assertTrue(accountFirstName.contains(expectedFirstName));
    }
}
