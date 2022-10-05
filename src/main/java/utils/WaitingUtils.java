package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static manager.DriverManager.getDriver;

public class WaitingUtils {

    private static final long DEFAULT_TIMEOUT = 60;

    public static void waitForPageLoadComplete() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static void waitForAjaxToComplete() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active == 0;"));
    }
//
//    public static void waitForAjaxToCompletePdp() {
//        new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT)).until(
//                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active <=2;"));
//    }

    public static void waitVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
