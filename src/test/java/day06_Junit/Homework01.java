package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework01 {
    /*
    1."https://tr.pinterest.com/" sayfasina gidelim
    2.Sign in butonuna basalim
    3.Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://tr.pinterest.com/");


    }



    @Test
    public void test01() {
        driver.findElement(By.xpath("//*[@class='tBJ dyH iFc sAJ O2T tg7 H2s']")).click();

        driver.findElement(By.xpath("(//*[@class='D8X Hsu tBJ dyH iFc sAJ L4E Bvi iyn H_e pBj qJc TKt LJB xD4 z-6'])[1]")).sendKeys("sedagmail.com", Keys.ENTER);
        boolean result=  driver.findElement(By.xpath("(//*[@class='xuA'])[8]")).isDisplayed();
        Assert.assertTrue(result);




    }


    @Test
    public void test02() {
        driver.get("https://tr.pinterest.com/");
        //2.Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class='tBJ dyH iFc sAJ O2T tg7 H2s']")).click();
       // 3.Email kutusuna @isareti olmayan bir mail yazip enter’a
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("sedagmal.com",Keys.ENTER);
        // bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        boolean uyari=driver.findElement(By.xpath("(//*[@class='xuA'])[8]")).isDisplayed();
        Assert.assertTrue(uyari);


    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
