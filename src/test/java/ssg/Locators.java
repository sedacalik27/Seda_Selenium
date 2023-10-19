package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Locators extends TestBase {
    //https://www.kitapyurdu.com/ adresine gidiniz.
    //“En Çok Satılanlar” bölümündeki ilk ürünü seçiniz.
    //Seçilen ürüne ait sayfanın açıldığını doğrulayınız.
    //“Devamını Oku…” butonuna basınız.
    //Ürünü sepete ekleyiniz.
    //Sepete gidiniz.
    //Ürüne ait kontrol kutusunu işaretleyiniz.
    //Ürün miktarını değiştiriniz.


    @Test
    public void locatorsTesti() {
        //Kitap yurdu sitesine gidilir
        driver.get("https://www.kitapyurdu.com/");

        //“En Çok Satılanlar” bölümündeki ilk ürün seçilir
        //sabit olan degerin locatini almalıyız divden mesela kitap ismi değişir

        List<WebElement> enCoksatilanlarListesi = driver.findElements(By.className("pr-details"));
        String ilkKitapAdi = enCoksatilanlarListesi.get(0).getText().split("\n")[0];
        //Çantamdan Fil Çıktı ismini almak için satırlarda bölüp 0. indexle aldık

        //webelementi bir liste atıp 0. index le alıp get textle yazısını alıyoruz
        enCoksatilanlarListesi.get(0).click();

        // Seçilen ürüne ait sayfanın açıldığını doğrulayınız.
        WebElement kitapAdi = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(ilkKitapAdi, kitapAdi.getText());

        // "Devamını Oku…" butonuna basınız.
        WebElement devamLinki = driver.findElement(By.partialLinkText("Devam"));
        devamLinki.click();

        // Ürünü sepete ekleyiniz.
        WebElement sepeteEkleButonu = driver.findElement(By.id("button-cart"));
        sepeteEkleButonu.click();

        // Sepete gidiniz.
        WebElement sepeteGitButonu = driver.findElement(By.linkText("sepetinize"));
        sepeteGitButonu.click();
        // Ürüne ait kontrol kutusunu işaretleyiniz.
        WebElement kontrolKutusu = driver.findElement(By.name("cart_selection[]"));
        Assert.assertFalse(kontrolKutusu.isSelected());

        if(!kontrolKutusu.isSelected()){
            kontrolKutusu.click();
        }

        // Ürün miktarını değiştiriniz.
        WebElement urunMiktari = driver.findElement(By.name("quantity"));
        //ürün milktarını sil
        urunMiktari.clear();
        //istediğimiz ürün mitarını yolla
        urunMiktari.sendKeys("3");
        //ürün miktarının değiştiğini dogrula
        Assert.assertEquals("3", urunMiktari.getAttribute("value"));



        bekle(5);






    }
}
