package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework02 {
    /*
//https://www.facebook.com adresine gidin
//Url'in facebook içerdiğini test(assertion ile)
//"Create an Account" button'una basin
//Çıkan formu doldurunuz
//kaydol butonuna tıklayınız
Not: Before methodda driver ayarlarını yapınız
    After ile sayfayı kapatınız
 */


    WebDriver driver;

    //https://www.facebook.com adresine gidin
    //Url'in facebook içerdiğini test(assertion ile)
    @Test
    public void test01() {
        String actual = driver.getCurrentUrl();
        String expected = "facebook";
        Assert.assertTrue(actual.contains(expected));

        //"Create an Account" button'una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //Çıkan formu doldurunuz
        //kaydol butonuna tıklayınız
        driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]")).
                sendKeys("Ali",
                        Keys.TAB, "Candan",
                        Keys.TAB, "05555511111",
                        Keys.TAB, "asd123,",
                        Keys.TAB,
                        Keys.TAB, "01",
                        Keys.TAB);
        WebElement ay = driver.switchTo().activeElement();
        ay.sendKeys("May", Keys.TAB);
        WebElement yil = driver.switchTo().activeElement();
        yil.sendKeys("2000", Keys.TAB, Keys.TAB, Keys.ARROW_RIGHT, Keys.ENTER);
    }

    //Not: Before methodda driver ayarlarını yapınız
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://facebook.com/");
    }

    // After ile sayfayı kapatınız}
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
