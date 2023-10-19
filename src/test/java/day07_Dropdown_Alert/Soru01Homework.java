package day07_Dropdown_Alert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Soru01Homework extends TestBase {
    /*
     ●https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.
     */


    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/dropdown");


        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın


        //1.yol

        selectIndex(xpathElementOlustur("//select"),1);
        Select select1= new Select(xpathElementOlustur("//select"));
        System.out.println(select1.getFirstSelectedOption().getText());


        //2.yol
        WebElement option1Element=driver.findElement(By.xpath("//select"));
        Select select2= new Select(option1Element);
        select2.selectByIndex(1);
        String seciliOlan=select2.getFirstSelectedOption().getText();
        System.out.println(seciliOlan);


        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
















    }
}
