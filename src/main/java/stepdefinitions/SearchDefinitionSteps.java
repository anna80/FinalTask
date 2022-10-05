package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import pages.SearchResultPage;

public class SearchDefinitionSteps {

    private final SearchResultPage searchResultPage = new PageFactoryManager().getSearchResultPage();

    @And("User verify search field visibility")
    public void verifySearchFieldVisibility() {
        searchResultPage.isSearchFieldVisible();
    }

    @When("User searches products by {string} keyword")
    public void enterKeywordInSearchingField(final String keyword) {
        searchResultPage.enterTextToSearchField(keyword);
        searchResultPage.clickSearchButton();
    }
}
