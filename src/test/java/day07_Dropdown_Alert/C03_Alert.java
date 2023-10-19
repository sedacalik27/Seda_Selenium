package day07_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_Alert extends TestBase {

    /*
        alert= sayfaya gittiniz sayfayı açtınız buton var clik yaptınız uyarı msj ı geldi..
         bu uyarı penceresi üzerindeku ok butonunu handle edebiliyorsanız buna html alert denir.bunu locate edip clik yapabilirsiniz
        ama bu pencereyi locate edemiyor iseniz bu java script alert tür...bu çıktığı zaman sizin driverınızı bu pencereye taşımalisiniz..
         */
            /*
            Eğer bir sayfadaki butona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan uyarı penceresine sağ klik
        yapamıyorsak (incele/inspect) bu tür uyarı pencerelerine js Alert denir. Bu uyarı penceresini handle edemediğimiz
        için driver'i bu pencereye geçiş yaptırmamız gerekir. Bunun içinde switchTo() methodu kullanılır.
        driver.swichTo().alert() methoduyla alert'e geçiş yaparız. Ve alert onaylamak için accept(), iptal etmek için
        dismiss(), alert üzerindeki yazıyı almak için getText() ve alertteki mesaj kutusuna bir text göndermek için
        sendKeys() methodunu kullanırız.
 */


    /*
          https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
          Bir metod olusturun: acceptAlert
          1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
          Bir metod olusturun: dismissAlert
          2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
          "successfuly" icermedigini test edin.
          Bir metod olusturun: sendKeysAlert
          3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
          tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

 */

    @Test
    public void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //1. butona tıklayın, uyarıdaki(alert) OK butonuna tıklayın ve result mesajının
        // "You successfully clicked an alert" oldugunu test edin.
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();
        bekle(2);
        driver.switchTo().alert().accept();//-->alerte geçiş yap ve onayla

        String resultMassage=driver.findElement(By.xpath("(//p)[2]")).getText();
        String exceptedMassage= "You successfully clicked an alert";
        bekle(2);
        Assert.assertEquals(exceptedMassage,resultMassage);

    }

    @Test
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
       // "successfuly" icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();

        driver.switchTo().  //--> gecis methodu
                alert().    //--> Js Alerte gecis yapar
                dismiss();  //--> Cancel
        bekle(2);

        String resultMassage= driver.findElement(By.xpath("(//p)[2]")).getText();
        String unexpectedMassage= "successfuly";
        Assert.assertFalse(resultMassage.contains(unexpectedMassage));
    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.


       driver.findElement(By.xpath("(//button)[3]")).click();
       bekle(2);
       driver.switchTo().alert().sendKeys("Seda");
       bekle(2);
       driver.switchTo().alert().accept();//-->ok butonuna basıyoruz bu kodla Keys.ENTER gibi
       String resultMassage= driver.findElement(By.xpath("(//p)[2]")).getText();
       String expectedMassage="Seda";
       Assert.assertTrue(resultMassage.contains(expectedMassage));





    }


}
