package day08_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FilesDownload extends TestBase {
    @Test
    public void test01() throws IOException {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        bekle(1);

        String dosyaYolu =getDosyaYolu("\\Downloads\\some-file.txt");
        Files.delete(Paths.get(dosyaYolu));
        bekle(2
        );
        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
        bekle(3);
        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz

        // "C:\Users\M\Downloads\some-file.txt"
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }


}
