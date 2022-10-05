package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebElement;
import pages.ProductPage;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WatchListDefinitionSteps {

    private final ProductPage productPage = new PageFactoryManager().getProductPage();

    @And("User clicks 'Add to Watchlist' button")
    public void clickAddToWatchListButton() {
        productPage.clickAddToWatchListButton();
    }

    @Then("User sees that the button renamed to {string}")
    public void verifyThatButtonRenamedToWatching(final String expectedButtonName) {
        assertEquals(productPage.getAddToWatchListButtonText(), expectedButtonName);
    }

    @When("User clicks to 'Watchlist' link on the top navigation bar")
    public void clickToWatchlistLinkOnTheTopNavigationBar() {
        productPage.clickWatchListLink();
    }

    @Then("User sees that {int} product is added to watchlist")
    public void verifyThatProductIsAddedToWatchlist(final int expectedProductQuantity) {
        List<WebElement> watchListProducts = productPage.getWatchListProducts();
        assertEquals(watchListProducts.size(), expectedProductQuantity);
    }
}
