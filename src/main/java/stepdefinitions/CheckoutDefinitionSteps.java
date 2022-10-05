package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import manager.PageFactoryManager;
import org.openqa.selenium.WebElement;
import pages.CheckoutPage;

import java.util.List;

import static manager.DriverManager.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutDefinitionSteps {

    private final CheckoutPage checkoutPage = new PageFactoryManager().getCheckoutPage();

    @And("User click 'Continue as guest' button")
    public void clickContinueAsGuestButton() {
        checkoutPage.clickContinueAsGuestButton();
    }

    @Then("Checkout page is opened")
    public void verifyThatCheckoutPageIsOpened() {
        assertTrue(getDriver().getTitle().contains("Checkout"));
        assertEquals("Checkout", checkoutPage.getPageHeadingText());
    }

    @And("{int} product is present in 'Review item and shipping' section")
    public void productIsPresentInSection(final int itemsQuantity) {
        List<WebElement> productsList = checkoutPage.getProducts();
        assertEquals(productsList.size(), itemsQuantity);
    }

    @And("'Ship to' form is visible on the Checkout page")
    public void shipToFormIsVisibleOnCheckoutPage() {
        assertTrue(checkoutPage.isShipToFormVisible());
    }

    @And("'Pay with' section is visible")
    public void payWithSectionIsVisible() {
        assertTrue(checkoutPage.isPayWithSectionVisible());
    }


    @And("'Confirm and pay' button is visible")
    public void confirmAndPayButtonIsVisible() {
        assertTrue(checkoutPage.isConfirmAndPayVisible());
    }
}
