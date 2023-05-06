package techproed.tests.Day25_Tekrar;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;

public class T01_ExcellTest1 {
    @Test
    public void excelTest1() {

//        String path="src/test/java/resources/mysmoketestdata.xlsx";
//        String sayfa="customer_info";
        ExcelUtils excelUtils=new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        String email=excelUtils.getCellData(1,0);
        String password=excelUtils.getCellData(1,1);
        System.out.println(email+"||"+password);


        //Bluerantal car adresine gidelim.
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));

        //Excel dosyamızdan aldıgımız ilk emaıl ve password ile sayfaya login olalım.
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        //Login oldugumuzu dogrulayalım.
        Assert.assertTrue(blueRentalPage.verify.isDisplayed());


    }



}
