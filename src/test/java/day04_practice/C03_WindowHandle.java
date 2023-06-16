package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    @Test
    public void test01() {


        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        // 2- url'in 'amazon' icerdigini test edelim
        String actuelAmazoUrl= driver.getCurrentUrl();
        String sayfa1Handle=driver.getWindowHandle();
        Assert.assertTrue(actuelAmazoUrl.contains("amazon"));
        bekle(1);

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        String sayfa2Handle= driver.getWindowHandle();
        driver.get("https://www.bestbuy.com");
        bekle(1);

        // 4- title'in 'Best Buy' icerdigini test edelim
        String bestTitle=driver.getTitle();
        Assert.assertTrue(bestTitle.contains("Best Buy"));
        bekle(1);

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(sayfa1Handle);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java"+ Keys.ENTER);
        bekle(1);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        String sonuc = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
       Assert.assertTrue(sonuc.contains("java"));
       bekle(1);

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(sayfa2Handle);

        // 8- logonun gorundugunu test edelim
        WebElement logo= driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }
}
