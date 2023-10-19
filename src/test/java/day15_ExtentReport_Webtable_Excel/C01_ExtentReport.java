package day15_ExtentReport_Webtable_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExtentReport extends TestBase {
    @Test
    public void test01() {
        rapor("Chrome","AmazonTesti");
        extentTest=extentReport.createTest("Extent Report","Test Raporu");

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Kullanici Amazon Sayfasina Gider");

        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Arama Kutusu Locate Edildi");
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda Iphone aratildi");
        extentReport.flush();






    }
}
