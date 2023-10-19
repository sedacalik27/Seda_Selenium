package ssg;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class CssSelector extends TestBase {
    @Test
    public void cssSelectorSetleri() {
        // Css Seletor Basics
        driver.findElement(By.cssSelector("#id1"));
        driver.findElement(By.cssSelector("p#id1"));
        driver.findElement(By.cssSelector(".class1"));
        driver.findElement(By.cssSelector("p.class1"));
        driver.findElement(By.cssSelector("[id=id1]"));
        driver.findElement(By.cssSelector("p[id=id1]"));

        // And
        driver.findElement(By.cssSelector("p[name=a][id=a]"));

        // Parent Child
        driver.findElement(By.cssSelector("div[id='div1']>label[id=label]"));
        driver.findElement(By.cssSelector("div[id='div3'] label[id=label]")); // Torun

        // Contains
        driver.findElement(By.cssSelector("p[id*='Class_AZ']"));

        // Index
        driver.findElement(By.cssSelector("div[id='Index']>b:first-of-type"));


    }
}
