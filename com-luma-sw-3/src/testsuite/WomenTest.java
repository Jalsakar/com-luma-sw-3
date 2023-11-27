package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class WomenTest extends Utility {
    String baseurl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        /**
         * 1.
         * Mouse Hover on Women Menu
         * Mouse Hover on Tops
         * Click on Jackets
         * Select Sort By filter “Product Name”
         * Verify the products name display in alphabetical order
         */
        //Mouse Hover on Women Menu
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Women')]"));
        Thread.sleep(2000);
        // Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//li[contains(@class,'nav-2-1 ')]/child::a"));
        Thread.sleep(2000);
        //Click on Jackets
        mouseHoverOnElementAndClick(By.xpath("//a[@id='ui-id-11']"));//li[contains(@class,'nav-2-1 ')]/child::ul/child::li[1]/child::a
        Thread.sleep(2000);
        //Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.xpath("//div[@class='column main']/child::div[2]/child::div[3]/child::select[1]"), "Product Name");
        Thread.sleep(2000);
        //Verify the products name display in alphabetical order
        //Expected list of products name in alphabetical order
        List<WebElement> expectedProductsNameList = driver.findElements(By.xpath("//strong[contains(@class,'product name product-item-name')]/child::a"));
        List<String> expectedProductLists = new ArrayList<>();
        for (WebElement productName : expectedProductsNameList) {
            expectedProductLists.add(productName.getText());
        }
        System.out.println("Expected Product Name in Alphabetical Order: " + expectedProductLists);
        Thread.sleep(2000);
        //Original list of products name
        List<WebElement> originalProductsNameList = driver.findElements(By.xpath("//strong[contains(@class,'product name product-item-name')]/child::a"));
        List<String> originalProductLists = new ArrayList<>();
        for (WebElement productName : originalProductsNameList) {
            originalProductLists.add(productName.getText());
        }
        System.out.println("Original Product Name in Alphabetical Order: " + originalProductLists);
        Thread.sleep(2000);
        Assert.assertEquals(expectedProductLists, originalProductLists);
        Thread.sleep(2000);
    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        /**
         * 2.
         * Mouse Hover on Women Menu
         * Mouse Hover on Tops
         * Click on Jackets
         * Select Sort By filter “Price”
         * Verify the products price display in Low to High
         */
        //Mouse Hover on Women Menu
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Women')]"));
        Thread.sleep(2000);
        //Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//li[contains(@class,'nav-2-1 ')]/child::a"));
        Thread.sleep(2000);
        // Click on Jackets
        mouseHoverOnElementAndClick(By.xpath("//li[contains(@class,'nav-2-1 ')]/child::ul/child::li[1]/child::a"));
        Thread.sleep(2000);
        //Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.xpath("//div[@class='column main']/child::div[2]/child::div[3]/child::select[1]"), "Price");
        Thread.sleep(2000);
        //Expected list of products price in Low to High
        List<WebElement> expectedProductsPriceList = driver.findElements(By.cssSelector("span[data-price-type='finalPrice']"));
        List<Double> expectedProductPriceLists = new ArrayList<>();
        for (WebElement productPrice : expectedProductsPriceList) {
            expectedProductPriceLists.add(Double.valueOf(productPrice.getText().replace("$", "")));
        }
        System.out.println("Expected Product Price in Low to High: " + expectedProductPriceLists);
        Thread.sleep(2000);
        //Original list of products price in Low to High
        List<WebElement> originalProductsPriceList = driver.findElements(By.cssSelector("span[data-price-type='finalPrice']"));
        List<Double> originalProductPriceLists = new ArrayList<>();
        for (WebElement productPrice : expectedProductsPriceList) {
            originalProductPriceLists.add(Double.valueOf(productPrice.getText().replace("$", "")));
        }
        System.out.println("Original Product Price in Low to High: " + originalProductPriceLists);
        Thread.sleep(2000);
        //Verify the products price display in Low to High
        Assert.assertEquals(expectedProductPriceLists, originalProductPriceLists);
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}//Run the program