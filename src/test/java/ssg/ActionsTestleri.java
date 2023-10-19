package ssg;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsTestleri extends TestBase {

    //actionda method zinciri bittikten sonra build kullanabiliriz.
    //actionla işimiz bitince perform yazmayı unutma


    @Test
    public void moveToElement() {
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");

        WebElement menu1 = driver.findElement(By.id("ui-id-3"));
        WebElement menu2 = driver.findElement(By.id("ui-id-4"));
        WebElement menu3 = driver.findElement(By.id("ui-id-5"));

        Actions actions = new Actions(driver);
        actions.moveToElement(menu1).perform();
        bekle(1);
        actions.moveToElement(menu2).perform();
        bekle(1);
        actions.click(menu3).perform();

    }


    @Test
    public void contextClick() {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement hotSpot = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(hotSpot).perform();

        driver.switchTo().alert().accept();

    }

    @Test
    public void dragAndDrop() {
        driver.get("https://demoqa.com/droppable");

        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement, dropElement).perform();

    }



    //keydown basılı tut demek
    //keyup bırak



    @Test
    public void dragAndDropBy() {
        driver.get("https://demoqa.com/resizable");

        WebElement tutamac = driver.findElement(By.xpath("(//span[@class='react-resizable-handle react-resizable-handle-se'])[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(tutamac, 100, 50).perform();

    }

    @Test
    public void keyDownVeKeyUp() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement baslik = driver.findElement(By.tagName("h3"));
        //baslik.sendKeys(Keys.chord(Keys.CONTROL, "c"), "adsasdasd");
        //böylede yapabilirz fakat actions kullanmak daha iyi

        Actions actions = new Actions(driver);
        actions
                .doubleClick(baslik)
                .click(baslik)
                .keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        driver.switchTo().frame(0);

        WebElement paragraf = driver.findElement(By.tagName("p"));
        paragraf.clear();

        actions
                .click(paragraf)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

    }

}
