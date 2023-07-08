package day09_Practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {
    //Ülkeler dosyasındaki "Başkent(İngilizce)" sütununu yazdıralım

    @Test
    public void test01() throws IOException {
        String dosyaYolu= "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i < sonSatir+1; i++) {

            C01_ReadExcel.banaDataGetir(i,1);  // C01 deki methodu kullandik
           // System.out.println(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());  // method kullanmadanda bu sekilde yapabilirdik
        }


    }
}
