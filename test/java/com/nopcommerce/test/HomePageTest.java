package com.nopcommerce.test;

import base.BasePage;
import com.nopcommerce.demo.HomePage;
import com.nopcommerce.demo.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Constants;

import java.io.IOException;
import java.util.Properties;

public class HomePageTest {

    BasePage basePage;
    Properties prop;
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    @BeforeTest
    public void openBrowser() throws IOException {
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String browser = prop.getProperty("browser");
        driver = basePage.initialiseDriver(browser);
        driver.get(prop.getProperty("url"));

        loginPage = new LoginPage(driver);
        homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password") );
    }
    @Test(priority = 1)
    public void verifyLogoutLink(){
        Assert.assertTrue(homePage.isLogOutPresent(),"Log out link not present");
        String logoutLink = homePage.getLogOutText();
        System.out.println("log out link is :"+logoutLink);
        Assert.assertEquals(logoutLink, Constants.HOME_PAGE_LOGOUT);
    }
    @Test
    public void verifyMyAccountLink(){
        Assert.assertTrue(homePage.isMyAccountPresent(),"My account link is not present");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

