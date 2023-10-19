package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task04 extends TestBase {
    @Test
    public void test01() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//h5)[3]")).click();
        bekle(2);

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
       driver.switchTo().frame(5);
       WebElement yazi= driver.findElement(By.xpath("//*[@id='Ad.Plus-728x90']"));
        Assert.assertEquals("Please select an item from left to start practice.",yazi.getText());



        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        //New Tab butonunun görünür olduğunu doğrula
        //New Tab butonuna click yap
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        //İlk Tab'a geri dön
        //New Tab butonunun görünür olduğunu doğrula

    }
}
