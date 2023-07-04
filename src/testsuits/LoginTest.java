package testsuits;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    //User should able to login successfully after entering the valid credentials
    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //Verify the text “PRODUCTS”
        String actualProductText = gettextFromElement(By.xpath("//span[text()='Products']"));
        String expectedProductText = "Products";
        Assert.assertEquals("Heading is not matching",actualProductText,expectedProductText);
    }
    //Checking six products have been displayed after login
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage()
    {
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //Verify six products are displayed on page
        List<WebElement> product=driver.findElements(By.cssSelector("div[class='inventory_item_name']"));
        int totalNumberOfProduct=product.size();
        int expectedNumberOfProduct=6;
        Assert.assertEquals("Page not have 6 products on display",totalNumberOfProduct,expectedNumberOfProduct);

    }

    @After
    public void tearDown() {
        //closeBrowser();
    }

}
