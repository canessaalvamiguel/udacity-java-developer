package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "button_logout")
    WebElement button_logout;

    public HomePage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    void performLogout(){
        button_logout.click();
    }
}
