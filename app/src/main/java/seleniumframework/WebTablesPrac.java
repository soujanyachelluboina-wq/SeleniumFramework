package seleniumframework;

import java.time.Duration;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebTablesPrac {
     public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
       
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       
        // webTable2(driver);
        webTable3(driver);
        
        driver.quit();
    }



    public static void webTable(WebDriver driver) {
        // to get the number of rows in the table
        int rowCount = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size();
        System.out.println("Number of rows in the table: " + rowCount);
        // to get the number of columns in the table
        int columnCount = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size();
        System.out.println("Number of columns in the table: " + columnCount);
        // to print all the courses names in the table
        for (int i = 2; i <= rowCount; i++) {
            String courseName = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println("Course Name: " + courseName);
        }

        // to print all prices in the table
        for (int i = 2; i <= rowCount; i++) {
            String price = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[" + i + "]/td[3]")).getText();
            System.out.println("Price: " + price);
        }
             // to print the price of a specific course 
        String courseToFind = "Master Selenium Automation in simple Python Language";
       
        for (int i = 2; i <= rowCount; i++) {
            String courseName = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[" + i + "]/td[2]")).getText();
           if (courseName.equalsIgnoreCase(courseToFind)) {
                String price = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[" + i + "]/td[3]")).getText();
                System.out.println("Price of '" + courseToFind + "': " + price);
                break;
            }
            
        }
    }
public static void webTable2(WebDriver driver) {
    // to print entire table data
    String tableData = driver.findElement(By.xpath("//table[@name='courses']/tbody")).getText();
    System.out.println("Table Data:\n" + tableData);
   
}

public static void webTable3(WebDriver driver) {
  
    int rows = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr")).size();
    System.out.println("Number of rows in the table: " + rows);
    int columns = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/thead/tr/th")).size();
    System.out.println("Number of columns in the table: " + columns);   
        for(int i=1; i<=rows; i++) {
            String rowData = driver.findElement(By.xpath("(//div[@class='tableFixHead']/table/tbody/tr/td[1])["+i+"]")).getText();
            System.out.println("Row "+i+" data: "+rowData);
        }
        
         for(int i=1; i<=rows; i++) {
            String cityData = driver.findElement(By.xpath("(//div[@class='tableFixHead']/table/tbody/tr/td[3])["+i+"]")).getText();
            System.out.println("Row "+i+" data: "+cityData);
        }

        String completeTable = driver.findElement(By.xpath("//div[@class='tableFixHead']")).getText();
        System.out.println("Complete Table Data:\n" + completeTable);
        
        // joe amount 
        for(int i=1; i<=rows; i++) {
            String name = driver.findElement(By.xpath("(//div[@class='tableFixHead']/table/tbody/tr/td[1])["+i+"]")).getText();
            if(name.equalsIgnoreCase("Joe")) {
                String amount = driver.findElement(By.xpath("(//div[@class='tableFixHead']/table/tbody/tr/td[4])["+i+"]")).getText();
                System.out.println("Joe's amount is : "+amount);
                break;
            }
        }

        // jack city
         for(int i=1; i<=rows; i++) {
            String name = driver.findElement(By.xpath("(//div[@class='tableFixHead']/table/tbody/tr/td[1])["+i+"]")).getText();
            if(name.equalsIgnoreCase("Jack")) {
                String city = driver.findElement(By.xpath("(//div[@class='tableFixHead']/table/tbody/tr/td[3])["+i+"]")).getText();
                System.out.println("Jack's city is : "+city);
                break;
            }
        }

        // amount of smith
         for(int i=1; i<=rows; i++) {
            String name = driver.findElement(By.xpath("(//div[@class='tableFixHead']/table/tbody/tr/td[1])["+i+"]")).getText();
            if(name.equalsIgnoreCase("Smith")) {
                String amount = driver.findElement(By.xpath("(//div[@class='tableFixHead']/table/tbody/tr/td[4])["+i+"]")).getText();
                System.out.println("Smith's amount is : "+amount);
                break;
            }
        }

        // sum of all amount 

        int sum = 0;
        for(int i=1; i<=rows; i++) {
            String amountStr = driver.findElement(By.xpath("(//div[@class='tableFixHead']/table/tbody/tr/td[4])["+i+"]")).getText();
            int amount = Integer.parseInt(amountStr);
            sum += amount;
        }
        System.out.println("Sum of all amounts: " + sum);
    
            // highest amount in table
            String highInString = driver.findElement(By.xpath("(//div[@class='tableFixHead']/table/tbody/tr/td[4])[1]")).getText();
            int highInInt = Integer.parseInt(highInString);
            
            for(int i=2; i<=rows; i++) {
                String amountStr = driver.findElement(By.xpath("(//div[@class='tableFixHead']/table/tbody/tr/td[4])["+i+"]")).getText();
                int amount = Integer.parseInt(amountStr);
                if(amount > highInInt) {
                    highInInt = amount;
                }
            }
            System.out.println("Highest amount in table: " + highInInt);

}
}
