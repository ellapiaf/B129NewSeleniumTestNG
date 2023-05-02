package techproed.tests.day23_DependsOnMethods_SoftAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethods {
    /*
    Test methodlari birbirinden bagimsiz calisir, Methodlari birbirine bagimli calistirmak istersek
    DEPENDSONMETHODS parametresini @Test notasyonundan sonra baglamak istedigimiz test method'unun
    adini belirtiriz.
     */
     WebDriver driver;
    @Test
    public void amazonTest() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(dependsOnMethods = "amazonTest")
    public void amazonTest2() {
        driver.get("https://amazon.com");
        //Eger dependsOnMethods kullanmazsak bu ornek icin java.lang.NullPointerException hatasi aliriz.
    }

    @Test(dependsOnMethods = "amazonTest2")
    public void amazonTest3() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }
}
