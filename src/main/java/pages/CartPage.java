package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.WaitingUtils.waitForAjaxToComplete;
import static utils.WaitingUtils.waitForPageLoadComplete;
import static utils.WaitingUtils.waitVisibilityOfElement;

public class CartPage extends BasePage {

    private static String OPTION = "/option";

    @FindBy(xpath = "//a[@data-test-id='start-shopping']")
    private WebElement startShoppingButton;

    @FindBy(xpath = "//h1[@data-test-id='main-title']")
    private WebElement cartPageHeading;

    @FindBy(xpath = "//div[@class='cart-bucket-lineitem']")
    private List<WebElement> cartItems;

    @FindBy(xpath = "(//div[@class='listsummary']//select[@data-test-id='qty-dropdown'])[1]")
    private WebElement productQtySelectBox;

    @FindBy(xpath = "//div[@class='cartsummary-cta']/button")
    private WebElement checkoutButton;

    @FindBy(xpath = "//i[@id='gh-cart-n']")
    private List<WebElement> productOnCart;

    @FindBy(xpath = "//button[contains(@aria-label,'Remove')]")
    private WebElement removeProductFromCartLink;

    @FindBy(xpath = "//div[@class='font-title-3']")
    private WebElement emptyCartSection;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickStartShoppingButton() {
        startShoppingButton.click();
    }

    public List<WebElement> getCartItems() {
        waitForPageLoadComplete();
        waitForAjaxToComplete();
        return cartItems;
    }

    public void clickOnProductQtySelectBox() {
        productQtySelectBox.click();
    }

    public void selectProductQty(final int productQuantity) {
        productQtySelectBox.findElements(By.xpath(OPTION)).stream()
                .filter(option -> option.getText().equals(productQuantity)).findFirst().get().click();
    }

    public String getCartPageHeadingText() {
        return cartPageHeading.getText();
    }


    public void clickGoToCheckoutButton(){
        waitVisibilityOfElement(checkoutButton);
        checkoutButton.click();
    }

    public void clickRemoveProductLink(){
        waitVisibilityOfElement(removeProductFromCartLink);
        removeProductFromCartLink.click();
    }

    public String getEmptyCartMessage(){
        waitVisibilityOfElement(emptyCartSection);
        return emptyCartSection.getText();
    }
}
