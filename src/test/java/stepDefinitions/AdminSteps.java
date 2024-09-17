/*package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdminPage;
import utils.Hooks;
import static org.junit.Assert.assertEquals;

public class AdminSteps {

    private WebDriver driver;
    private AdminPage adminPage;
    private int initialRecordCount;
    public AdminSteps() {
        // Initialize AdminPage using the Hooks class or directly with WebDriver if applicable
        adminPage = new AdminPage(Hooks.getDriver()); // Assuming Hooks provides WebDriver instance
    }
  /*  public AdminSteps(AdminPage adminPage) {
        //this.driver = hooks.getDriver();
        this.adminPage = new AdminPage(driver);
    }

    @When("I am on the Admin page")
    public void i_am_on_the_admin_page() {
        adminPage.navigateToAdminPage();
    }

    @Then("I capture the current number of records")
    public void i_capture_the_current_number_of_records() {
        initialRecordCount = adminPage.getNumberOfRecords();
    }

    @When("I click on the Add button and create a new user with username {string}")
    public void i_click_on_the_add_button_and_create_a_new_user_with_username(String username) {
        adminPage.clickAddButton();
        adminPage.createUser(username, "password123"); // Assume default password for simplicity
    }

    @Then("the number of records should increase by {int}")
    public void the_number_of_records_should_increase_by(int expectedIncrease) {
        int currentRecordCount = adminPage.getNumberOfRecords();
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
        int currentRecordCount = adminPage.getNumberOfRecords();
        assertEquals(initialRecordCount - expectedDecrease, currentRecordCount);
    }
}
*/