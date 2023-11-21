package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.name("username")).sendKeys("tomsmith"); //Entering the username
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!"); //Entering password
        driver.findElement(By.xpath("//i")).click();  //finds the computer button and clicks
        String expectedText = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2"));  //finds the element and verify if actual and expected match
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text Error", expectedText, actualText); //compares if expected and actual is equal
    }
    @Test
    public void verifyTheUsernameErrorMessage() {
        driver.findElement(By.name("username")).sendKeys("tomsmith1"); //Entering the username
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!"); //Entering password
        driver.findElement(By.xpath("//i")).click();  //finds the computer button and clicks
        String expectedText = " Your username is invalid!\nx";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(text(), 'Your username is invalid!')]"));  //finds the element and verify if actual and expected match
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text Error", expectedText, actualText); //compares if expected and actual is equal
    }
    @Test
    public void verifyThePasswordErrorMessage() {
        driver.findElement(By.name("username")).sendKeys("tomsmith"); //Entering the username
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword"); //Entering password
        driver.findElement(By.id("login")).click();  //finds the computer button and clicks
        driver.findElement(By.xpath("//i")).click();  //finds the computer button and clicks
        String expectedText = "Your password is invalid!\nx";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(text(), 'Your password is invalid!')]"));  //finds the element and verify if actual and expected match
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text Error", expectedText, actualText); //compares if expected and actual is equal
    }
    @After
    public void tearDown() {
        closeBrowser();
    }


}
