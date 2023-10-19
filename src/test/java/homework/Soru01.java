package homework;

import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.List;
import java.util.Set;


public class Soru01<Webelement> extends TestBase {
    @Test
    public void test01() {

        //- ebay sayfasına gidiniz
        driver.get("https://www.ebay.com/");
        String ilkSayfaHandle= driver.getWindowHandle();

        //- electronics bölümüne tıklayınız
        WebElement element= driver.findElement(By.xpath("(//*[@href='https://www.ebay.com/b/Electronics/bn_7000259124'])[2]"));
        element.click();

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım

        List <WebElement> resimListesi= driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
        for (int i = 0; i < resimListesi.size() ; i++) {
            resimListesi= driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            resimListesi.get(i).click();
            System.out.println(driver.getTitle());//- Her sayfanın sayfa başlığını yazdıralım

            driver.navigate().back();
        }


    }


    @Test
    public void hocacozumu() throws InterruptedException {
        //- ebay sayfasına gidiniz
        driver.get("https://ebay.com");

        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        //- Her sayfanın sayfa başlığını yazdıralım
        List<WebElement> urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
        for (int i = 0; i < urunler.size(); i++) {
            urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            urunler.get(i).click();
            Thread.sleep(2000);
            System.out.println(i+1 +". başlık : " + driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }

    }
}
