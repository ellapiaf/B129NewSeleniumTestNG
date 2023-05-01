package tecproed.tests.day26_ExcelDataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import tecproed.pages.BlueRentalPage;
import tecproed.utilities.*;

import java.util.Arrays;

public class C03_DataProviderExcel {

    @Test
    public void test1() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        System.out.println(Arrays.deepToString(excelUtils.getDataArray()));
    }
    @Test(dataProvider = "blueRental",dataProviderClass = DataProviderUtils.class)
    public void test2(String email,String password) {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();//login buttonuna tıklar
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
    /*
    TESTLERIMIZ:TEST PACKAGE ALTINDA
    LOCATELERIMIZ:PAGES PACKAGE ALTINDA
    AYARLAMALARI YAPTIGIMIZ VE METHODLAR OLUSTURDUGUMUZ CLASSLAR UTILITIES ALTINDA
     */
}
