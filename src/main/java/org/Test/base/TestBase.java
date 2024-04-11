package org.Test.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.TestRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TestBase {

    public static WebDriver driver ;

    @BeforeTest
    public void getBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void BuyMonitor(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Monitor");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[contains(text(),'BenQ')]")).click();
        String parent_window = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        String price = null;
        while(itr.hasNext()){
            String child_window = itr.next();
            if(!parent_window.equalsIgnoreCase(child_window)){
                driver.switchTo().window(child_window);
                price = driver.findElement(By.xpath( "//span[@class='a-price-whole']")).getText();
                System.out.println(price.trim());
                driver.findElement(By.id("add-to-cart-button")).click();
                driver.close();

            }
        }
        driver.switchTo().window(parent_window);
        driver.findElement(By.id("nav-cart-count")).click();
        String total_price = driver.findElement(By.id("sc-subtotal-amount-buybox")).getText();
        Assert.assertEquals(price,total_price.trim());

    }

    @Test(priority = 2)
    public void BuyLaptop(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[contains(text(),'Dell 14 Laptop')]")).click();
        String parent_window = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        String price = null;
        while(itr.hasNext()){
            String child_window = itr.next();
            if(!parent_window.equalsIgnoreCase(child_window)){
                driver.switchTo().window(child_window);
                price = driver.findElement(By.xpath( "//span[@class='a-price-whole']")).getText();
                System.out.println(price.trim());
                driver.findElement(By.id("add-to-cart-button")).click();
                driver.close();

            }
        }
        driver.switchTo().window(parent_window);
        driver.findElement(By.id("nav-cart-count")).click();
        String total_price = driver.findElement(By.id("sc-subtotal-amount-buybox")).getText();
        Assert.assertEquals(price,total_price.trim());
    }

    @Test(priority = 2)
    public void BuyKeyboard(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Keyboard");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[contains(text(),'HP K160')]")).click();
        String parent_window = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        String price = null;
        while(itr.hasNext()){
            String child_window = itr.next();
            if(!parent_window.equalsIgnoreCase(child_window)){
                driver.switchTo().window(child_window);
                price = driver.findElement(By.xpath( "//span[@class='a-price-whole']")).getText();
                price = price.replace(',',' ');
                System.out.println(price.trim());
                driver.findElement(By.id("add-to-cart-button")).click();
                driver.close();

            }
        }
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("headphones");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[contains(text(),'skullkandy Smokin buds')]")).click();
        parent_window = driver.getWindowHandle();
        windows = driver.getWindowHandles();
        itr = windows.iterator();
        String price2 = null;
        while(itr.hasNext()){
            String child_window = itr.next();
            if(!parent_window.equalsIgnoreCase(child_window)){
                driver.switchTo().window(child_window);
                price2 = driver.findElement(By.xpath( "//span[@class='a-price-whole']")).getText();
                price2 = price2.replace(',',' ');
                System.out.println(price2.trim());
                driver.findElement(By.id("add-to-cart-button")).click();
                driver.close();

            }
        }
        driver.switchTo().window(parent_window);
        driver.findElement(By.id("nav-cart-count")).click();
        String total_price = driver.findElement(By.id("sc-subtotal-amount-buybox")).getText();
        int total_item_price = Integer.parseInt(price)+Integer.parseInt(price2);
        Assert.assertEquals(total_item_price,total_price.trim());
    }


    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
