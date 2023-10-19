package day11_Faker_Files;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_FakerTest extends TestBase {
    @Test
    public void test01() {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //"create new account"  butonuna basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        bekle(2);

        //"firstName" giris kutusuna bir isim yazin
        //"lastname" giris kutusuna bir soyisim yazin
        //"email" giris kutusuna bir email yazin
        //"email" onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        String fakeEmail = faker.internet().emailAddress();
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,fakeEmail);
        bekle(2);
        firstName.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,fakeEmail,Keys.TAB,faker.internet().password(),Keys.TAB,
                Keys.TAB,"25",Keys.TAB,"May",Keys.TAB,"2007",Keys.TAB,Keys.TAB,Keys.ARROW_RIGHT,Keys.ENTER);

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='2']")).isSelected());


    }
}
