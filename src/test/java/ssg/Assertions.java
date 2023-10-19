package ssg;


import com.google.j2objc.annotations.Weak;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


import java.util.List;

public class Assertions extends TestBase {
    //https://www.kitapyurdu.com/ adresine gidiniz.
    //Anasayfanın açıldığını doğrulayınız (Url, Title, Logo)
    //Arama motorunda “java” kelimesini aratınız.
    //Ürün listesinin dolu olduğunu doğrulayınız.
    //Arama sonuçlarının “java” kelimesini içerdiğini doğrulayınız.
    //Arama sonuçlarının “javascript” kelimesini içermediğini doğrulayınız.


    @Test
    public void assertionsTesti() {
        // Kitap Yurdu sitesine git
        driver.get("https://www.kitapyurdu.com/");

        // URL ile doğrulama
        String expectedUrl = "https://www.kitapyurdu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        // Title ile doğrulama
        String expectedTitle = "Kitapyurdu";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // Logo ile doğrulama
        WebElement logo = driver.findElement(By.cssSelector("[src*='wh:d8e078ec3']"));
        Assert.assertTrue(logo.isDisplayed());

        // Arama motorunda "java" kelimesini arat
        WebElement aramaMotoru = driver.findElement(By.id("search-input"));
        aramaMotoru.sendKeys("java", Keys.ENTER);

        // Ürün listesinin dolu olduğunu doğrula
        List<WebElement> urunListesi = driver.findElements(By.cssSelector("[class=name]"));
        Assert.assertNotNull(urunListesi);

        // Arama sonuçlarının "java" kelimesini içerdiğini doğrula
        // Arama sonuçlarının "javascript" kelimesini içermediğini doğrula
        WebElement aramaSonucBasligi = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(aramaSonucBasligi.getText().contains("java"));
        Assert.assertFalse(aramaSonucBasligi.getText().contains("javascript"));

        for (WebElement urun : urunListesi){
            Assert.assertTrue(urun.getText().contains("java")
                    || urun.getText().contains("Java")
                    || urun.getText().contains("JAVA"));

            Assert.assertFalse(urun.getText().contains("javascript")
                    || urun.getText().contains("Javascript")
                    || urun.getText().contains("JavaScript")
                    || urun.getText().contains("JAVASCRIPT"));
        }
    }

    }

