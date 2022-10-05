package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.WaitingUtils.waitVisibilityOfElement;

public class ProductPage extends BasePage {

    private static String OPTION_XPATH = "./option";

    @FindBy(xpath = "//select[@id='msku-sel-1']")
    private WebElement manufacturerColourSelectBox;

    @FindBy(xpath = "//select[@id='msku-sel-2']")
    private WebElement storageSelectBox;

    @FindBy(xpath = "//a[@id='isCartBtn_btn']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='watchWrapperId']")
    private WebElement addToWatchList;

    @FindBy(xpath = "//a[@title='Watchlist']")
    private WebElement watchListLink;

    @FindBy(xpath = "//div[@class='gh-item__card']")
    private List<WebElement> watchListProducts;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectManufacturerColour(final String colour) {
        manufacturerColourSelectBox.click();
        manufacturerColourSelectBox.findElements(By.xpath(OPTION_XPATH)).stream()
                .filter(option -> option.getText().equals(colour)).findFirst().get().click();
    }

    public void selectStorage(final String storage) {
        storageSelectBox.click();
        storageSelectBox.findElements(By.xpath(OPTION_XPATH)).stream()
                .filter(option -> option.getText().equals(storage)).findFirst().get().click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getAddToWatchListButtonText() {
        return addToWatchList.getText();
    }

    public void clickAddToWatchListButton() {
        addToWatchList.click();
    }

    public void clickWatchListLink() {
        watchListLink.click();
    }

    public List<WebElement> getWatchListProducts() {
        return watchListProducts;
    }

}
