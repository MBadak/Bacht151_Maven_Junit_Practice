package day09_Practice;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    // ülkeler dosyasindaki 3. satir indexin 3 sutunundaki indesinin cezayir oldigunu test eden method olusturun

    @Test
    public void test01()  {
        int satirNoIndex = 3;
        int SutunNoIndex = 3;

        banaDataGetir(satirNoIndex,  SutunNoIndex );

        String actualData  =  banaDataGetir(3,3);
        String expectedData = "Cezayir";

        Assert.assertEquals(expectedData,actualData);

    }

    public static String  banaDataGetir(int satirNoIndex, int sutunNoIndex)  {
        String dosyaYolu= "src/resources/ulkeler.xlsx";

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(dosyaYolu);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Workbook workbook= null;
        try {
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (EncryptedDocumentException e) {
            throw new RuntimeException(e);
        }

        String data= workbook.getSheet("Sayfa1").getRow(satirNoIndex).getCell(sutunNoIndex).toString();
        System.out.println(satirNoIndex+". Satir indexi ve "+sutunNoIndex+". SutunIndexsindeki Data  = " + data);

        return data;
    }
}
