package day08_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {
        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");
        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//*[@id='search-input']")).sendKeys("oppo", Keys.ENTER);

        // sonuc yazısını yazdiriniz
        System.out.println("Sonuc = "+driver.findElement(By.xpath("//*[@class='plp-title']")).getText());

        // ilk urunun fotografını cekin
        WebElement ilkUrun= driver.findElement(By.xpath("(//*[@class=' prd-link '])[1]"));
        File kayit = new File("webElementResimleri/urun.jpg");
        File geciciDosya= ilkUrun.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,kayit);



    }
}
