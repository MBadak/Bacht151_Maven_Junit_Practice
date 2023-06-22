package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C01_WindowHandles extends TestBase {

    @Test
    public void test01() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String sayfa1Handle=driver.getWindowHandle();
        System.out.println("sayfa1Handle = " +sayfa1Handle );
        bekle(2);
        System.out.println("Sayfa1Title = " + driver.getTitle());
        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.xpath("//*[@id='searchData']")).sendKeys("Oppo", Keys.ENTER);
        bekle(2);

        // ilk ürüne tıklayın
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='productName'])[1]"));
        ilkUrun.click();
        bekle(2);

        // 2. sayfa basliginin  'Türkiye' icerdigini test edin.
        List<String> handeles= new ArrayList<>(driver.getWindowHandles());

        System.out.println("handeles.get(0) = " + handeles.get(0));
        System.out.println("handeles.get(1) = " + handeles.get(1));
        String sayfa2Handle="";
        for (String w: handeles ) {
            if (!w.equals(sayfa1Handle)){
                sayfa2Handle=w;
            }

        }
        System.out.println("sayfa2Handle = " + sayfa2Handle);


        driver.switchTo().window(sayfa2Handle);

        String actualTitleIlkUrun = driver.getTitle();

        System.out.println("actualTitleIlkUrun = " + actualTitleIlkUrun);
        Assert.assertTrue(actualTitleIlkUrun.contains("Türkiye"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfa1Handle);
        driver.navigate().back();
        System.out.println("Sayfa1Title = " + driver.getTitle());


    }
}
