package com.wholefood.automation.framework;

import com.wholefood.automation.framework.controller.ApplicationController;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jahangir shaheen on 9/25/2017.
 */
public class WholeFoodsRemoteExecution {
    public WebDriver driver=null;
    public  ApplicationController wholeFood=null;
    public static final String USERNAME = "jahangirshaheen1";
    public static final String AUTOMATE_KEY = "Fa4hfLwzmSwVG9L4h2Qp";
    public static final String REMOTE_HUB = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("ff-cloud")){
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "Firefox");
            caps.setCapability("browser_version", "56.0 beta");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("resolution", "1280x1024");
             driver = new RemoteWebDriver(new URL(REMOTE_HUB), caps);
        }else if(browser.equalsIgnoreCase("ch-cloud")){
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "61.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("resolution", "1280x1024");
            driver= new RemoteWebDriver(new URL(REMOTE_HUB), caps);
        }else if (browser.equalsIgnoreCase("ie-cloud")){
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "IE");
            caps.setCapability("browser_version", "11.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("resolution", "1280x1024");
            driver= new RemoteWebDriver(new URL(REMOTE_HUB), caps);
        }
        if (browser.equalsIgnoreCase("chrome")){
            ChromeDriverManager.getInstance().setup();
            driver=new ChromeDriver();
        }else if(browser.equalsIgnoreCase("FireFox")){
            FirefoxDriverManager.getInstance().setup();
            driver=new FirefoxDriver();
        }

    }
    public ApplicationController wholeFood(){
        if (wholeFood==null){
            wholeFood=new ApplicationController(driver);

        }return wholeFood;
    }


    @AfterMethod
    public void tearDown(){
        if ((driver!=null)){
            driver.close();;
        }
        try {
            driver.quit();
        }catch (Exception ex){
        }
        wholeFood=null;
    }
}
