package manager;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import pages.RegistrationPage;
import pages.SearchResultPage;
import pages.SignInPage;

import static manager.DriverManager.getDriver;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager() {
        this.driver = getDriver();
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public CartPage getCartPage() {
        return new CartPage(driver);
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public RegistrationPage getRegistrationPage() {
        return new RegistrationPage(driver);
    }

    public ProductPage getProductPage() { return new ProductPage(driver);}

    public SignInPage getSignInPage() { return new SignInPage(driver);}
}

