package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    WebDriver driver;
    Properties prop;

    public WebDriver initialiseDriver(String browserName){

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/Khyati/IdeaProjects/LoginPagePOM/src/test/resources/BrowserDriver/chromedriver" );
            driver = new ChromeDriver();
        } else if (browserName.equals("edge")){
            System.setProperty("webdriver.edge.driver" , "/Users/Khyati/IdeaProjects/ProjectObjectModelFramework/src/test/resources/BrowesrDriver/msedgedriver");
            driver = new EdgeDriver();

        }else
            System.out.println(browserName + "Please enter correct browser name");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        return driver;

    }
    public Properties initialiseProperties() throws IOException {

        prop = new Properties();
        FileInputStream ip = new FileInputStream("/Users/Khyati/IdeaProjects/LoginPagePOM/src/test/resources/TestData/config..properties");
        prop.load(ip);
        return prop;
    }


}
