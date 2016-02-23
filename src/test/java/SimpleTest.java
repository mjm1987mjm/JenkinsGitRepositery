import cucumber.api.java.en.Given;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by m.moorman on 23-2-2016.
 */
public class SimpleTest {



 @Test
    public void UserOnLandingPage() throws Throwable {
     WebDriver driver = new FirefoxDriver();
        driver.get("https://www.testbirds.nl/");

    }
}