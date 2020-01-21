package com.demo.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    WebDriver driver;
    Properties prop;

    // This method will use to initialize the driver on the basis of browser name.

    public WebDriver initDriver(Properties prop){
        String browser = prop.getProperty("browser");

        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.equals("safari")){
            WebDriverManager.getInstance(SafariDriver.class).setup();
            driver = new SafariDriver();
        }
        else {
            System.out.println("This "+browser+" is not configured");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get(prop.getProperty("url"));

        return driver;

    }


    // This method will use to read properties from properties file.

    public Properties initProperties(){

        prop = new Properties();
        String propLocation ="/MyDevelopment/DemoAutomation/src/main/java/com/demo/automation/config/config.properties";
        try {
            FileInputStream fileInput = new FileInputStream(propLocation);
            prop.load(fileInput);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return prop;

    }



}
