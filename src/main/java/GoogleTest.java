import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by cccce on 02/16/2017.
 */
public class GoogleTest {

    //static WebDriver driver;
    static WebDriver driverFirefox;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //capabilities.setCapability("version", "");
        //capabilities.setCapability("platform", "LINUX");
        //driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), capabilities);

        DesiredCapabilities capabilitiesFirefox = DesiredCapabilities.firefox();
        capabilitiesFirefox.setCapability("version", "");
        capabilitiesFirefox.setCapability("platform", "LINUX");
        driverFirefox = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilitiesFirefox);
    }

    @Test
    public void chromeGoogleTest() throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driverFirefox.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //driver.manage().window().maximize();
        driverFirefox.manage().window().maximize();

        //driver.navigate().to("http://www.google.com");
        driverFirefox.navigate().to("http://www.google.com");

        //driver.findElement(By.name("q")).sendKeys("Selenium");
        driverFirefox.findElement(By.name("q")).sendKeys("Selenium");

        //WebElement searchButton = driver.findElement(By.name("btnG"));
        WebElement searchButtonFirefox = driverFirefox.findElement(By.name("btnG"));

        //explicitWaitByWebElement(driver, searchButton);
        //searchButton.click();
        searchButtonFirefox.click();

        //System.out.println(driver.getTitle());
        System.out.println(driverFirefox.getTitle());

        //Assert.assertTrue(driver.getPageSource().contains("Selenium"));
        Assert.assertTrue(driverFirefox.getPageSource().contains("Selenium"));

        Thread.sleep(2000);
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
        driverFirefox.quit();
    }

    //explicitWaitByElement
    public static void explicitWaitByWebElement(WebDriver driver, WebElement element){
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(element));
    }




}
