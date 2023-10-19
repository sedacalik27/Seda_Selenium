package ssg;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class IframeTestleri extends TestBase {

    @Test
    public void iframeTestleri() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        //başlıgını aldık sayfanın
        WebElement baslik = driver.findElement(By.tagName("h3"));
        System.out.println(baslik.getText());

        driver.switchTo().frame(0);//eger bunu yazmasaydık nusuchelement hatası alırız aşagıdaki paragrafta

        //iç tarafa gelmeye çalışıyoruz
        WebElement paragraf = driver.findElement(By.tagName("p"));
        System.out.println(paragraf.getText());
        //switch to yapmasaydık nosuchelement hatası alırız
        //no such element hatası alırsak aklımıza iframe gelsin

        driver.switchTo().parentFrame();//stale element hatsı almamak için bunu yaptık

        System.out.println(baslik.getText());
        //StaleElementReferenceException hatası alırız çünkü driverı iframe içinde element bayatladı

        bekle(2);




    }

    @Test
    public void nestedFrameTesti() {
        driver.get("https://demoqa.com/nestedframes");

        WebElement metin = driver.findElement(By.xpath("//*[contains(text(),'arent frame')]"));
        System.out.println(metin.getText());

        WebElement baslik = driver.findElement(By.className("main-header"));
        System.out.println(baslik.getText());

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='/sampleiframe']"));
        driver.switchTo().frame(iframe);


        //reklamlar yüzünden iframe indexi tutmayabilir onun için gizli sekmede açıp bakmak lazım
        //ondan sonra //iframe yazarsak hangi iframe mi alacagımızı tespit ederiz
        WebElement ilkFrameMetni = driver.findElement(By.tagName("body"));
        System.out.println(ilkFrameMetni.getText());

        driver.switchTo().frame(0);
        WebElement childFrameMetni = driver.findElement(By.tagName("body"));
        System.out.println(childFrameMetni.getText());

        driver.switchTo().defaultContent();
        System.out.println(baslik.getText());
        //gizli sekmede açıp frameleri kontrol ettik aslında 11 tane frame oldugunu gördük




    }
}
