package com.nopcommerce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utils;

public class LoginPage {

    WebDriver driver;
    Utils utils;
    //1. create your page objects or object repository in the form os by locators.

    By emailId = By.id("Email");
    By password = By.id("Password");
    By loginButton = By.className("login-button");
//    By regButton = By.className("register-button");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        utils = new Utils(driver);

    }

//        public String getPageTitle() {
//            String title = driver.getTitle();
//            utils.waitForTitlePresent(title, 10);
//            System.out.println("Login page title is:" + title);
//            return title;
//        }
//        public boolean verifyRegisterButton(){
//        return driver.findElement(regButton).isDisplayed();
//        }


        public HomePage doLogin (String username, String pwd){
//            utils.waitForElementToBeVisible(emailId,10);
            utils.doSendKeys(emailId, username);
            utils.doSendKeys(password, pwd);
            utils.getElement(loginButton).click();

            return (HomePage) driver;
        }
    }


