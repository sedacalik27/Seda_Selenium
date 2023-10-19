package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_ActionsTest extends TestBase {
    @Test
    public void actions1() {
        //Techproeducation sayfasına gidelim

        driver.get("https://techproeducation.com");


        //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım
        //scroll demek mousuntekerlegini hareket ettirmek demek

        Actions actions= new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        bekle(2);


        //Sayfayı istediğimiz bir miktar yukarıya doğru scroll yapalım
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

        /*
    Sayfanın ortalarındaki bir webelementi locate etmek istediğimizde driver sayfayı açtığı zaman
 webelementi göremediği için bazen sayfayı az bir aşağıya doğru scroll yapmamız gerekebilir. Bunun
 için yukarıdaki örnekteki gibi Page_Down ile bunu gerçekleştirebiliriz.
    Sayfadaki bir webelementi locate ettiğimiz halde nosuchelementexception alıyorsak;
        1-Locate'i tekrar kontrol ederiz buna rağmen aynı hatayı alıyorsak;
        2-Webelementin iframe içinde olup olmadığına bakarız. Yine aynı hatayı alıyorsak;
        3-Driver webelementi göremiyordur, dolayısıyla actions class'ı kullanarak scroll yapıp
        elementin görünür olmasını sağlarız.
 */

    }


    @Test
    public void actions2() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Sayfanın en altına scroll yapalım
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();//-->sayfanın en altına scroll yapar
        bekle(3);

        //Sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).perform();//-->sayfanın en üstüne scroll yapar.

    }


    @Test
    public void actions3() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(3);



        //Events yazısına kadar scroll yapalım
        WebElement eventsYazisi = driver.findElement(By.xpath("(//h2)[1]"));
        new Actions(driver).scrollToElement(eventsYazisi).perform();//-->Locate'ini aldığımız webelemente kadar scroll yapar
        bekle(2);



    }
    /* odev:
        //Amazon sayfasına gidiniz
        //Sayfanın ortalarındaki bir webelementi locate edip o webelemente kadar scroll yapınız
 */

    @Test
    public void test04() {//ödev cevap
        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com/");

        WebElement ilgiliyer=driver.findElement(By.xpath("//*[@class='a-color-base as-title-block-left']"));
        new Actions(driver).scrollToElement(ilgiliyer).perform();



    }
}
