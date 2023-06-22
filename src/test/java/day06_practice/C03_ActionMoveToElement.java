package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_ActionMoveToElement extends TestBase {
    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String sayfa1WindowHandle = driver.getWindowHandle();
        System.out.println("sayfa1WindowHandle = " +sayfa1WindowHandle);
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dilBolumu= driver.findElement(By.xpath("//*[@class='icp-nav-link-inner']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(dilBolumu).perform();

        bekle(2);

        // Change Land/Region ändern butonuna basiniz
        driver.findElement(By.xpath("(//div[text()='Land/Region ändern'])[1]")).click();


        // United States dropdown'undan 'Türkei (Türkiye)' seciniz
        WebElement  ddm =driver.findElement(By.xpath("(//Select)[2]"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Türkei (Türkiye)");


        // Auf website butonuna tiklayiniz
        driver.findElement(By.xpath("//h3")).click(); // herhangi bir yere tikladik dropdown pencere kapansin diye
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

        List<String> handles = new ArrayList<>(driver.getWindowHandles());  // sayfalarin handle degerlerini listeye koydum

        driver.switchTo().window(handles.get(1));  // 0 ve 1. index olmali cünkü iki sayfa var index=1 2. sayfanin handle degeridir ona gectim

        System.out.println("handles.get(0) = " + handles.get(0));
        System.out.println("handles.get(1) = " + handles.get(1));

        bekle(2);

        Assert.assertTrue(driver.getTitle().contains("Elektronik"));





    }
}
