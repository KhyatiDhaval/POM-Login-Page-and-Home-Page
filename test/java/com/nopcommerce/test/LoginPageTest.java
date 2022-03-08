package com.nopcommerce.test;

import base.BasePage;
import com.nopcommerce.demo.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.Constants;

import java.io.IOException;
import java.util.Properties;

public class LoginPageTest {
    BasePage basePage;
    Properties prop;
    LoginPage loginPage;
    WebDriver driver;

    @BeforeTest
    public void launchBrowser() throws IOException {
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String browser = prop.getProperty("browser");
        driver = basePage.initialiseDriver(browser);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);

    }
//    @Test(priority = 1)
//    public void verifyLoginPageTitleTest(){
//        Assert.assertEquals(loginPage.getPageTitle(), Constants.LOGIN_PAGE_TITLE , "Login page title not correct");
//    }
//    @Test(priority = 2)
//    public void verifyRegisterButtonTest(){
//        Assert.assertTrue(loginPage.verifyRegisterButton(),"Register link is not displayed");
//    }
  @Test(priority = 1)
 public void click(){
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
  }

  @AfterTest
  public void tearDown(){
        driver.quit();
  }
  }


