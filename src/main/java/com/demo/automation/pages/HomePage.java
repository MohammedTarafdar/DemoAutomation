package com.demo.automation.pages;

import com.demo.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    WebDriver driver;

    //1. Page class constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    //2. Page Object with By Locator
    By homePageLogo = By.className("logo");
    By loginLink = By.id("btnOpen2");
    By popUpElement = By.xpath("//*[text()=\"No Thanks\"]");
    By login_link = By.xpath("(//a[text()=\"Log In\"])[1]");
    By user_name = By.id("ravalidation-2-form.userName]");
    By pass_word = By.id("ravalidation-2-form.password");
    By log_in = By.xpath("//button[text()=\"Log In\"]");



    //3. Page methods

    public String getHomePageTitle(){
        return driver.getTitle();
    }


    public boolean isLoginLinkExists(){
        return driver.findElement(loginLink).isDisplayed();
    }

    public void popUpHandle(){
        try { Thread.sleep(5000);
        } catch (InterruptedException e) { }

        driver.findElement(popUpElement).click();
    }



    public void doLogin(String userName, String passWord) {

        try { Thread.sleep(5000);
        } catch (InterruptedException e) { }


        //driver.findElement(login_link).click();
        driver.findElement(By.xpath("//a[@id=\"btnOpen2\"]")).click();

        driver.findElement(user_name).sendKeys(userName);
        driver.findElement(pass_word).sendKeys(passWord);

        try { Thread.sleep(2000);
        } catch (InterruptedException e) { }

        driver.findElement(log_in).submit();

    }






}
