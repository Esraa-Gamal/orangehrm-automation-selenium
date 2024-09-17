package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.AdminPage;
import utils.Hooks;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class LoginSteps
{

     AdminPage adminPage;
      WebDriver driver;
     LoginPage loginPage;//=new LoginPage(driver) ;
    private String initialRecordCount;

    public LoginSteps() {
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(driver);
        this.adminPage = new AdminPage(driver);
    }

   @Given("I am on the OrangeHRM login page")
    public void user_is_on_the_login_page() {
      // loginPage = new LoginPage();
       loginPage.navigateToLoginPage();

    }


    @When("I enter username {string} and password {string}")
    public void user_logs_in_with_dynamic_credentials(String username, String password) throws IOException {
        loginPage.enterUsername("Admin");
       loginPage.enterPassword("admin123");


    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() throws InterruptedException {
        loginPage.clickLogin();
        Thread.sleep(6000);
       // ChromeOptions options = new ChromeOptions();
       // options.addArguments("--disable-notifications");
// Handle HTTP auth via Chrome DevTools Protocol
// This is often more complex and might require additional setup

        //WebDriver driver = new ChromeDriver(options);
    }
    @Then("I should be on the dashboard page")
    public void login_should_be_successful() {
        boolean isSuccessful = loginPage.isLoginSuccessful();

    }

    @When("I am on the Admin page")
    public void i_am_on_the_admin_page() {
        adminPage.navigateToAdminPage();
    }

    @Then("I capture the current number of records")
    public void i_capture_the_current_number_of_records() {
        initialRecordCount = adminPage.getNumberOfRecords();
    }


    @When("I click on the {string} button and create a new user with username {string}")
    public void i_click_on_the_button_and_create_a_new_user_with_username(String username, String password) {
        adminPage.clickAddButton();
       // adminPage.createUser(username, password);
    }
        @Then("the number of records should increase by {int}")
    public void the_number_of_records_should_increase_by(int expectedIncrease) {
        String currentRecordCount = adminPage.getNumberOfRecords();
        assertEquals(initialRecordCount + expectedIncrease, currentRecordCount);
    }

    @When("I search for the user {string}")
    public void i_search_for_the_user(String username) {
        adminPage.searchUser(username);
    }

    @And("I delete the user")
    public void i_delete_the_user() {
        adminPage.deleteUser();
    }

    @Then("the number of records should decrease by {int}")
    public void the_number_of_records_should_decrease_by(int expectedDecrease) {
        String currentRecordCount = adminPage.getNumberOfRecords();
        assertEquals(initialRecordCount , currentRecordCount);
    }
}
///- expectedDecrease