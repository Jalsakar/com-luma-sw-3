package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    /**
     * 1.
     * Mouse Hover on Men Menu
     * Mouse Hover on Bottoms
     * Click on Pants
     * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
     * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
     * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
     * Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
     * Click on ‘shopping cart’ Link into message
     * Verify the text ‘Shopping Cart.’
     * Verify the product name ‘Cronus Yoga Pant’
     * Verify the product size ‘32’
     * Verify the product colour ‘Black’
     */
    String baseurl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        Thread.sleep(2000);
//      Mouse Hover on Men Menu
        mouseHoverToElement(By.xpath("//span[contains(text(),'Men')]"));
        Thread.sleep(2000);
//      Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']"));
        Thread.sleep(2000);
//      Click on Pants
        mouseHoverOnElementAndClick(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        Thread.sleep(2000);
//      Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverOnElementAndClick(By.xpath("//div[@id='option-label-size-143-item-175']"));
        Thread.sleep(2000);
//      Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverOnElementAndClick(By.xpath("//div[@id='option-label-color-93-item-49']"));
        Thread.sleep(2000);
//      Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverOnElementAndClick(By.xpath("//button[contains(@title,'Add to Cart')]"));
        Thread.sleep(2000);
//      Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String actualText = getTextElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals("You added Cronus Yoga Pant to your shopping cart.", actualText);
        Thread.sleep(2000);
//      Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        Thread.sleep(2000);
//      Verify the text ‘Shopping Cart.’
        String actualProductText = getTextElement(By.xpath("//div[@class='page-title-wrapper']"));
        Assert.assertEquals("Shopping Cart", actualProductText);
        Thread.sleep(2000);
//      Verify the product name ‘Cronus Yoga Pant’
        String actualProductName = getTextElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals("Cronus Yoga Pant", actualProductName);
        Thread.sleep(2000);
//      Verify the product size ‘32’
        String actualProductSize = getTextElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals("32", actualProductSize);
        Thread.sleep(2000);
//      Verify the product colour ‘Black’
        String actualProductColour = getTextElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals("Black", actualProductColour);
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}//Run the program