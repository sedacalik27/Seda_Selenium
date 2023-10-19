package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework01 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();

        driver.manage().window().fullscreen();

        // 1.Amazon sayfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.navigate().refresh();


        // 2.Sayfa basligini(title) yazdirin
        String title= driver.getTitle();
        System.out.println("Sayfa Başlıgı:  = " + title);


        // 3.Sayfa basliginin "Amazon" icerdigini test edin
        String istenenBaslik= "Amazon";
        if(title.contains(istenenBaslik)){
            System.out.println("istenenBaslik :"+ "içeriyor (Test PASSED");
        }else {
            System.out.println("istenenBaslik :"+ "içeriyor (Test PASSED)");
        }

        // 4.Sayfa adresini(url) yazdirin
            String currentURL= driver.getCurrentUrl();
        System.out.println("Site URL'İ :"+ currentURL);


        // 5.Sayfa url'inin "amazon" icerdigini test edin.
        if(currentURL.contains("amazon")){
            System.out.println("amazon içeriyormu : Test Passed");
        }else{
            System.out.println("amazon içermiyorsa: Test failed");
        }


        // 6.Sayfa handle degerini yazdirin
        String amazonHandle = driver.getWindowHandle();
        System.out.println("amazonHandle = " + amazonHandle);

        // 7.Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin
        String amazonHtmlCodlari = driver.getPageSource();

        if (amazonHtmlCodlari.contains("Gateway")) {
            System.out.println("Gateway iceriyor. (TEST PASSED)");
        } else System.out.println("Gateway icermiyor. (TEST FAILED)");


        // 8.Sayfayi kapatin.
        driver.close();
    }
}
