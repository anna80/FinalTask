package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignInPage;

public class RegistrationAndSignInDefinitionSteps {

    private final RegistrationPage registrationPage = new PageFactoryManager().getRegistrationPage();
    private final HomePage homePage = new PageFactoryManager().getHomePage();
    private final SignInPage signInPage = new PageFactoryManager().getSignInPage();


    @When("User clicks by link 'Register'")
    public void clicksByLinkRegister() {
        homePage.clickRegisterButton();
    }

    @When("User clicks by link 'Sign in'")
    public void clicksByLinSignIn() {
        homePage.clickSignInButton();
    }

    @And("User clicks 'Create account' button")
    public void clicksCreateAccountButton() {
        registrationPage.clickCreateAccountButton();
    }

    @And("User enters {string} email/password")
    public void enterDataToUseridField(final String data) {
        signInPage.enterDataToUseridField(data);
    }

    @And("User clicks 'Continue' button")
    public void clickContinueButton() {
        signInPage.clickContinueButton();
    }

    @And("User clicks 'Sign in' button")
    public void clickSignInButton() {
        signInPage.clickSignInButton();
    }

    @And("User enters {string} first name")
    public void enterFirstName(final String firstName) {
        registrationPage.enterTextToFirstNameField(firstName);
    }

    @And("User enters {string} last name")
    public void enterLastName(final String lastName) {
        registrationPage.enterTextToLastNameField(lastName);
    }

    @And("User enters {string} email on Registration page")
    public void enterEmailOnRegistrationPage(final String email) {
        registrationPage.enterTextToEmailField(email);
    }

    @And("User enters {string} password on Registration page")
    public void enterPasswordOnRegistrationPage(final String password) {
        registrationPage.enterTextToPasswordField(password);
    }
}
