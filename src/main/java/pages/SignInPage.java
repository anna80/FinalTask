package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.WaitingUtils.waitForAjaxToComplete;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='userid']")
    private WebElement useridInputField;

    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[@id='sgnBt']")
    private WebElement signInButton;

    public void enterDataToUseridField(final String data) {
        useridInputField.clear();
        useridInputField.sendKeys(data);
    }

    public void clickContinueButton() {
        continueButton.click();
        waitForAjaxToComplete();
    }

    public void clickSignInButton() {
        signInButton.click();
        waitForAjaxToComplete();
    }
}
