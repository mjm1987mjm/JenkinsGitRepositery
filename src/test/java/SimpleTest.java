import cucumber.api.java.en.Given;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SimpleTest {



    @Test
    public void UserOnLandingPage() throws Throwable {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.testbirds.nl/");

    }

    @Test
    public void Testcase() throws Throwable {
        WebDriver driver = new FirefoxDriver();
        driver.get("https;//www.nu.nl");
    }
}