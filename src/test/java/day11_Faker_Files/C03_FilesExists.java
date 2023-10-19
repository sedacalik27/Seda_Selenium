package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FilesExists {
    @Test
    public void test01() {
        /*
        Bilgisayarımızdaki bir dosyanın varlığını test edebilmemiz için;
            1-Öncelikle dosyanın yolunu almamız gerekir(Dosya üzerine sağ klik yapıp yol olarak kopyala seçeneği ile
            dosyanın yolunu kopyalayabiliriz. Windows'un alt sürümlerinde sağ klik yaptığınızda yol olarak kopyala
            seçeneği çıkmıyor ise shift tuşuna basılı olarak sağ klik yaparsanız yol olarak kopyala seçeneği çıkar)
            2-Files.exists(Paths.get(dosyaYolu)) Files class'ından exists() methodu ile dosya yolunun
            varlığını test edebiliriz. Yukarıdaki kod bize true veya false döner. Dolayısıyla
            bu kodu direk Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))) şeklinde yazarak
            dosya varsa testim passed yoksa failed olur
         */
        //MasaÜstünde bir dosya oluşturalım
        //dosyanın üzerindeyken shift sag tıklayında yol olarak kopyala çıkıyor aşagıdakini öyle aldık.
        String dosyaYolu="C:\\Users\\SEDA\\Desktop\\B171.txt";


        ////Ve bu dosyanın varlığını doğrulayalım

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }


    @Test
    public void test02() {
        /*
    Ortak çalışmalarda bir server üzerinden bir dosya yolu almak istersek, her kullanıcının bilgisayarının
ana yolu farklı olabilir ve server daki dosyanın yolu ortaktır. Dolayısıyla System.getProperty(user.home)
methodu ile bilgisayarımızın ana yolunu alabilir, server daki ortak yol ile bunu birleştirip dosyanın yolunu
dinamik olarak alabiliriz
 */
        //Test01 methodundaki gibi dosyanın yolunu dogrulayalım
        System.out.println(System.getProperty("user.home"));
        String farkliYol=System.getProperty("user.home");//-->Herkeste farkli olan yol
        //"C:\\Users\\SEDA\\Desktop\\B171.txt"
        String ortakYol="/Desktop/B171.txt";//-->Server'daki dosyanin yolu
        String dosyaYolu = farkliYol+ortakYol;//-->Bu şekilde dosyanın yolunu aldık
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));





    }
}
