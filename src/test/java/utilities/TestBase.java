package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {

    protected  ExtentReports extentReport;//-->raporlamayı başlatır
    protected  ExtentHtmlReporter extentHtmlReporter;//-->Html formatında rapor oluşturur
    protected  ExtentTest extentTest;//--> Test adınlarına eklemek istediğimiz bilgileri bu class ile oluştururuz
    /*
   TestBase class'ından obje oluşturmanın önüne geçmek için bu class'ı abstract yapabiliriz.
TestBase testBase = new TestBase(); yani bu şekilde obje oluşturmanın önüne geçmiş oluruz.
Bu class'a extends yaptığımız test class'larından ulaşabiliriz
*/
    protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }

    //HARD WAIT
    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Select VisibleText DDM
    public void selectVisible(WebElement ddm,String option){
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    //Select Index DDM
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //Select Value ddm
    public void selectByValue(WebElement ddm,String text){
        Select select= new Select(ddm);
        select.selectByValue(text);
    }







    //xpath locate etme

    public WebElement xpathElementOlustur(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> xpathElementListOlustur(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    //css selector
    public WebElement cssElementOlustur(String cssSelector){
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public List<WebElement> cssElementListOlustur(String cssSelector){
        List<WebElement> liste = driver.findElements(By.cssSelector(cssSelector));
        return liste;
    }

    //Window Handles
    public void window(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }



    //iframe index
    public void frameIndex(int index){
        driver.switchTo().frame(index);
    }




    //UploadFile Robot Class
    public void uploadFilePath(String dosyaYolu) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }


    //ScreenShot
    public void ekranResmi() {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/ekranGoruntusu/screenShot"+tarih+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WebElement ScreenShot
    public void webElementResmi(WebElement element){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/webElementEkranGoruntusu/WEscreenShot"+tarih+".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //Extent Report
    public void rapor(String browser,String reportName){
        extentReport = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/extentReport/report"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReport.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler
        extentReport.setSystemInfo("Tester","Erol");
        extentReport.setSystemInfo("browser",browser);
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");
        extentHtmlReporter.config().setReportName(reportName);
    }


    //JS Click Method
    public void jsclick(WebElement element){
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",element);
        }

    }




    //JS scrollTo Element
    public void jsScroll(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    //JS scrollToEnd
    public void jsScrollEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    //JS scrollToHome
    public void jsScrollHome(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }



    //JS SendKeys()
    public void jsSendKeys(WebElement element,String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+value+"'",element);
    }





    //Tüm Sayfa Resmi (ScreenShot)
    public void tumSayfaResmi() {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    //Selenium Wait/Explicit Wait
    //visibilityOf(element) methodu
    public void visibleWait(WebElement element, int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //visibilityOfElementLocated(locator) methodu
    public void visibleWait(By locator, int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //AlertWait methodu
    public void alertWait(int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //FluentWait visible Methodu
    public void visibleFluentWait(WebElement element, int saniye, int milisaniye) {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(saniye)).
                pollingEvery(Duration.ofMillis(milisaniye)).
                until(ExpectedConditions.visibilityOf(element));
    }


    //AcceptAlert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //DismissAlert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //getTextAlert
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    //sendKeysAlert
    public void sendKeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    public void selectVisibleText(WebElement ddm, String text) {
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    //DropDown Index
    public void selectIndex1(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public void selectValue(WebElement ddm, String value) {
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    //SwitchTo Window-1
    public void switchToWindow(int index) {
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(index));
    }

    //SwitchTo Window-2
    public void switchWindow(int index) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }





















}
