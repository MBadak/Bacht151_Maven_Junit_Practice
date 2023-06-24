package day08_practice;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files {



    @Test
    public void test01() {

        // Masa üstünde bir text.txt dosyasi olusturunuz

        //Masaustunde text.txt dosyasinin olup olmadigini test ediniz

                //  "C:\Users\M\Desktop\day08_practice.txt"

      //  Assert.assertTrue(Files.exists(Paths.get("C:/Users/M/Desktop/day08_practice.txt")));

        // dinamik hale getirelim

        //     "C:\Users\BURAK              \Desktop\Batch151.txt"

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "/Desktop/day08_practice.txt";

        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
