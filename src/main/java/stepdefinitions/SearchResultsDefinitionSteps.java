package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebElement;
import pages.SearchResultPage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.WaitingUtils.waitForAjaxToComplete;
import static utils.WaitingUtils.waitForPageLoadComplete;

public class SearchResultsDefinitionSteps {

    private SearchResultPage searchResultPage = new PageFactoryManager().getSearchResultPage();

    @Then("Search result products are shown on the Search Results page")
    public void verifyThatSearchResultProductsAreShown() {
        List<WebElement> products = searchResultPage.getSearchResultItems();
        assertTrue(products.size() > 0);
    }

    @When("User clicks on the first product image on the Search Results page")
    public void clickOnFirstProductImageOnSearchResultsPage() {
        List<WebElement> productImages = searchResultPage.getProductsImages();
        productImages.get(0).click();
        waitForPageLoadComplete();
        waitForAjaxToComplete();
    }

    @And("Each product title contains searching word {string}")
    public void eachProductTitleContainsSearchingWordKeyword(final String keyword) {
        List<String> productsTitles = searchResultPage.getProductsTitles();
        productsTitles.forEach(title -> assertTrue(title.toLowerCase().contains(keyword.toLowerCase())));
    }

    @And("User sees {int} products on the Search Results page")
    public void veridyProductsQtyOnTheSearchResultsPage(final int expectedProductsQtyPerPage) {
        SearchResultPage searchResultPage = new PageFactoryManager().getSearchResultPage();
        List<WebElement> products = searchResultPage.getSearchResultItems();
        assertEquals(products.size(), expectedProductsQtyPerPage);
    }

    @When("User selects 'Items Per Page' value {int} at navigation menu")
    public void userSelectsItemsPerPageValueAtNavigationMenu(final int itemsPerPageNewValue) {
        searchResultPage.selectItemsPerPageValue(itemsPerPageNewValue);
    }
}
