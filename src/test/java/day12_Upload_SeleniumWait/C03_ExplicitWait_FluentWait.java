package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_ExplicitWait_FluentWait extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE = driver.findElement(By.xpath("(//h4)[2]"));
        /*
         Aşağıdaki gibi fluentWait class'ında bir obje oluştururuz. Obje ile önce max. süreyi belirtir
            sonra hangi aralıklarla bekleme yapacaksa onu belirtiriz.
         */

        FluentWait<WebDriver> wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)).
                pollingEvery(Duration.ofMillis(200)).//bekleme aralıgını belirliyoruz
                withMessage("WebElementi Kotrol Et");//hata alma durumunda mesaj yazıyor

        wait.until(ExpectedConditions.visibilityOf(helloWorldWE));

        Assert.assertEquals("Hello World!", helloWorldWE.getText());




    }


    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE = driver.findElement(By.xpath("(//h4)[2]"));
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(200)).
                until(ExpectedConditions.visibilityOf(helloWorldWE));

        Assert.assertEquals("Hello World!", helloWorldWE.getText());
    }


    /*
    null pointer exception alırsak:
    1)locate kontrol et yanlış olabilir
    2)iframe var olabilir
    3)driveri görmüyordur scroll yap
     */



}

