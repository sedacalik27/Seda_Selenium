package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;

public class FileDownloadTesti extends TestBase {
    @Test
    public void fileDownloadTesti() {
        //siteye gidilir
        driver.get("https://drive.google.com/file/d/1m4zDAj6HT5hD2g4-2ooFT2gIs660qte3/view?usp=sharing");

        /*
        file dowload kısmında bulunan oka sag tık yapılamıyor locatini alamıyoruz böyle bir surumla
        karşılaşırsak sag üstte 3 noktaya tıklayıp araçlar kısmından geliştirici araçalar
        kısmına girince incele kısmı açılıyor
         */

        //dosya indirilir
        WebElement downloadButton= driver.findElement(By.xpath("//div[@aria-label=\"İndir\"]"));
        downloadButton.click();

        //dosya yolunu tanımla
        //bunun için indirilenler klasörüne girip dosyaya sağ tıklayıp özelliklerde konum yazısını koplalıyoruz

        //String dosyaYolu= "C:\\Users\\SEDA\\Downloads\\TEAM-8 _ TestNG_Rapor (1)";
                            //konum                           dosya adi

        //her bilgisayarda farkli olan kısmı dinamik hale getiriyoruz
        String farkliKisim= System.getProperty("user.home");
        String ortakKisim= "\\Downloads\\TEAM-8 _ TestNG_Rapor.zip";

        //şimdi birleştiriyoruz
        String dosyaYolu=farkliKisim+ortakKisim;


        //şimdi file classını kullanacagız
        File dosya=new File(dosyaYolu);

        //dosya daha önce inmişse eskisini sil
        dosya.delete();


        //dosya inene kadar bekle
        while(!dosya.exists()){
            bekle(5);
        }

        //dosyanın indiğini dogrula
        Assert.assertTrue(dosya.exists());//bu dosya burada var mı?


        //file classına dosya yolunu tanıımlıcaz exist methodu da bu dosyanın varlıgını kontrol ediyor

    }




}
