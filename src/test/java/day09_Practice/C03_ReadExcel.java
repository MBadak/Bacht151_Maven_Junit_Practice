package day09_Practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {
        Map<String, String> ulkelerMap = new HashMap<>();

        Workbook workbook = WorkbookFactory.create(new File("src/resources/ulkeler.xlsx"));




        for (int i = 0; i < workbook.getSheet("Sayfa1").getLastRowNum() + 1; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + " , "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + " , "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key, value);

           // System.out.println(key + " / " + value);  alt alta yazdirmak isterseniz bunu kullanabiliriz


        }

        System.out.println(ulkelerMap);


    }

}
