package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       //1.“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        //3. Password kutusuna “secret_sauce” yazdirin
        //4. Login tusuna basin

        driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("standard_user", Keys.TAB,"secret_sauce",Keys.TAB, Keys.ENTER);



       //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
       WebElement ilkurun= driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
       String ilkUrunIsmi= ilkurun.getText();
        System.out.println("ilk urun ismi:"+ ilkUrunIsmi);
        ilkurun.click();

       //6. Add to Cart butonuna basin



        driver.findElement(By.cssSelector("button[name='add-to-cart-sauce-labs-backpack']")).click();
       //7. Alisveris sepetine tiklayin
        driver.findElement(By.cssSelector("span[class='shopping_cart_badge']")).click();

       //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
       WebElement urunSepette= driver.findElement(By.cssSelector("div[class='cart_quantity'"));
       if(urunSepette.isDisplayed()){
           System.out.println("TEST PASSED");
       }else{
           System.out.println("Test Failed");
        }

       //9. Sayfayi kapatin
        driver.close();











    }
}
