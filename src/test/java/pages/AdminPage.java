package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;
import utils.Utility;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AdminPage extends Hooks {


  //  private WebDriver driver;
    private WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(how = How.XPATH, using = "//ul[@class='oxd-main-menu']/li[1]")
    private WebElement adminTab;

    @FindBy(how = How.XPATH, using = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addButton;

       // driver.findElement(By.xpath("//span[text()='Admin']")).click();

    @FindBy(how = How.XPATH, using = "//input[@id='systemUser_userName']")
    private WebElement usernameField;

    @FindBy(how = How.XPATH, using = "//input[@id='systemUser_password']")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//input[@id='systemUser_confirmPassword']")
    private WebElement confirmPasswordField;

    @FindBy(how = How.XPATH, using = "//input[@id='btnSave']")
    private WebElement saveButton;

    @FindBy(how = How.XPATH, using = "//table[@id='resultTable']//tbody/tr")
    private WebElement userRecords;

    @FindBy(how = How.XPATH, using = "//input[@id='searchSystemUser_userName']")
    private WebElement searchUserField;

    @FindBy(how = How.XPATH, using = "//button[@id='searchBtn']")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//input[@id='btnDelete']")
    private WebElement deleteButton;


    public AdminPage(WebDriver driver) {
        /*this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));*/
        PageFactory.initElements(driver, this);
    }


    public void navigateToAdminPage() {
        //this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        adminTab.click();
    }

    public String getNumberOfRecords() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Use 'visibilityOfElementLocated' with a By locator, not WebElement
        WebElement userRecords = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span']")));

        // Get the text from the element
        String recordNumber = userRecords.getText();

        // Use regex to extract the digits
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(recordNumber);

        if (matcher.find()) {
            // Extract the number and return it as a string
            String number = matcher.group();
            System.out.println("Number of records found: " + number);
            return number;
        }

        // Handle case if no match is found
        return "0";
    }

    public void clickAddButton() {
        addButton.click();
    }


    // Method to select from "User Role" dropdown (custom dropdown)
    public void selectUserRole(String role) {
        WebElement roleDropdown = driver.findElement(By.xpath("//label[text()='User Role']/following::div[1]"));
        Utility.clickElement(roleDropdown);

        WebElement roleOption = driver.findElement(By.xpath("//span[text()='" + role + "']"));
        Utility.clickElement(roleOption);
    }

    // Method to select from "Status" dropdown (custom dropdown)
    public void selectUserStatus(String status) {
        WebElement statusDropdown = driver.findElement(By.xpath("//label[text()='Status']/following::div[1]"));
        Utility.clickElement(statusDropdown);
        WebElement statusOption = driver.findElement(By.xpath("//span[text()='" + status + "']"));
        Utility.clickElement(statusOption);
    }
   /* public void createUser(String username, String password,) {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='systemUser_userName']")));
       /* usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
       saveButton.click();
        Utility.enterText(usernameField, username);
        Utility.enterText(passwordField, password);
        Utility.enterText(confirmPasswordField, password);

        selectUserRole(role);
        selectUserStatus(status);
        Utility.clickElement(saveButton);

    }*/

    public void searchUser(String username) {
           /*  searchUserField.sendKeys(username);
        searchButton.click();*/
        Utility.enterText(searchUserField, username);
        Utility.clickElement(searchButton);
    }

    public void deleteUser() {
        WebElement deleteCheckbox = driver.findElement(By.xpath("//input[@name='chkSelectRow[]']"));
        if (deleteCheckbox.isDisplayed()) {
            deleteCheckbox.click();
            Utility.clickElement(deleteButton);
        }
    }
}
