package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.WaitingUtils.waitVisibilityOfElement;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement pageHeading;

    @FindBy(xpath = "//div[@class='dialog__body']//button[contains(@class,'btn--secondary')]")
    private WebElement continueGuestButton;

    @FindBy(xpath = "//section[contains(@class,'cart-details')]//div[@data-test-id='CART_DETAILS_ITEM']")
    private List<WebElement> products;

    @FindBy(xpath = "//form[@name='address-form']")
    private WebElement shipToForm;

    @FindBy(xpath = "//section[@data-test-id='PAYMENT_METHODS']")
    private WebElement payWithSection;

    @FindBy(xpath = "//button[@data-test-id='CONFIRM_AND_PAY_BUTTON']")
    private WebElement confirmAndPayButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickContinueAsGuestButton() {
        waitVisibilityOfElement(continueGuestButton);
        continueGuestButton.click();
    }

    public boolean isShipToFormVisible() {
        return shipToForm.isDisplayed();
    }

    public boolean isPayWithSectionVisible() {
        return payWithSection.isDisplayed();
    }

    public boolean isConfirmAndPayVisible() {
        return confirmAndPayButton.isDisplayed();
    }

    public String getPageHeadingText() {
        return pageHeading.getText();
    }

    public List<WebElement> getProducts() {
        return products;
    }
}
