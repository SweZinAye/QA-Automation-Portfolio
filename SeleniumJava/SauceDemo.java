package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemo {

    private WebDriver driver;

    public SauceDemo(){
        driver = new ChromeDriver();
    }

    public void openBrowser(){
        // Test 1: Open Website
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        System.out.println("Test 1: Open Browser Success!");
    }

    public void login() throws InterruptedException{
        // Test 2: Login flow with Negative & Positive cases
        Thread.sleep(2000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click(); // Check error
        Thread.sleep(2000);
        String err = driver.findElement(By.tagName("h3")).getText();
        System.out.println(err);
        driver.findElement(By.className("error-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("123", Keys.ENTER);
        Thread.sleep(2000);
        err = driver.findElement(By.tagName("h3")).getText();
        System.out.println(err);
        driver.findElement(By.className("error-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("password")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce", Keys.ENTER);
        System.out.println("Test 2: Login Success");
    }

    public void logout() throws InterruptedException{
        // Logout flow
        Thread.sleep(2000);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Logout")).click();
        System.out.println("Log Out Success");
    }

    public void checkPage(){
        // Testing 3: Page Verification
        String expectUrl = "https://www.saucedemo.com/inventory.html";
        String currentUrl = driver.getCurrentUrl();
        assert expectUrl.equals(currentUrl);
        assert driver.getTitle().contains("Swag Labs");
        System.out.println("Testing 3: Verify Success");
    }

    public void addToCart() throws InterruptedException{
        // Test 4: Add multiple items to cart
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        System.out.println("Test 4: Add item to cart");
    }

    public void remove() {
        // Test 5: Remove item test
        driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
        System.out.println("Test 5 : Remove 1 item");
    }

    public void viewOrderItems() throws InterruptedException{
        // Test 6: Navigate to Cart
        Thread.sleep(2000);
        driver.findElement(By.className("shopping_cart_link")).click();
        System.out.println("Test 6: View Order Item");
    }

    public void viewCartDetail() throws InterruptedException{
        // Test 7: View Item Detail via XPath/CSS
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div")).click();
        Thread.sleep(2000);
        String title = driver.findElement(By.cssSelector(".inventory_details_name.large_size")).getText();
        String price = driver.findElement(By.className("inventory_details_price")).getText();
        System.out.println(title);
        System.out.println(price);
        driver.findElement(By.className("shopping_cart_link")).click();
        System.out.println("Test 7: View Cart detail Success!");
    }

    public void checkOut() throws InterruptedException{
        // Test 8: Checkout Form Automation
        driver.findElement(By.name("checkout")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("first-name")).sendKeys("zin zin");
        Thread.sleep(2000);
        driver.findElement(By.id("last-name")).sendKeys("phyoe");
        Thread.sleep(2000);
        driver.findElement(By.name("postalCode")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[type=\"submit\"")).click();
    }

    public void payment(){
        // Extract Payment Totals
        String itemTotal = driver.findElement(By.className("summary_subtotal_label")).getText();
        String tax = driver.findElement(By.className("summary_tax_label")).getText();
        String total = driver.findElement(By.className("summary_total_label")).getText();
        System.out.println(itemTotal);
        System.out.println(tax);
        System.out.println(total);
        System.out.println("=".repeat(33));
    }

    public void finish(){
        // Test 9: Complete Order
        driver.findElement(By.id("finish")).click();
        String complete = driver.findElement(By.tagName("h2")).getText();
        System.out.println(complete);
        driver.findElement(By.id("back-to-products")).click();
        System.out.println("Test 9 : Finish Success!");
        System.out.println("=".repeat(33));
    }

    public void main() throws InterruptedException {
        openBrowser();
        login();
        checkPage();
        addToCart();
        remove();
        viewOrderItems();
        viewCartDetail();
        checkOut();
        payment();
        finish();
        logout();
        Thread.sleep(5000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        new SauceDemo().main();
    }
}
