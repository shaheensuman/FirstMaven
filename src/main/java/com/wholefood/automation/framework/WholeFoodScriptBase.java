package com.wholefood.automation.framework;

import com.wholefood.automation.framework.Reports.ExtentTestNGITestListener;

import com.wholefood.automation.framework.controller.*;
import com.wholefood.automation.framework.utils.WebElementUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by jahangir shaheen on 8/12/2017.
 */
@Listeners({ExtentTestNGITestListener.class})

public class WholeFoodScriptBase {

    public WebDriver driver = null;
    ApplicationController wholeFood = null;

   // @Parameters("browser")

    @BeforeMethod
    public void setUp() {

   //    if (browser.equalsIgnoreCase("chrome")) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();


      /*  } else if (browser.equalsIgnoreCase("firefox")) {
            String DriverPath = System.getProperty("user.dir");
            String FFpath = DriverPath + "\\Drivers\\FF\\32bits\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", FFpath);
            driver = new FirefoxDriver();

      /*  } else if (browser.equalsIgnoreCase("ie")) {
            String DriverPath = System.getProperty("user.dir");
            String FFpath = DriverPath + "\\Drivers\\FF\\32bits\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", FFpath);
            driver = new FirefoxDriver();
        }

            /*    InternetExplorerDriverManager.getInstance().setup();
                  driver=new InternetExplorerDriver();    */


        System.out.println("*************before  test method*************");

         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

         try {
             driver.navigate().to("https://www.wholefoodsmarket.com/");
         }catch (Exception ex){
             ex.printStackTrace();
         }

         driver.manage().window().maximize();


        driver.manage().deleteAllCookies();

    }

    public ApplicationController wholeFood() {
        if (wholeFood == null) {
            wholeFood = new ApplicationController(driver);
        }
        return wholeFood;
    }

    @AfterMethod
    public void tearDown() {

       if (driver != null) {
            driver.close();
           // driver.quit();
            wholeFood=null;
        }

    }
}


