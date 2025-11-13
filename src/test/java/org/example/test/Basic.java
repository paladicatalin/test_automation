package org.example.test;
import org.example.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Basic {
    public WebDriver driver;

    @BeforeClass
    public void beferoTest() {
        //driver = Driver.getAutoLocalDriver();
        driver = Driver.getRemoteDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}

