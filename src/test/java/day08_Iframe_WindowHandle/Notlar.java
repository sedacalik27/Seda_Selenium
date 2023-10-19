package day08_Iframe_WindowHandle;

public class Notlar {
    /*
        ifarme    bir sayfa içine başka bir html koduyla yerleştirilen link..
        bir sayfa içindeki linkin locate ini alacak  olursak eger bunun tag'ı da iframe ise nosuch exeption hatası olarız
        bunun için driver ı o html tag ına geçirmeliyiz. switch to methodu ile ifarme ye geçmenin 3 yolu var
            index ile= driver.switchTo().frame(index of the iframe)
            id veya name ile =index ile= driver.switchTo().frame(id of the iframe )
            webelement ile= index ile= driver.switchTo().frame(webelement of the iframe)
        (bir sayfada kaçtane ifarme olduğunu nasıl görürüz kaynak kodlarının arama kısmına //ifarme yazarsak kac tane olduğunu görürüz)
        bir sayfada birden fazla link olabilir yani iframe olabilir.iç ice iframe olabilir bunlar arası geçir için ;
        driver.switchto()parentFrame() 1 üstteki seviye deki frame ye cıkartır
        drver.switchTo().defaultContent(); en üstteki frame e cıkmak için kullanılır.
        driver.navigate.refresh() methodu da sayfayı yenileyeceği için yine anasayfaya döner.
        bir sayfa içinde bir frame var bunun içinde de 50 syfalık form var..hepsini doldurdunuz..sonra üst frame geçip
        tekrar form sayfasına dönmeniz gerekirse. defaultContent() bunu yapar..ama refresh yaparsanız doldurduğunuz form silinir.
        bu yüzden refresh sayfayı yenilediği için içindeki frame silinir..bu yüzden eğer refresh kullanacaksak dikkat etmeliyiz.
         */


     /* driver e 3 komut verdim.
        ey driver get ile su sayfaya git
        ey driver yeni sayfa aç oraya git
        ey drive yeni sekmede yeni sayfa ac..(son olarak driver sekmede)
        ben driver i ilk sayfaya göndrmek istersem ilk sayfanın window handle değerini kullanmam gerekir
         bu değeri alıp; driver 3. pencerede iken driverı ilk pencereye  geçis yaptırırız nasıl;
            --1,yol--
          (driver.switchTo.Window("birinci pencerenin handle değeri"))

         */


    /*
    Alertler onay kutuları evet/hayır kabul ediyor musunuz gibi
    iframe de sayfanın içinde açılan pencereler
    Bu tamamen ana sayfa da tıklayınca login bölümlerinin açılması gibi

     */
}
