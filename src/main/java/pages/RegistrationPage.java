package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

import static utils.WaitingUtils.waitForAjaxToComplete;
import static utils.WaitingUtils.waitForPageLoadComplete;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='EMAIL_REG_FORM_SUBMIT']")
    private WebElement createAccount;

    public void clickCreateAccountButton() {
        createAccount.click();
        waitForPageLoadComplete();
        waitForAjaxToComplete();
    }

    public void enterTextToFirstNameField(final String firstNameText) {
        firstName.clear();
        firstName.sendKeys(firstNameText);
    }

    public void enterTextToLastNameField(final String lastNameText) {
        lastName.clear();
        lastName.sendKeys(lastNameText);
    }

    public void enterTextToEmailField(final String emailText) {
        email.clear();
        email.sendKeys(emailText);
    }

    public void enterTextToPasswordField(final String passwordText) {
        password.clear();
        password.sendKeys(passwordText);
    }
}
