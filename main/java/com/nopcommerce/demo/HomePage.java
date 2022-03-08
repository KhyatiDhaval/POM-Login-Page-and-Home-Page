package com.nopcommerce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utils;

public class HomePage {
  WebDriver driver;
  Utils utils;

  By logout = By.className("ico-logout");
  By myAccount = By.className("ico-account");

  public HomePage(WebDriver driver) {
      this.driver = driver;
    utils = new Utils(driver);
  }
  public boolean isLogOutPresent(){
       return utils.isElementDisplayed(logout);
    }
   public String getLogOutText(){
       return utils.doGetText(logout);
   }
  public boolean isMyAccountPresent(){
       return utils.isElementDisplayed(myAccount);

   }
}

