package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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
}

