package day17_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JsExecutorScroll extends TestBase {

    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        bekle(2);


        //Back to school webelementine kadar scroll yapalım
        WebElement backtoschoolWE = driver.findElement(By.xpath("//*[text()='Back to school']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",backtoschoolWE);
        bekle(2);

        //scrollIntoView(true)-->BURDAKİ TRUE WEBELEMENTİ GÖRENE KADAR DEMEK

        //Sayfanın en altına scroll yapalım
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bekle(2);

        //Sayfanın en üstüne scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");




    }

    @Test
    public void test02() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Back to school webelementine kadar scroll yapalım
        WebElement backtoschoolWE = driver.findElement(By.xpath("//*[text()='Back to school']"));
        jsScroll(backtoschoolWE);//-->TestBase de oluşturduğumuz method ile scroll yaptık
        bekle(2);

        //Sayfanın en altına scroll yapalım
        jsScrollEnd();
        bekle(2);

        //Sayfanın en üstüne scroll yapalım
        jsScrollHome();

    }
}
