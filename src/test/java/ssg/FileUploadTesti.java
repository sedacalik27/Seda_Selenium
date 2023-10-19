package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class FileUploadTesti extends TestBase {

    @Test
    public void fileUploadTesti() {
        // Siteye gidilir
        driver.get("https://testpages.eviltester.com/styled/file-upload-test.html");

        String farkliKisim= System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\deneme.txt.txt";
        String dosyaYolu=farkliKisim+ortakKisim;



        // Dosyayı yükle
        WebElement dosyaSecButonu = driver.findElement(By.id("fileinput"));
        dosyaSecButonu.sendKeys(dosyaYolu);

        //buna click yapamıyoruz click yapınca InvalidArgumentException hatası alıyoruz
        //input tagına biz send keysle text yollayabiliyoruz dolayısıyla dosya yolunu tanımlamamız gerekiyor
       // dosyaSecButonu.click();

        WebElement uploadButonu = driver.findElement(By.name("upload"));
        uploadButonu.click();

        // Dosyanın yüklendiğni doğrula
        WebElement yuklenenDosyaAdi = driver.findElement(By.id("uploadedfilename"));
        visibleWait(yuklenenDosyaAdi, 60);//test basedeki method kullanıldı
        Assert.assertTrue(yuklenenDosyaAdi.isDisplayed());




    }
}
