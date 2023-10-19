package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class GetMethodlari extends TestBase {

    //https://www.kitapyurdu.com/ adresine gidiniz.
    //Anasayfanın açıldığını sayfa URL’si ile doğrulayınız.
    //Anasayfanın açıldığını sayfa başlığı ile doğrulayınız (“Kitapyurdu, Kitapla buluşmanın en kolay yolu”).
    //Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğunu doğrulayınız.
    //Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
    //“Üye Ol” butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
    //En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
    //En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunu doğrulayınız.
    //Haftanın Yayınevi bölümündeki kitap resimlerinin genişliklerinin 120 olduğunu doğrulayınız.


    @Test
    public void getMetotlariTesti() {
        // Kitap Yurdu sitesine gidilir
        driver.get("https://www.kitapyurdu.com/");

        // URL ile doğrulama yapılır
        String expectedUrl = "https://www.kitapyurdu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        // Sayfa başlığı ile doğrulama yapılır
        String expectedTitle = "Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğu doğrulanır
        String pageSource = driver.getPageSource();
        String expectedText = "Haftanın Yayınevi";
        Assert.assertTrue(pageSource.contains(expectedText));

        expectedText = "En Çok Satılanlar";
        Assert.assertTrue(pageSource.contains(expectedText));

        expectedText = "Ayın Yayınevleri";
        Assert.assertTrue(pageSource.contains(expectedText));

        // Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğu doğrulanır
        WebElement girisButonu = driver.findElement(By.xpath("//div[@class='menu-top-button login']"));
        expectedText = "Giriş Yap";
        String actualText = girisButonu.getText();
        Assert.assertEquals(expectedText, actualText);

        // "Üye Ol" butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğu doğrulanır
        WebElement uyeOlButonu = driver.findElement(By.linkText("Üye Ol"));
        expectedText = "https://www.kitapyurdu.com/index.php?route=account/register";
        actualText = uyeOlButonu.getAttribute("href");
        Assert.assertEquals(expectedText, actualText);

        // En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğu doğrulanır
        List<WebElement> yazarIsimListesi = driver.findElements(By.xpath("//span[@class='author line-clamp-2']"));
        for (WebElement yazarIsmi : yazarIsimListesi){
            Assert.assertEquals("span", yazarIsmi.getTagName());
        }

        // En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğu doğrulanır
        for (WebElement yazarIsmi : yazarIsimListesi){
            Assert.assertEquals("Arial, Helvetica, sans-serif", yazarIsmi.getCssValue("font-family"));
        }

        // Haftanın Yayınevi bölümündeki kitap resimlerinin genişliklerinin 120 olduğu doğrulanır
        List<WebElement> haftaninListesi = driver.findElements(By.xpath("//ul[@class='product-grid swiper-wrapper']//li//img"));
        for (WebElement resimler : haftaninListesi){
            Assert.assertEquals(120, resimler.getSize().getWidth());
        }




    }
}
