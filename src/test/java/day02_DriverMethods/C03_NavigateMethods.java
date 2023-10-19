package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        /*navigate(); methodları
        driver.navigate().to();//string olarak girilen url e gider
        driver.navigate().back();// içinde olunan sayfadan geldiği önceki sayfayı döndürür
        driver.navigate().forward();// back ile dönülen bir sayfadan tekrar ileri gider
        driver.navigate().refresh();// içinde olunan sayfayı yeniler */


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();



        //Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.navigate().to("https://www.youtube.com/");//-->Bu method get() methodu gibi girelen url'e gider
        Thread.sleep(3000);


        //Amazon sayfasina gidelim. https://www.amazon.com/

        driver.navigate().to(" https://www.amazon.com/");
        Thread.sleep(3000);


        //Tekrar YouTube'sayfasina donelim
        driver.navigate().back();
        Thread.sleep(3000);//--> Javadan gelen beklemedir.Belirttiğimiz ms kadar kodlarımızın çalışmasını bekletir.

        //Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
        Thread.sleep(3000);

        //Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        Thread.sleep(3000);

        //Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.close();
        /*
        navigate() methodları ile sayfada ileri geri yapmak isteyebiliriz
        back() ve forward() methodları ile bunu yapabiliriz.
        -bu methodları kullanırken get() yada navigate().to() methodları ile sayfaya gidebiliriz.
         */
















    }
}
