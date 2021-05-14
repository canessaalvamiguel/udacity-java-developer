package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/animal");

        WebElement inputField1 = driver.findElement(By.id("animalText"));
        inputField1.sendKeys("tiger");

        WebElement inputField2 = driver.findElement(By.id("adjective"));
        inputField2.sendKeys("peleador");

        //List<WebElement> results = driver.findElements(By.className("trainingMessage"));

        for(int i = 0; i < 5; i++) {
            // We are re-assigning the inputField because this element gets removed from the DOM structure after each iteration.
            // Otherwise, you'll get org.openqa.selenium.StaleElementReferenceException at runtime.
            inputField1 = driver.findElement(By.id("adjective"));
            inputField1.submit();

            List<WebElement> results = driver.findElements(By.className("trainingMessage"));
            System.out.println("trainingResults.size() = " + results.size());
        }

        WebElement conclusionResult = driver.findElement(By.className("conclusionMessage"));
        System.out.println("conclusionResult.getText() = " + conclusionResult.getText());

        Thread.sleep(5000);
        driver.quit();
        
    }
}
