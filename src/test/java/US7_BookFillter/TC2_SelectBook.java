package US7_BookFillter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class TC2_SelectBook {


        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            ArrayList<String> Users = new ArrayList<>();
            Users.add("librarian47@library");
            Users.add("librarian17@library");
            Users.add("student94@library");
            Users.add("student95@library");
            Users.add("student96@library");


            //Given librarian is on the loginPage
            driver.get("http://library2.cybertekschool.com/login.html");

            for (String eachUser : Users) {

                //When librarian enters valid email address and password
                Thread.sleep(1000);
                WebElement userNameBox = driver.findElement(By.id("inputEmail"));
                userNameBox.sendKeys(eachUser);
                WebElement passwordBox = driver.findElement(By.id("inputPassword"));
                passwordBox.sendKeys("Sdet2022*");

                //And librarian click sign in button

                Thread.sleep(1000);
                WebElement singInButton = driver.findElement(By.xpath("//button[@class=\"btn btn-lg btn-primary btn-block\"]"));
                singInButton.click();
                Thread.sleep(1000);
                //verify land to homepage
                String expectedResult = "Library";
                String actualResult = (driver.getTitle());

                if (actualResult.equalsIgnoreCase(expectedResult)) {
                    System.out.println(eachUser + ":PASSED-Browser landing homepage successfully");
                } else {
                    System.out.println(eachUser + ":FAILED-Browser not on the homepage");
                }
                Thread.sleep(1000);

                //   click book module

                if (eachUser.equalsIgnoreCase("librarian54") || eachUser.equalsIgnoreCase("librarian15")) {
                    driver.findElement(By.cssSelector("#menu_item > li:nth-child(3) > a > span.title")).click();
                } else {
                    driver.findElement(By.xpath("//ul[@id='menu_item']//a[@href='#books']/span[@class='title']")).click();
                }
                Thread.sleep(1000);

                //click book category dropdown

                WebElement bookCategoriesDrop=driver.findElement(By.xpath("//select[@id='book_categories']"));
                Thread.sleep(1000);

                //choose drama

                Select select = new Select(bookCategoriesDrop);
                select.selectByValue("6");
                Thread.sleep(1000);

                //verify chosen drama

                WebElement categoryCol = driver.findElement(By.xpath("//*[@id=\"tbl_books\"]/tbody/tr[3]/td[5]"));

                for (int i = 1; i <5 ; i++) {
                    if(driver.findElement(By.xpath("//*[@id=\"tbl_books\"]/tbody/tr["+i+"]/td[5]")).getText().equals("Drama")) {
                        System.out.println(eachUser+ ":PASSED for "+ i+".column");
                    }
                    else {
                        System.out.println(eachUser+"FAILED--Not chosen drama");
                    }
                }
                Thread.sleep(1000);
                //click user name on the right corner and log out

                driver.findElement(By.id("navbarDropdown")).click();
                Thread.sleep(1000);

                driver.findElement(By.linkText("Log Out")).click();

                Thread.sleep(1000);



            }
            //close browser
            driver.quit();
        }

}
