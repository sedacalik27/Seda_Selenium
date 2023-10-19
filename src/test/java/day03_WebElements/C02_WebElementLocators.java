package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebElementLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Techpro sayfasına gidelim
        driver.get("https://techproeducation.com");

        //arama kutusunda java aratalım
        driver.findElement(By.id("searchHeaderInput")).sendKeys("java");
        Thread.sleep(3000);

        //çıkan seçeneklerden full stack java developer seçeneğine tıklayatım

        List<WebElement> javaDeveloperListesi = driver.findElements(By.linkText("Full Stack Java Developer"));
        /*
            linktext'i Full Stack Java Developer olan bütün webelementleri javaDeveloperListesi isimli liste attık.
        Web sayfası üzeinden yukarı aşağı ok tuşları ile hangi webelement tıklamak istediğim web element ise onu
        4. de bulduk. List'te index 0 dan başladığı için 3 element benim isteğim element olacaktır
         */
        javaDeveloperListesi.get(0).click();

        //başlığın Java içerdiğini test edelim
        if (driver.getTitle().contains("Java")){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //sayfada kaç tane link olduğunu konsola yazdıralım
        List<WebElement> linkler = driver.findElements(By.tagName("a"));
        /*
            Tag'ı a olan webelementlerin hepsini bir liste attık. List kullanımında birden fazla webelemente ulaşmak
        istediğimiz için findElement() methodu yerine findElements() methodunu kullanırız.
         */
        System.out.println("Sayfadaki Linklerin Sayisi : "+linkler.size());

        //sonra linkleri konsola yazdıralım
        for (WebElement w:linkler) {
            if (!w.getText().isEmpty()){
                System.out.println(w.getText());
            }
        }
        /*
        Bir webelementin sahip olduğu text'i yazdırmak isterseniz getText() methodunu kullanmamız gerekir
         */

        //Lambda ile ;
        linkler.forEach(t-> System.out.println(t.getText()));
        linkler.forEach(link->{if(!link.getText().isEmpty()){System.out.println(link.getText());}});

        //sayfayı kapatınız
        driver.close();



    }


}
