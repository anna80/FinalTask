package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebElement;
import pages.CartPage;
import pages.HomePage;

import java.util.List;

import static manager.DriverManager.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartDefinitionSteps {

    private final HomePage homePage = new PageFactoryManager().getHomePage();
    private final CartPage cartPage = new PageFactoryManager().getCartPage();

    @And("User verify the visibility of the cart icon")
    public void verifyVisibilityOfCartIcon() {
        assertTrue("Cart icon is invisible on the page", homePage.isCartIconVisible());
    }

    @When("User clicks by the shopping cart icon")
    public void clicksOnCartButton() {
        homePage.clickCartButton();
    }

    @Then("Cart page with {string} url is opened")
    public void cartPageIsOpened(final String expectedUrl) {
        String cartPageUrl = getDriver().getCurrentUrl();
        assertEquals(cartPageUrl, expectedUrl);
    }

    @Then("{string} page is opened")
    public void verifyPageIsOpened(final String url) {
        String currentPageUrl = getDriver().getCurrentUrl();
        assertEquals(currentPageUrl, url);
    }

    @Then("User verifies that {int} product(s) in the cart")
    public void verifyThatProductsPresentInCart(final int productsQuantity) {
        List<WebElement> cartItems = cartPage.getCartItems();
        assertEquals("Quantity of products in the cart are not as expected.", cartItems.size(), productsQuantity);
    }

    @When("User selects product qty {int}")
    public void selectProductQty(final int productQuantity) {
        cartPage.clickOnProductQtySelectBox();
        cartPage.selectProductQty(productQuantity);
    }

    @And("User verifies that cart heading contains text {string}")
    public void userVerifiesThatCartHeadingContainsTextItems(final String expectedText) {
        String cartHeadingText = cartPage.getCartPageHeadingText();
        assertTrue("Cart heading text contains incorrect quantity of products in the cart", cartHeadingText.contains(expectedText));
    }

    @And("User clicks 'Start shopping' button")
    public void clickStartShoppingButton() {
        cartPage.clickStartShoppingButton();
    }

    @When("User clicks on 'Go to checkout' button")
    public void clickGoToCheckoutButton() {
        cartPage.clickGoToCheckoutButton();
    }

    @And("User clicks 'Remove' button")
    public void clickRemoveButton() {
        cartPage.clickRemoveProductLink();
    }

    @Then("User sees the message {string} on the Cart page")
    public void verifyThatMessageForEmptyCartIsShownOnCartPage(final String expectedText) {
        String emptyCartMessage = cartPage.getEmptyCartMessage();
        assertEquals(emptyCartMessage, expectedText);
    }
}
