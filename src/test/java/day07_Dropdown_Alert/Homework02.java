package day07_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Homework02 extends TestBase {
    //https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidelim
    //programming languages ddm den istediğiniz 4 seçeneği seçiniz
    //sadece seçili olan option'ları yani seçenekleri yazdıralim
    //Seçeneklerden 4 tane seçtiğimizi doğrulayalım
    //Seçtiğimiz seçeneklerden ilkini yazdıralım, ilk seçeneğin Java olduğunu doğrulayalım
    //Seçtiğimiz seçeneklerin hepsini kaldıralim
    //visibleText olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim


    @Test
    public void test01() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement java= driver.findElement(By.xpath("//*[@value='java']"));

    }

    @Test
    public void test02() {
        //      1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com");

        //      2.Sign in butonuna basin
        driver.findElement(By.xpath("//button")).click();
        bekle(1);

        //      3.Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@type='text' and @id='user_login']")).sendKeys("username");
        bekle(1);

        //      4.Password kutusuna “password” yazin
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        bekle(1);

        //      5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        bekle(2);
        driver.navigate().back();
        driver.navigate().back();

        //6.Pay Bills sayfasina gidin
        //online banking
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        bekle(1);
        //pay Bills
        driver.findElement(By.xpath("(//span)[4]")).click();

        //      7.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//a)[17]")).click();

        //      8.“Currency” drop down menusunden Eurozone’u secin
        WebElement dropElement = driver.findElement(By.xpath("//select[@id='pc_currency'] "));
        Select select1 = new Select(dropElement);
        select1.selectByVisibleText("Eurozone (euro)");

        //      9.“amount” kutusuna bir sayi girin
        WebElement amountElement = driver.findElement(By.xpath("(//input)[6]"));amountElement.sendKeys("99");

        //      10.“US Dollars” in secilmedigini test edin
        WebElement usDolarElement = driver.findElement(By.xpath("(//input)[7]"));
        boolean result1 = usDolarElement.isSelected();
        Assert.assertFalse(result1);

        //      11.“Selected currency” butonunu secin
        driver.findElement(By.xpath("//input[@type='radio' and @id='pc_inDollars_false']")).click();

        //      12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("(//input)[9]")).click();
        bekle(2);
        driver.findElement(By.xpath("(//input)[10]")).click();

        //      “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        String actualResult = driver.findElement(By.xpath("//*[@id='alert_content']")).getText();
        String expectedResult = "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(expectedResult,actualResult);

    }
















}





