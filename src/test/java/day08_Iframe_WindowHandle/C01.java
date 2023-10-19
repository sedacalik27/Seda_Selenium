package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01 extends TestBase {
    @Test
    public void test01() {

        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
        String baslik = driver.findElement(By.xpath("(//p)[1]")).getText();
        Assert.assertTrue(baslik.contains("black border"));

        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        String baslik2 = driver.switchTo().frame(0).findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Applications lists", baslik2);

        //Son olarak footer daki 'Povered By' yazisini varligini test edelim
        //  driver.switchTo().parentFrame();  Bir ust frame'e gecmek icin
        driver.switchTo().defaultContent(); //En usstteki frame'e gecmek icin
        //  driver.navigate().refresh(); frame icinde degisiklik yapildiysa hepsini sile iptal eder.
        //  driver.get(driver.getCurrentUrl()); //anasayfaya gider
        String baslik3 = driver.findElement(By.xpath("//*[text()='Povered By']")).getText();
        Assert.assertTrue(baslik3.contains("Povered By"));

    }

}
