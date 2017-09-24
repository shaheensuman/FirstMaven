package com.wholefood.automation.test;

import com.aventstack.extentreports.ExtentReports;
import com.wholefood.automation.framework.Reports.ExtentTestNGITestListener;
import com.wholefood.automation.framework.WholeFoodScriptBase;
import com.wholefood.automation.framework.WholeFoodScriptBaseTwo;
import org.testng.annotations.*;

/**
 * Created by jahangir shaheen on 9/2/2017.
 */

public class ImageFunctionality extends WholeFoodScriptBase {
    @Test
    public void imageTest(){
        wholeFood().homepage().image();
    }
}
