package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.WaitingUtils.waitVisibilityOfElement;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(@aria-label,'shopping cart')]")
    private WebElement cartButton;

    @FindBy(xpath = "//div[@id='watchWrapperId']")
    private WebElement watchListText;

    @FindBy(xpath = "//a[@title='Watchlist']")
    private WebElement watchListTopNavigatorBar;

    @FindBy(xpath = "//span[@id='gh-ug']//a[text()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[contains(text(),'register')]")
    private List<WebElement> registerLink;

    @FindBy(xpath = "//div[@role='navigation']//button[@id='gh-ug']")
    private WebElement accountNameText;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartIconVisible() {
        waitVisibilityOfElement(cartButton);
        return cartButton.isDisplayed();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickRegisterButton() {
        registerLink.get(0).click();
    }

    public String getAccountNameText() {
        return accountNameText.getText();
    }
}
