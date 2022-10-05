package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static utils.ScrollingUtils.scrollToElement;
import static utils.WaitingUtils.waitForAjaxToComplete;

public class SearchResultPage extends BasePage {

    private static final String ITEM_IMAGE_XPATH = "//div[@class='s-item__image-section']";
    private static final String ITEM_TITLE_XPATH = "//h3[@class='s-item__title']";

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@id='gh-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[contains(@class,'srp-results')]/li")
    private List<WebElement> searchResultItems;

    @FindBy(xpath = "//div[@class='s-pagination']//button[contains(@class,'fake-menu-button__button') and @aria-expanded='false']")
    private WebElement itemsPerPageSelectBox;

    @FindBy(xpath = "//div[@class='s-pagination']//button[@aria-expanded='true']//parent::span//ul[@class='fake-menu__items']//following-sibling::span/parent::span")
    private List<WebElement> itemsPerPageOptions;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public List<WebElement> getSearchResultItems() {
        waitForAjaxToComplete();
        return searchResultItems;
    }

    public List<WebElement> getProductsImages() {
        return searchResultItems.stream()
                .map(item -> item.findElement(By.xpath(ITEM_IMAGE_XPATH)))
                .collect(Collectors.toList());
    }

    public List<String> getProductsTitles(){
        return searchResultItems.stream()
                .map(item->item.findElement(By.xpath(ITEM_TITLE_XPATH)).getText())
                .collect(Collectors.toList());
    }

    public List<WebElement> getItemsPerPage(){
        scrollToElement(driver, itemsPerPageSelectBox);
        itemsPerPageSelectBox.click();
        return itemsPerPageOptions;
    }

    public void selectItemsPerPageValue(final int itemsPerPageNewValue) {
        List<WebElement> itemsPerPage = getItemsPerPage();
        itemsPerPage.stream()
                .filter(option->option.getText().contains(String.valueOf(itemsPerPageNewValue)))
                .findFirst().get()
                .click();
    }
}
