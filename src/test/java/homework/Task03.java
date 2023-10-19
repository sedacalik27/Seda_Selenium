package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Task03 extends TestBase {
    @Test
    public void test01() {
        //-https://the-internet.herokuapp.com/windows sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/windows ");

        //-Sayfada Elemental Selenium webelementinin görünür olduğunu test ediniz
        WebElement yazi= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(yazi.isDisplayed());

        //-Elemental Selenium linkine tıklayınız
        yazi.click();

        List<String> pencereler= new ArrayList<>(driver.getWindowHandles());

        //-Açılan pencerede sayfa başlığının Elemental Selenium içerdiğini test ediniz
        driver.switchTo().window(pencereler.get(1));
        Boolean iceriyormu=driver.getTitle().contains("Elemental Selenium");


        //-Url'in https://elementalselenium.com/ olduğunu doğrulayınız
        Assert.assertEquals("https://elementalselenium.com/",driver.getCurrentUrl());
    }













}
