package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Events linkine tıklayalım
        WebElement eventsWE = driver.findElement(By.xpath("(//a[text()='Events'])[1]"));
        eventsWE.click();

        //Basliğin Events içerdiğini doğrulayalım
        Assert.assertTrue(driver.getTitle().contains("Events"));

        //Ve sayfanın resmini alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/ekranGoruntusu/ekranGoruntusu"+tarih+".jpeg";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

        //Yeni bir sekmede amazon sayfasına gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //Ve sayfanın resmini alalım
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String path = "target/ekranGoruntusu/ekranGoruntusu"+date+".jpeg";
        FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE),new File(path));

        //Arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone",Keys.ENTER);

        //Çıkan sonun yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String time = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String yol = "target/webElementEkranGoruntusu/ekranGoruntusu"+time+".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(yol));

        //Techpro sayfasına geri dönelim
        window(0);

        //ve sayfanın resmini alalım
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        String dateTime = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String pathYol = "target/ekranGoruntusu/ekranGoruntusu"+dateTime+".jpeg";
        FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE),new File(pathYol));
    }


    @Test
    public void test02() {//methodla yaptık.
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Events linkine tıklayalım
        WebElement eventsWE = driver.findElement(By.xpath("(//a[text()='Events'])[1]"));
        eventsWE.click();

        //Basliğin Events içerdiğini doğrulayalım
        Assert.assertTrue(driver.getTitle().contains("Events"));

        //Ve sayfanın resmini alalım
        ekranResmi();

        //Yeni bir sekmede amazon sayfasına gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //Ve sayfanın resmini alalım
        ekranResmi();

        //Arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //Çıkan sonun yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementResmi(sonucYazisi);

        //Techpro sayfasına geri dönelim
        window(0);

        //ve sayfanın resmini alalım
        ekranResmi();
    }
}

