package org.example.test;

import org.example.pom.LoginPom;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends Basic {

    public static String URL = "https://demoqa.com/login";
    public static String FIRST_NAME = "Catalin";
    public static String PASSW = "Catalin2006!";

    @Test
    public void formTest() throws InterruptedException {
        driver.get(URL);

        LoginPom form = new LoginPom(driver);
        form.closeAdvert();
        form.setUserName(FIRST_NAME);
        form.setPassword(PASSW);
        Thread.sleep(5000);
        System.out.println();
    }

}
