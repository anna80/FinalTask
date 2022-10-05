package stepdefinitions;

import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import pages.ProductPage;

public class ProductPageDefinitionSteps {

    private final ProductPage productPage = new PageFactoryManager().getProductPage();

    @And("user selects {string} Manufacturer Colour for product")
    public void selectsManufacturerColourForProduct(final String color) {
        productPage.selectManufacturerColour(color);
    }

    @And("user selects {string} Storage for product")
    public void selectsStorageForProduct(final String storage) {
        productPage.selectStorage(storage);
    }

    @And("User clicks 'Add to Cart' button on the Product page")
    public void clickAddToCartButtonOnProductPage() {
        productPage.clickAddToCartButton();
    }
}
