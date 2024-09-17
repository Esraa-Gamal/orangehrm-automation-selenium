package utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    public static WebDriver driver;
    @Before
    public void setUp() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/egamal/IdeaProjects/chromedriver-win64/chromedriver.exe");  // Update path as needed
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }
    /*
    @Before
    public void setUp() {
        // Set up the WebDriver (e.g., ChromeDriver, geckodriver, etc.)
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }*/

   /* public static WebDriver getDriver() {
        return driver;
    }*/


    public static WebDriver getDriver() {
        return driver;
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
