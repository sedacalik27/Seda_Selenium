package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DeleteButton {
        // https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        // Add Element butonuna basin 100 kez basınız
        //Delete butonuna 90 kez basınız
        // Ve 90 kez basıldığını doğrulayınız
        WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test02() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        for (int i = 0; i < 100; i++) {
            driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();
        }
        //  List<WebElement>  list = driver.findElements(By.xpath("//*[@class='added-manually']"));
        //  list.size();
        int deleteButtonSayisi = driver.findElements(By.xpath("//*[@class='added-manually']")).size();
        for (int i = 90; i > 0; i--) {
            driver.findElement(By.xpath("//*[@class='added-manually']")).click();
        }
        int deleteButtonSayisiSon = driver.findElements(By.xpath("//*[@class='added-manually']")).size();
        boolean result = deleteButtonSayisi - deleteButtonSayisiSon == 90;
        Assert.assertTrue(result);
    }




}
