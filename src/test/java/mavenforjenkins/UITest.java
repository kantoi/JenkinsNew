package mavenforjenkins;

import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class UITest {
    ExtentTest test;
    @Test(enabled = false)
    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver", "/Users/kentvanlim/NetBeansProjects/compass/driver/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(true);
        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://www.google.co.in");
    }
	@Parameters("Browser")

    @Test(enabled = true)
    public void startBrowser(String browserName) {
        System.out.println("Parameter value is " + browserName);
        WebDriver driver = null;

        if (browserName.contains("Firefox")) {
//            FirefoxBinary firefoxBinary = new FirefoxBinary();
//            firefoxBinary.addCommandLineOptions("--headless");
//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            firefoxOptions.setBinary(firefoxBinary);
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(true);
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        }

        driver.manage().window().maximize();
        driver.get("https://frontelease-colemanite-co31.antikode.dev/announcement/");
        Assert.assertTrue(driver.getTitle().contains("Compass"), "Title Match");
        driver.quit();
       
    }
    @Test(enabled=true)
    

   @Test(enabled=false)
    public void startBrowser2(String browserName) {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver driver = new FirefoxDriver();
        new FirefoxDriver(firefoxOptions);

        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
}
