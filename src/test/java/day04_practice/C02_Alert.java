package day04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Alert extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        cerezKabul("//*[@id='gdpr-consent-notice']","//span[text()='Alle akzeptieren']");

        //customer id kısmına 53920 yazın
        driver.findElement(By.xpath("//*[@name='cusid']")).sendKeys("53920");

        //submit butonuna tıklayın
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        //cıkan alert mesajını yazdırın
        System.out.println("1. Alert : "+driver.switchTo().alert().getText());
        //alerti kabul edin
        driver.switchTo().alert().accept();
        bekle(2);
        //cıkan 2. alert mesajını yazdırın
        System.out.println("2. Alert : "+driver.switchTo().alert().getText());
        //cıkan 2. alerti kabul edin

        driver.switchTo().alert().accept();

    }
}
