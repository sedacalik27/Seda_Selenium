package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03 extends TestBase {
    @Test
    public void test01() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproHandle = driver.getWindowHandle();

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education", driver.getTitle());

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproHandle);
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeHandle);
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);
        bekle(2);


    }


    @Test
    public void test02() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education", driver.getTitle());

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.linkedin.com");


        List<String> handleLar = new ArrayList<>(driver.getWindowHandles());


        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(handleLar.get(0));
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(handleLar.get(1));
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(handleLar.get(2));
        bekle(2);

    }


}
