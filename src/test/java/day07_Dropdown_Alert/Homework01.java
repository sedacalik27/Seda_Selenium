package day07_Dropdown_Alert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Homework01 extends TestBase {
    /*




1.http://zero.webappsecurity.com/ Adresine gidin
2.Sign in butonuna basin
3.Login kutusuna “username” yazin
4.Password kutusuna “password.” yazin
5.Sign in tusuna basin(not: navigate.Back yapınız)
6.Pay Bills sayfasina gidin
7.“Purchase Foreign Currency” tusuna basin
8.“Currency” drop down menusunden Eurozone’u secin
9.“amount” kutusuna bir sayi girin
10.“US Dollars” in secilmedigini test edin
11.“Selected currency” butonunu secin
12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
     */







    @Test
    public void test01() {


        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //1.yol
        selectIndex(xpathElementOlustur("//select"), 1);
        Select select = new Select(xpathElementOlustur("//select"));
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(1);

        //2. yol
        //WebElement option1Element = driver.findElement(By.xpath("//select"));
        //Select select2 = new Select(option1Element);
        //select2.selectByIndex(1);
        //String seciliOlan = select2.getFirstSelectedOption().getText();
        //System.out.println(seciliOlan);


        //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        selectValue(xpathElementOlustur("//select"), "2");
        System.out.println(select.getFirstSelectedOption().getText());

        //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        visibleText(xpathElementOlustur("//select"), "Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //    4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> list = xpathElementListOlustur("//select");
        for (int i = 0; i < list.size(); i++) {
            list.get(i).getText();
        }

        //    5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse false yazdırın.
        WebElement element1 = driver.findElement(By.xpath("//select"));
        element1.getSize().toString();
        boolean result = list.size() == 4;
        System.out.println(result);

    }

    public void selectValue(WebElement webElement, String number) {
    }

    private void visibleText(WebElement webElement, String s) {
    }


}
