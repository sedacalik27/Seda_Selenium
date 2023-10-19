package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class SelectTesti extends TestBase {
    //https://letcode.in/dropdowns adresine gidin.
    //Meyveler menüsünün tıklanabilir olduğunu doğrulayın.
    //Meyveler menüsünden Apple seçeneğini görünen metin ile seçin.
    //Seçilen seçeneğin Apple olduğunu doğrulayın.
    //Menüde seçilen seçeneği yazdırın.

    @Test
    public void dropDownTesti01() {
        // LetCode sitesine git
        driver.get("https://letcode.in/dropdowns");

        // Meyveler menüsünün tıklanabilir olduğunu doğrula
         WebElement meyveler= driver.findElement(By.id("fruits"));
        Assert.assertTrue(meyveler.isEnabled());

        // Meyveler menüsünden Apple seçeneğini görünen metin ile seç
        Select select=new Select(meyveler);
        select.selectByVisibleText("Apple");//incele de nasıl görünüyorsa öyle al

        bekle(2);

        //Seçilen seçeneğin Apple olduğunu doğrulayın.
        //getfirstSelectedOption gelicek aklımıza en son seçili olan ne ise onu verecek
        String apple=select.getFirstSelectedOption().getText();
        Assert.assertEquals("Apple",apple);

        //Menüde seçilen seçeneği yazdırın.
        System.out.println("Menüde Seçili Olan Seçenek: "+ apple);

    }

    @Test
    public void dropDownTesti02() {
       /*
        Test Görevi - 2:
            letcode.in/dropdowns adresine gidin.
            Programlama Dilleri menüsünün tıklanabilir olduğunu doğrulayın.
            Menüdeki son seçeneği seçin.
            Seçilen seçeneğin C# olduğunu doğrulayın.
            Listede C++ seçeneğinin olmadığını doğrulayın.
            Menüdeki tüm elemanları yazdırın.
        */

        // LetCode sitesine git
        driver.get("https://letcode.in/dropdowns");

        // Programlama Dilleri menüsünün tıklanabilir olduğunu doğrula
        WebElement programlamaDilleri = driver.findElement(By.id("lang"));
        Assert.assertTrue(programlamaDilleri.isEnabled());

        // Menüdeki son seçeneği seç
        Select select = new Select(programlamaDilleri);
        List<WebElement> programlamaDilleriListesi = select.getOptions();
        select.selectByIndex(programlamaDilleriListesi.size() - 1);
        select.selectByVisibleText(programlamaDilleriListesi.get(programlamaDilleriListesi.size() - 1).getText());

        // Seçilen seçeneğin C# olduğunu doğrulayın.
        Assert.assertEquals("C#", select.getFirstSelectedOption().getText());

        // Listede C++ seçeneğinin olmadığını doğrula
        // Menüdeki tüm elemanları yazdır
        for (WebElement programlamaDili : programlamaDilleriListesi) {
            Assert.assertNotEquals("C++", programlamaDili.getText());
            System.out.println(programlamaDili.getText());
        }


    }


    @Test
    public void dropDownTesti03() {
        /*
        Test Görevi - 4:
            letcode.in/dropdowns adresine gidin.
            Kahramanlar menüsünün, çoklu seçim yapılabilen bir menü olduğunu doğrulayın.
            Kahramanlar menüsünden 3 tane kahramanı index numaraları ile seçin.
            Menüde 3 elemanın seçili olduğunu doğrulayın.
            Menüde seçili elemanların isimlerini doğrulayın.
            Seçili elemanlardan birinin seçimini kaldırın.
            Menüde 2 elemanın seçili olduğunu doğrulayın.
            Menüde seçili elemanlarının isimlerini doğrulayın.
            Seçili elemanların hepsinin seçimini kaldırın.
            Menüde hiçbir elemanın seçili olmadığını doğrulayın.
         */

        // LetCode sitesine git
        driver.get("https://letcode.in/dropdowns");

        // Kahramanlar menüsünün, çoklu seçim yapılabilen bir menü olduğunu doğrula
        WebElement kahramanlar = driver.findElement(By.id("superheros"));
        Select select = new Select(kahramanlar);
        Assert.assertTrue(select.isMultiple());

        // Kahramanlar menüsünden 3 tane kahramanı index numaraları ile seç
        select.selectByIndex(1);
        select.selectByIndex(2);
        select.selectByIndex(3);

        // Menüde seçili elemanların isimlerini doğrula
        List<WebElement> seciliKahramanlarListesi = select.getAllSelectedOptions();
        for (WebElement kahraman : seciliKahramanlarListesi) {
            Assert.assertTrue(kahraman.getText().equals("Aquaman")
                    || kahraman.getText().equals("The Avengers")
                    || kahraman.getText().equals("Batman"));
        }

        // Seçili elemanlardan birinin seçimini kaldır
        select.deselectByIndex(1);

    }

    public void selectIndex(WebElement webElement, int... indexes) {
        Select select = new Select(webElement);
        for (int index : indexes) {
            select.selectByIndex(index);
        }
    }

}
