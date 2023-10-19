package ssg;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class XPath extends TestBase {

    @Test
    public void xpathTesti() {
        // XPath Basics
        driver.findElement(By.xpath("//*[@id='id1']"));
        driver.findElement(By.xpath("//p[@id='id1']"));
        driver.findElement(By.xpath("//p[@name='name1']"));
        driver.findElement(By.xpath("//p[@value='value1']"));
        driver.findElement(By.xpath("//p[@class='class1']"));

        // and / or
        driver.findElement(By.xpath("//p[@name='a' and @id='a']"));
        driver.findElements(By.xpath("//p[@name='a' or @id='a']"));

        // text()
        driver.findElements(By.xpath("//p[text()='unique id']"));

        // Parent - Child
        driver.findElements(By.xpath("//div[@id='divA']/*"));
        driver.findElements(By.xpath("//div[@id='divA']/input"));
        driver.findElements(By.xpath("//div[@id='divA']/input[@type='text']"));
        driver.findElements(By.xpath("//div[@id='divC']//input"));

        // Index
        driver.findElements(By.xpath("//p[@name='a'][2]"));

        // Absolute Path
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/div[1]/label"));

        // contains()
        driver.findElement(By.xpath("//p[contains(text(),'logged in')]"));
        driver.findElement(By.xpath("//p[contains(@id,'random')]"));

        // last()
        driver.findElement(By.xpath("(//label[@id='lable'])[last()]"));

    }
}
