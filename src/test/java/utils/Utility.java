package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility {
     WebDriver driver;
    private WebDriverWait wait;

    /*public Utility(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // 10 seconds wait
    }*/

    public static void clickElement(WebElement element    ) {
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        //wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void enterText(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


   /* public int getElementCount(By locator) {
        return driver.findElements(locator).size();
    }*/
}
