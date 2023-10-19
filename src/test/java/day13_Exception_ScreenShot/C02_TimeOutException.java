package day13_Exception_ScreenShot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    @Test
    public void test01() {
        /*
            TIMEOUTEXCEPTION
            Eğer timeOutexception alıyorsanız;
        1-Kullanılan explicitWait'teki max. süreyi kontrol etmemiz gerekir
        2-explicit wait ile kullandığımız elementin locatini kontrol etmemiz gerekir
        3-explicit wait ile kullandığımız methodu doğru seçmemiz gerekir
 */


        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

            //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

            //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE = driver.findElement(By.xpath("(//h4)[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));//-->timeOutException almak için süreyi azalttık
        wait.until(ExpectedConditions.visibilityOf(helloWorldWE));

        Assert.assertEquals("Hello World!",helloWorldWE.getText());
    }


    @Test
    public void test02() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        new WebDriverWait(driver,Duration.ofSeconds(15)).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("yanlis locate")));
        //Wait içinde yanlis locate de bize TimeOutException verir

        //NOT: Eğer yanlis LOCATOR(örn:xpath yerine css gibi) kullanırsanız InvalidSelectorException alırsınız











    }
}
