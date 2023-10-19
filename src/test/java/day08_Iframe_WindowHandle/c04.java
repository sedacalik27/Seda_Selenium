package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class c04 extends TestBase {
    @Test
    public void test01() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);
        bekle(2);


        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(2);


        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();

        Set<String> handleEtme = driver.getWindowHandles();

        for (String w:handleEtme) {
            if(!w.equals(ilkSayfaHandle)){
                driver.switchTo().window(w);
            }

        }


        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        Assert.assertEquals("New Window",driver.getTitle());
        String ikinciSayfaHandleDegeri = driver.getWindowHandle();
        bekle(2);

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandle);
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandleDegeri);

    }
}
