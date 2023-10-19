package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       //https://www.google.com/ adresine gidin
        driver.get("//www.google.com/");

       //cookies uyarisini kabul ederek kapatin

       //Sayfa basliginin “Google” ifadesi icerdigini test edin

        if(driver.getTitle().contains("Google")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

       // Arama cubuguna “Nutella” yazip aratin

        driver.findElement(By.id("APjFqb")).sendKeys("Nutella", Keys.ENTER);

       // Bulunan sonuc sayisini yazdirin

        WebElement nutellaResult= driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(nutellaResult.getText());
        System.out.println("sonuc sayisi: " + nutellaResult.getText().split(" ")[1]);


        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonuc=(nutellaResult.getText().split(" ")[1]).replace(".","");

        int sonuc1= Integer.parseInt(sonuc);

        if(sonuc1>10000000){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        //Sayfayi kapatin
        driver.close();



    }
}
