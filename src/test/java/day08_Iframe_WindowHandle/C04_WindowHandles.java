package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C04_WindowHandles extends TestBase {
    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandleDegeri = driver.getWindowHandle();//0516BBA3FD90781AF254E35A696DDE5F

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        bekle(2);
        //kontrolum dışında açılan pencereleri sete aldım handle değerlerini bilmediğim için

        Set<String> pencereler=driver.getWindowHandles();

        for (String w:pencereler) {
            System.out.println(w);
            if(!w.equals(ilkSayfaHandleDegeri)){//ilk handle degerini alma çünkü yukarıda aldık
                driver.switchTo().window(w);//1FE124B2B5C6C5219C1BDEE920C0E49C

            }
        }

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        Assert.assertEquals("New Window",driver.getTitle());
        String ikinciSayfaHandleDegeri = driver.getWindowHandle();//1FE124B2B5C6C5219C1BDEE920C0E49C

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandleDegeri);
    }


    @Test
    public void test02() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        /*
        click yapınca açılan istemsiz, link yeni pencerede açılıyor fakat driverim hala ilk sayfada
        getWindowHandles() sayesinde açılmış olan bütün sayfaların handleslarını alabiliyorum
        bunu listte akytarıyoruz ve index ile istediğimzi sayfanın handle degerini alıyoruz
        driver.switchTo().window(pencereler.get(1)); ile istediğimiz yere taşıyoruz driveri

         */

        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());


        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(pencereler.get(1));
        Assert.assertEquals("New Window",driver.getTitle());

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(pencereler.get(0));





}

    @Test
    public void test03() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();


        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertEquals("New Window",driver.getTitle());

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        //toStringle stringe çevirdik
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
    }

    @Test
    public void test04() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
                String text = driver.findElement(By.xpath("//h3")).getText();
                Assert.assertEquals("Opening a new window",text);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
                Assert.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
                driver.findElement(By.xpath("(//a)[2]")).click();

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
                window(1);
                Assert.assertEquals("New Window",driver.getTitle());

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
                window(0);
                Assert.assertEquals("The Internet",driver.getTitle());
                bekle(2);

        //  ikinci sayfaya tekrar geçin.
                window(1);
                bekle(2);

        //  ilk sayfaya tekrar dönün.
                window(0);




    }
}
