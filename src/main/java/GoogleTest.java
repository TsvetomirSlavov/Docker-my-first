import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by cccce on 02/16/2017.
 */
public class GoogleTest {

    static WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("version", "");
        capabilities.setCapability("platform", "LINUX");
        driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), capabilities);
    }

    @Test
    public void chromeGoogleTest(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("btnG")).click();
        Assert.assertTrue(driver.getPageSource().contains("Selenium"));

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }






}
