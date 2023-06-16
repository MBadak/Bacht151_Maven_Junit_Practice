package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C04_Iframe extends TestBase {
    @Test
    public void test01() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");
        // Videoyu görecek kadar asagiya ininiz
        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe= driver.findElement(By.xpath("//*[@width='560']"));
        driver.switchTo().frame(iframe);

        WebElement play= driver.findElement(By.xpath("//*[@aria-label='Wiedergabe']"));

        play.click();

        // Videoyu calistirdiginizi test ediniz
        Assert.assertFalse(play.isDisplayed()); //play gözükmüyorsacalismaya baslamis demektir

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        WebElement textPowerful= driver.findElement(By.xpath("//*[@id='Powerful_but_easy_to_misuse']"));

        Assert.assertTrue(textPowerful.isDisplayed());

    }
}
