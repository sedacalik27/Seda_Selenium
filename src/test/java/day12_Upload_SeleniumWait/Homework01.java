package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Homework01 extends TestBase {
    @Test
    public void test01() {
        // 3.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4.Remove butonuna basin.
        driver.findElement(By.xpath("(//button)[1]")).click();

        // 5.“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p)[2]")));

        Assert.assertEquals("It's gone!",driver.findElement(By.xpath("(//p)[2]")).getText());

        // 6.Add buttonuna basin
        driver.findElement(By.xpath("(//button)[1]")).click();


        // 7.It’s back! mesajinin gorundugunu test edin

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assert.assertEquals("It's back!", driver.findElement(By.id("message")).getText());
    }


    @Test
    public void test02() {

          // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
                driver.get("https://the-internet.herokuapp.com/dynamic_controls");

          // Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox= driver.findElement(By.xpath("//*[@type='text']"));
        System.out.println(!textBox.isEnabled());


        // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enableButton=driver.findElement(By.xpath("(//button)[2]"));
        enableButton.click();


        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='text']")));



          // “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertEquals("It's enabled!", driver.findElement(By.xpath("//*[@id='message']")).getText());

          // Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textBox.isEnabled());

    }
}
