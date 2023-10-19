package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02 extends TestBase {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String kalinYazi = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(kalinYazi.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        WebElement textbox = driver.switchTo().frame(0).findElement(By.xpath("//p"));
        textbox.clear();


        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textbox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        driver.switchTo().parentFrame();

        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        String driverdakiYazi = driver.findElement(By.xpath("(//a)[3]")).getText();
        Assert.assertEquals("Elemental Selenium", driverdakiYazi);


    }

    @Test
    public void test02Odev() {
        // ODEV
        // https://html.com/tags/iframe/ gidiniz
        driver.get("https://html.com/tags/iframe/");
        bekle(2);
        // youtube daki play butonuna basınız
        driver.switchTo().frame(0).findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

    }

}
