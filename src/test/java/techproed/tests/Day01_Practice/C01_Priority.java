package techproed.tests.Day01_Practice;

import org.testng.annotations.Test;
import techproed.utilities.TestBase;

public class C01_Priority  extends TestBase {

    // amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
    // techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz

    // once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız


    @Test(priority = -2)
    public void amazon() {
        driver.get("https://www.amazon.com");

    }

    @Test(priority = 0)
    public void bestBuy() {
        driver.get("https://bestbuy.com");
    }

    @Test(priority = -5)
    public void techproeducation() {
        driver.get("https://www.techproeducation.com");
    }

    /*
    TestNG , Test methodlarini isim sirasina gore calistirir
    eger isim siralamasinin disinda bir siralama ile calismasini isterseniz
    o zaman test methodlarina oncelik yani (priority) tanimlayabiliriz.


    Priority kucukten buyuge gore calisir
    eger bir test methoduna priority degeri atanmamissa default olarak priority =0 kabul edilir.
     */
}
