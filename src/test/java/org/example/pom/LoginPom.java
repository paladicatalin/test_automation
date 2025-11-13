package org.example.pom;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom extends BasicPom {

    @FindBy(xpath = "//*[@id='userName']")
    WebElement userName;

    @FindBy(xpath = "//*[@id='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id='login']")
    WebElement login;


    public LoginPom(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String userNameParam) {
       userName.clear();
       userName.sendKeys(userNameParam);
    }

    public void setPassword(String setPasswordParam) {
        password.clear();
        password.sendKeys(setPasswordParam);
    }

    public void clickLogin() {
        login.click();
    }


}
