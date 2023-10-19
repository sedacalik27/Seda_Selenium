package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Set;

public class C02_Iframe extends TestBase {


    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz

        driver.get("https://the-internet.herokuapp.com/iframe");
        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        WebElement kalinYazi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(kalinYazi.getText().contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elementalSelenium = driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertTrue(elementalSelenium.getText().contains("Elemental Selenium"));

    }

    @Test
    public void test02() {

        // ODEV
        // https://html.com/tags/iframe/ gidiniz


        driver.get("https://html.com/tags/iframe/");
        bekle(2);

        // youtube daki play butonuna basınız

        driver.switchTo().frame(0).findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();


    }


   // @Test
   // public void test03() {
   //     // 1-https://the-internet.herokuapp.com/windows sayfasına gidiniz
   //     driver.get("https://the-internet.herokuapp.com/windows");
   //     String birinciHandle = driver.getWindowHandle();
   //     // 2-Elemental Selenium linkine tıklayıp Sayfa başlığının Elemental Selenium içerdiğini test edin
   //     driver.findElement(By.xpath("(//a)[3]")).click();
   //     bekle(2);
//
   //     Set<String> acilansayfalar = driver.getWindowHandles();
//
   //     for (String w : acilansayfalar) {
//
   //         if (!w.equals(birinciHandle)) {
   //             driver.switchTo().window(w);
   //         }
   //         String ikincisayfaHandle= driver.getWindowHandle();
   //         String baslik = driver.getTitle();
   //         Assert.assertTrue(baslik.contains("Elemental Selenium"));
//
//
   //     }
   // }



    @Test
    public void test05() {//ODEV02
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandle= driver.getWindowHandle();
        WebElement elemental= driver.findElement(By.xpath("(//a)[3]"));
        elemental.click();

        Set<String> pencereler=driver.getWindowHandles();
        for (String w:pencereler){
            if (!w.equals(ilkSayfaHandle)){
                driver.switchTo().window(w);
            }
        }
        String ikinciSayfaHandle=driver.getWindowHandle();
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Elemental Selenium"));

    }


    @Test
    public void testdeneme() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        WebElement kalinyazi= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(kalinyazi.getText().contains("Editor"));


        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement frametext=driver.findElement(By.xpath("//p"));
        frametext.clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        frametext.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement sonyazi=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(sonyazi.getText().contains("Elemental Selenium"));




    }
}














