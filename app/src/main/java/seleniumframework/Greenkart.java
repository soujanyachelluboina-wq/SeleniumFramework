package seleniumframework;

import java.time.Duration;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Greenkart {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // xpathPractice(driver);
        // fromForm(driver);
        // fromPassword(driver);
        // CSSBasicAtributr(driver);
        // CSSBasicAtributr2(driver); 
        CSSBasicAtributr3(driver);
         
        
    }
    public static void xpathPractice(WebDriver driver) {
       driver.get("https://rahulshettyacademy.com/locatorspractice/");
       // Part A - Locate Username textbox using
       WebElement username= driver.findElement(By.xpath("//h1/following-sibling::input[@type='text']"));
         username.sendKeys("Rahul");
         // Part B - Locate Password textbox using  
         WebElement password = driver.findElement(By.xpath("//h1/following-sibling::input[@type='password']"));
            password.sendKeys("Rahulshettyacademy");
         WebElement signin = driver.findElement(By.xpath("//input[@type='text']/preceding-sibling::h1"));
          System.out.println(signin.getText());

    }
public static void fromForm(WebDriver driver) {
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    // form to sign in 
    WebElement signin= driver.findElement(By.xpath("//form/descendant::h1"));
    System.out.println("The text we got using locator is : "+signin.getText());
    //
    WebElement password = driver.findElement(By.xpath("//form/descendant::input[@type='password']"));
    password.sendKeys("Rahulshettyacademy");
}

public static void fromPassword(WebDriver driver) {
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    // password to user name
    WebElement username = driver.findElement(By.xpath("//input[@type='password']/preceding-sibling::input"));
    username.sendKeys("Rahul");
    // password to sign in
    WebElement signin = driver.findElement(By.xpath("//input[@type='password']/preceding-sibling::h1"));
    System.out.println("The text we got using locator is : "+signin.getText());
    // password to sign in button
    WebElement signinButton = driver.findElement(By.xpath("//input[@type='password']/ancestor::form/descendant::button"));
    signinButton.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   String errorMessage = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class='error']")))).getText();
    System.out.println("The error message is : "+errorMessage);
    
}

public static void CSSBasicAtributr(WebDriver driver) {
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    //ptint username, password, print place holder value of username
    driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Rahul");
    driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Rahulshettyacademy");
    String placeHolderValue = driver.findElement(By.cssSelector("#inputUsername")).getAttribute("placeholder");
    System.out.println("The placeholder value is : "+placeHolderValue);

}

public static void CSSBasicAtributr2(WebDriver driver) {
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    driver.findElement(By.cssSelector("form>button")).click();
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
     String errorMessage = driver.findElement(By.cssSelector("p.error")).getText(); 
        System.out.println("The error message is : "+errorMessage);

}

public static void CSSBasicAtributr3(WebDriver driver) {
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    //css selector with tag name and class name
     driver.findElement(By.cssSelector("form[class='form']>input:nth-child(2)")).sendKeys("rahupppppl");
        driver.findElement(By.cssSelector("form[class='form']>input:nth-child(3)")).sendKeys("Rahulshettyacademy");
        driver.findElement(By.cssSelector("form[class='form']>button:nth-child(6)")).click();
         

    
}
}