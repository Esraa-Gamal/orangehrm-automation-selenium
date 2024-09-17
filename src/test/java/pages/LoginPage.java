package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;
import utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class LoginPage extends Hooks

{
    WebDriver driver;
    //private Utility utility;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // 10 seconds wait
        PageFactory.initElements(driver, this);
    }
    //@FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
    // @FindBy(how = How.NAME, using = "username")
    @FindBy(how = How.CSS, using = "input[placeholder='Username']")  // Using compound class names
     public WebElement txtUsername;

    @FindBy(how = How.NAME, using = "password")
    public WebElement passwordField;

    @FindBy(how = How.XPATH , using = "//button[contains(.,'Login')]")
    public WebElement loginBtn;

    public void navigateToLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }


    public void enterUsername(String username) {
       // Utility.enterText(txtUsername, username);
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]")));
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        Utility.enterText(passwordField, password);
    }

    public void clickLogin() {
        Utility.clickElement(loginBtn);

    }

    public boolean isLoginSuccessful()
    {
        try {
            // If the adminTab element is found and visible, return true
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']")));
            return true;
        } catch (Exception e) {
            // If the element is not found or not visible, return false
            return false;
        }    }
}
