package tecproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

// Eger baska bir classta dataprovider'larimizi yaziyorsak
// dataProvider = "cityDatas" 'dan sonra
// dataProvider'imizin nerede oldugunu belirtmemiz gerekiyor.
// Bu yuzden virgul koyup 'dataProviderClass = DataProviderUtils.class)' diyerek yerini gosterdik.

    @DataProvider
    public Object[][] sehirVerileri() {
        return new Object[][]{{"Ankara","IçAnadolu","06"},{"Izmir","Ege","35"},{"DiyarBakır","Doğu","21"}};
    }
    @DataProvider
    public Object[][] kullanicilar() {
        return new Object[][]{{"Erol","654654654"},{"Nuri","321354654"},{"Gül","654321654"},{"Sefa","32165849658"}};
    }
    @DataProvider
    public Object[][] blueRental() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        return excelUtils.getDataArray();
    }
}
