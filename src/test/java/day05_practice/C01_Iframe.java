package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {


    // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
    // Videoyu görecek kadar asagiya ininiz
    // Videoyu izlemek icin Play tusuna basiniz
    // videoyu durdurunuz
    // videoyu tam ekran yapınız
    // videoyu calıstırınız
    // videoyu kucultunuz
    // videoyu durdurunuz
    // Videoyu calistirdiginizi test ediniz
    // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz


    @Test
    public void iframe() {

        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

        bekle(1);

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(4);


        // Videoyu izlemek icin Play tusuna basiniz

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);


        /*
        play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı.
        Bunun üzerine HTML kodlarını inceleyince Play'in aslında bir iframe icerisinde oldugunu gördük
        Bu durumda önce iframe locate edip sonra switchTo() ile iframe'e gecmeliyiz
         */


        WebElement playTusu = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playTusu.click();


        bekle(5);

        // videoyu durdurunuz

        WebElement startStopButton = driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']"));

        startStopButton.click();
        bekle(1);
        // videoyu tam ekran yapınız
        WebElement tamEkranButton = driver.findElement(By.xpath("//*[@class='ytp-fullscreen-button ytp-button']"));
        tamEkranButton.click();
        bekle(1);
        // videoyu calıstırınız
        startStopButton.click();

        bekle(6);
        // videoyu kucultunuz
        tamEkranButton.click();
        bekle(1);
        // videoyu durdurunuz
        startStopButton.click();

        // Videoyu calistirdiginizi test ediniz
        Assert.assertTrue(startStopButton.isDisplayed());

        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        bekle(1);
        actions.sendKeys(Keys.PAGE_UP).perform();
        bekle(1);
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(h1.isDisplayed());


    }
}