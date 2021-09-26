package com.LibraryCT.US1_LoginFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_Librarian_Login_Negative {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //Given librarian is on the loginPage
        Thread.sleep(1000);
        driver.get("http://library2.cybertekschool.com/login.html");

        //When librarian enters invalid email address and password
        Thread.sleep(500);
        WebElement userNameBox = driver.findElement(By.id("inputEmail"));
        userNameBox.sendKeys("test47@library");
        WebElement passwordBox = driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("12345");

        //And librarian click sign in button

        Thread.sleep(500);
        WebElement singInButton = driver.findElement(By.xpath("//button[@class=\"btn btn-lg btn-primary btn-block\"]"));
        singInButton.click();

        Thread.sleep(1000);
        //verify error message

        WebElement errorMessage=driver.findElement(By.xpath("//div[@class=\"alert alert-danger\"]"));
        String expectedResult="Sorry, Wrong Email or Password";
        if(errorMessage.getText().equalsIgnoreCase(expectedResult)){
            System.out.println("Error message is verify");
        }else{
            System.out.println("Error message is not verify");
        }
        driver.quit();

    }
}
