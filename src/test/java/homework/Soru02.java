package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Soru02 extends TestBase {


    @Test
    public void test01() {


        //-Amazon sayfasına gidelim
        driver.get("https://www.amazon.com.tr/");

        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        List<WebElement> aramaKutusuListesi = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));

        for (int i = 0; i < aramaKutusuListesi.size(); i++) {
            System.out.println(aramaKutusuListesi.get(i).getText());
        }

        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        // başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        //Select select;//selecti buraya da yapabiliriz
        for (int i = 1; i < 6; i++) {
            ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
            Select select = new Select(ddm);
            select.selectByIndex(i);
            driver.findElement(By.id("nav-search-submit-button")).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();

        }


    }

    @Test
    public void test02() {//2.yol
        //-Amazon sayfasına gidelim
        driver.get("https://www.amazon.com.tr/");

        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        List<WebElement> aramaKutusuListesi = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        String s = "";
        for (int i = 0; i < aramaKutusuListesi.size(); i++) {

            s = s + aramaKutusuListesi.get(i).getText();
        }
        System.out.println(s);

    }

    @Test
    public void test03hocacozomu() throws InterruptedException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Dropdown menuyu yazdıralım
        Select select = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
        for (WebElement w : select.getOptions()) {
            System.out.println(w.getText());
        }
        System.out.println("***********************************************");

        //Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip başlık altındakileri aratalım.
        //Her aramada sayfa başlığını yazdıralım
        int sayac = 1;
        for (WebElement w : select.getOptions()) {
            Select option = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
            option.selectByIndex(sayac);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            sayac++;
            if (sayac >= 6) {
                break;
            }
        }
    }
}
