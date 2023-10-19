package ssg;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandleTestleri extends TestBase {
    @Test
    public void test01() {
        driver.get("https://letcode.in/windows");

        driver.findElement(By.id("home")).click();

        System.out.println("İlk Pencere Başlığı: " + driver.getTitle());

        String ilkPencere = driver.getWindowHandle();
        System.out.println("İlk Pencere Kodu: " + ilkPencere);

        Set<String> pencereler = driver.getWindowHandles();
        System.out.println("Tüm Pencere Kodları: " + pencereler);

        for (String pencere : pencereler){
            if (!pencere.equals(ilkPencere)){
                driver.switchTo().window(pencere);
            }
        }
        System.out.println("İkinci Pencere Başlığı: " + driver.getTitle());

        driver.switchTo().window(ilkPencere);
        System.out.println("İlk Pencere Başlığı: " + driver.getTitle());

    }

    @Test
    public void test02() {
        driver.get("https://letcode.in/windows");

        driver.findElement(By.id("home")).click();

        Set<String> pencereler = driver.getWindowHandles();
        Iterator<String> iterator = pencereler.iterator();
        String ilkPencere = iterator.next();
        String ikinciPencere = iterator.next();

        driver.switchTo().window(ikinciPencere);
        System.out.println("İkinci Pencere Başlığı: " + driver.getTitle());

        driver.switchTo().window(ilkPencere);
        System.out.println("İlk Pencere Başlığı: " + driver.getTitle());

    }

    @Test
    public void test02ninbaskayolu() {
        driver.get("https://letcode.in/windows");

        driver.findElement(By.id("home")).click();

        // Set<String> pencereler = driver.getWindowHandles();
        Iterator<String> iterator = driver.getWindowHandles().iterator();
        String ilkPencere = iterator.next();
        String ikinciPencere = iterator.next();

        driver.switchTo().window(ikinciPencere);
        System.out.println("İkinci Pencere Başlığı: " + driver.getTitle());

        driver.switchTo().window(ilkPencere);
        System.out.println("İlk Pencere Başlığı: " + driver.getTitle());

    }

    //windowtab-->yeni sekme




    @Test
    public void test03() {
        driver.get("https://letcode.in/windows");

        driver.findElement(By.id("home")).click();

//        Set<String> pencereler = driver.getWindowHandles();
        List<String> pencereListesi = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereListesi.get(1));
        System.out.println("İkinci Pencere Başlığı: " + driver.getTitle());

        driver.switchTo().window(pencereListesi.get(0));
        System.out.println("İlk Pencere Başlığı: " + driver.getTitle());

    }


    @Test
    public void fakeMailTesti() {
        driver.get("https://www.kitapyurdu.com/index.php?route=account/register");

        WebElement epostaKutusu = driver.findElement(By.id("register-email"));

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.fakemail.net/");
        WebElement fakeMailKutusu = driver.findElement(By.id("email"));
        String fakeMail = fakeMailKutusu.getText();

        List<String> pencereListesi = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(pencereListesi.get(0));
        epostaKutusu.sendKeys(fakeMail);

        driver.switchTo().window(pencereListesi.get(1));

    }

}
