package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task06 extends TestBase {
    //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
    //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
    //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
    //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
    //-Çıkan alert'te iptal butonuna basınız
    //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
    //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
    //-Çıkan mesajı konsola yazdırınız
    //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız


    @Test
    public void test01() {
        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");


        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        WebElement button=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        button.click();

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        bekle(2);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();

        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
        bekle(2);


        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("seda");
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(2);



        //-Çıkan mesajı konsola yazdırınız

        WebElement mesaj= driver.findElement(By.id("demo1"));
        System.out.println(mesaj.getText());

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertEquals("Hello seda How are you today",mesaj.getText());


    }
}
