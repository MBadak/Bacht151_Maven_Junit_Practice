package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBase {

    protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        // driver.quit();
    }

    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void cerezKabul(String iframeLocate, String kabulLocate){
        bekle(2);
        WebElement iframe = driver.findElement(By.xpath(iframeLocate));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath(kabulLocate)).click();
        driver.switchTo().parentFrame();
    }

    // Dosya yolunu dinamik olarak alamak
    public String  getDosyaYolu(String s) {

        String dosyaYolu= System.getProperty("user.home")+s;
        return dosyaYolu;
    }

    // Tüm sayfa resmi al

    public void tumSayfaResimAl() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMdd-HH.mm.ss");
        String tarih = date.format(dtf);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File kayit = new File("tumSayfaResimleri/urun "+tarih+".jpg");
        File geciciDosya= ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,kayit);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

