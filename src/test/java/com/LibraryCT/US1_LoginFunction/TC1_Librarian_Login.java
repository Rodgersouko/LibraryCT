package com.LibraryCT.US1_LoginFunction;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TC1_Librarian_Login {

        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            ArrayList<String> librarianUsers=new ArrayList<>();
            librarianUsers.add("librarian47@library");
            librarianUsers.add("librarian17@library");
            // System.out.println(librarianUsers);

            //Given librarian is on the loginPage
            driver.get("http://library2.cybertekschool.com/login.html");

            for (String eachLibrarianUser : librarianUsers) {
                //Then verify that the title is “Login - Library”
                Thread.sleep(1000);
                if (driver.getTitle().equalsIgnoreCase("Login - Library")) {
                    System.out.println(eachLibrarianUser+" Page title is verify(Login - Library)");
                } else {
                    System.out.println(eachLibrarianUser+" Page title is not verify");
                }
                //When librarian enters valid email address and password
                Thread.sleep(1000);
                WebElement userNameBox = driver.findElement(By.id("inputEmail"));
                userNameBox.sendKeys(eachLibrarianUser);
                WebElement passwordBox = driver.findElement(By.id("inputPassword"));
                passwordBox.sendKeys("Sdet2022*");

                //And librarian click sign in button

                Thread.sleep(1000);
                WebElement singInButton = driver.findElement(By.xpath("//button[@class=\"btn btn-lg btn-primary btn-block\"]"));
                singInButton.click();

                Thread.sleep(2000);
                //Then verify that there are 3 modules the page

                List<WebElement> allModules = driver.findElements(By.xpath("/html/body/header/nav/div/ul[1]/li" +
                        ""));
                //System.out.println("allModules.size() = " + allModules.size());

                if (allModules.size() == 3) {
                    System.out.println(eachLibrarianUser+" Test Pass: 3 modules are appeared on the page");
                } else {
                    System.out.println(eachLibrarianUser+" Test fail: 3 modules didn't appear on the page");
                }

                driver.findElement(By.id("navbarDropdown")).click();
                Thread.sleep(1000);

                driver.findElement(By.linkText("Log Out")).click();

            }

            //close browser
            driver.quit();


        }
}

