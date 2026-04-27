package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SauceDemo {

    private WebDriver driver;

    public SauceDemo(){
        // Start the Edge Browser
        driver = new EdgeDriver();
    }

    public void openBrowser(){
        // Go to the website and make window big
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        System.out.println("Test 1: Open Browser Success!");
    }

    public void login() throws InterruptedException{
        Thread.sleep(2000);
        // Type username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        
        // Click Login and get error message
        driver.findElement(By.id("login-button")).click();
        String err = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Error found: " + err);

        // Clear password and type correct password
        driver.findElement(By.id("password")).sendKeys("secret_sauce", Keys.ENTER);
        System.out.println("Test 2: Login Success");
    }

    public void checkPage(){
        // Check if we are on the correct page
        String expectUrl = "https://www.saucedemo.com/inventory.html";
        String currentUrl = driver.getCurrentUrl();
        assert expectUrl.equals(currentUrl);
        System.out.println("Test 3: Verify Success");
    }

    public void addToCart() throws InterruptedException{
        // Click 'Add to Cart' buttons for 3 items
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        System.out.println("Test 4: Add items to cart");
    }

    public void checkOut() throws InterruptedException{
        // Fill checkout form (Name and Zip code)
        driver.findElement(By.name("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("zin zin");
        driver.findElement(By.id("last-name")).sendKeys("phyoe");
        driver.findElement(By.name("postalCode")).sendKeys("123456");
        
        // Click Continue button
        driver.findElement(By.cssSelector("input[type=\"submit\"")).click();
    }

    public void finish(){
        // Click finish and go back to products page
        driver.findElement(By.id("finish")).click();
        driver.findElement(By.id("back-to-products")).click();
        System.out.println("Test 9: Finish Success!");
    }

    public void logout() throws InterruptedException{
        // Open menu and click Logout link
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Logout")).click();
        System.out.println("Log Out Success");
    }

    public void main() throws InterruptedException {
        // Run all test steps one by one
        openBrowser();
        login();
        checkPage();
        addToCart();
        checkOut();
        finish();
        logout();
        driver.quit(); // Close the browser
    }

    public static void main(String[] args) throws InterruptedException {
        // Run the program
        new SauceDemo().main();
    }
}
