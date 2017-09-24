package com.wholefood.automation.framework.Model;

import com.wholefood.automation.framework.WholeFoodScriptBase;
import com.wholefood.automation.framework.controller.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jahangir shaheen on 8/17/2017.
 */
public class ShopOnlinePageModel extends PageBase {

    public ShopOnlinePageModel(WebDriver driver) {
        super(driver);

    }

   public WebElement shopNowButton=driver.findElement(By.xpath(".//a[@class='orange-button-cta'][text()='Shop Now']"));

}
