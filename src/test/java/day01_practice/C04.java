package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // arama motorunda nutella yazip aratınız
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella"+ Keys.ENTER);

        // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın

        List<WebElement> urunler=driver.findElements(By.xpath("//*[@class='a-link-normal s-no-outline']"));
        for (int i = 0; i < urunler.size(); i++) {

            urunler=driver.findElements(By.xpath("//*[@class='a-link-normal s-no-outline']"));
            urunler.get(i).click();
            System.out.println(1+i +"- "+driver.getTitle());
            driver.navigate().back();

        }


    }

}

