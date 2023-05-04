package techproed.tests.Day01_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C02_DependOnMethods   {


    // test01 isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // test02 isimli bir test methodu olusturunuz. Ve arama motoruna "Nutella" Yazıp aratın
    // test03 isimli bir test methodu olusturunuz. Ve sonuc yazısının "Nutella" icerdigini test edelim


    // test02 isimli test methodunu, test01'e baglayınız.
    // test03 isimli test methodunu, test02'ye baglayınız.

    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @Test
    public void amazon() {

        driver.get("https://amazon.com");
    }

    @Test
    public void nutella() {
      WebElement aramaMoturu= driver.findElement(By.xpath("//input[@id='twotabsearchbox']"));
        aramaMoturu.sendKeys("Nutella"+ Keys.ENTER);


    }

    @Test
    public void test03() {
        WebElement aramaSonucu =  driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(aramaSonucu.getText().contains("Nutella"));
    }
}
/*
DependsOnMethods'da sadece bagli olan test, baglandigi test'in sonucuna bakar
baglandigi test passed olmazsa, baglanan test hic calismaz
 */