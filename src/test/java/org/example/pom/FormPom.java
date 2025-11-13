package org.example.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormPom extends BasicPom {


    @FindBy(xpath = "//*[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//*[@id='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//*[@id='userEmail']")
    WebElement userEmail;

    @FindBy(xpath = "//*[@id='userNumber']")
    WebElement userNumber;

    @FindBy(xpath = "//*[@id='subjectsInput']")
    WebElement subjectsInput;

    @FindBy(xpath = "//*[@id='state']")
    WebElement state;

    @FindBy(xpath = "//*[@id='city']")
    WebElement city;

    @FindBy(xpath = "//*[@id='dateOfBirthInput']")
    WebElement dateOfBirthInput;

    @FindBy(xpath = "//*[@id='submit']")
    WebElement submit;

    public FormPom(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSubmit() {
        submit.click();
    }

    public void setcity(String cityParam) {
        city.click();
        WebElement cityEl = driver.findElement(By.xpath("//*[text()='"+ cityParam +"']"));
        cityEl.click();
    }

    public void setstate(String stateParam) {
        state.click();
        WebElement stateEl = driver.findElement(By.xpath("//*[text()='" + stateParam + "']"));
        stateEl.click();
    }

    public void setHobbies(String hobbyParam) {
        WebElement el = driver.findElement(By.xpath("//*[@id='hobbiesWrapper']//label[text()='"+ hobbyParam + "']/../input"));
        el.sendKeys(" ");
    }

    public void setDateOfBirthInput(String date) throws InterruptedException {
        dateOfBirthInput.click();
        Thread.sleep(1000);
        date = date.replace(",", " ").replaceAll("\\s+", " ").trim();
        Pattern pattern = Pattern.compile("(\\d{1,2})\\s+([A-Za-z]+)\\s*(\\d{4})");
        Matcher matcher = pattern.matcher(date);

        if (!matcher.find()) {
            throw new RuntimeException("Date format invalid: " + date);
        }

        String day = matcher.group(1);
        String month = matcher.group(2);
        String year = matcher.group(3);

        driver.findElement(By.className("react-datepicker__year-select")).sendKeys(year);
        driver.findElement(By.className("react-datepicker__month-select")).sendKeys(month);
        driver.findElement(By.xpath("//div[contains(@class,'day') and text()='" + day + "']")).click();
    }

    public void setSubjectsInput(String subjectsInputParam) {
        subjectsInput.clear();
        subjectsInput.sendKeys(subjectsInputParam);
        subjectsInput.sendKeys(Keys.ENTER);
    }

    public void setUserNumber(String userNumberParam) {
        userNumber.clear();
        userNumber.sendKeys(userNumberParam);
    }

    public void setGender(String genderParam) {
        WebElement el = driver.findElement(By.xpath("//*[@id='genterWrapper']//label[text()='" + genderParam + "']"));
        el.click();
    }

    public void setUserEmail(String userEmailParam) {
        userEmail.clear();
        userEmail.sendKeys(userEmailParam);
    }

    public void setLastName(String lastNameParam) {
        lastName.clear();
        lastName.sendKeys(lastNameParam);
    }

    public void setFirstName(String firstNameParam) {
        firstName.clear();
        firstName.sendKeys(firstNameParam);
    }


    public void scroLlToSubject() {
        scrollToElement(subjectsInput);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
