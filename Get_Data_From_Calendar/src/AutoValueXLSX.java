
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dvorovenko.DI on 22.08.2017.
 * Создать ексель файл из календаря открытчиков. В файле будет записано имя Авто и сколько породы перевозит в год
 * В Календаре открытчиков оставить только необходимый год и сохранить в папке 1 на диске D
 * если перевозимые объемы больше, чем на отвалообразование, значит открытчики учли перевозку прочих работ экскаваторво
 *
 */
public class AutoValueXLSX {
    // create list with all different value cell in row
    public  ArrayList fillList(Workbook excel, int row) {
        String s = null;
        ArrayList<String> list = new ArrayList<>();
        // Fill all Auto in List
        for (int cell = 3; cell < 50; cell++) {
            try {
                // if in cell String
                s = excel.getSheetAt(0).getRow(row).getCell(cell).getStringCellValue();
            }// IF in cell Numerical, do it in int
            catch (IllegalStateException e) {
                s = (int) (excel.getSheetAt(0).getRow(row).getCell(cell).getNumericCellValue()) + "";
            } catch (NullPointerException e) {
                break;
            }
            // just in case, maybe del
            if (s == "") break;
            if (!list.contains(s)) list.add(s);
        }
        return list;
    }

    // fill STRING cell in row
    public void fillFileXLSX (Row row, int cell, Object o){
        Cell cell1 = row.createCell(cell);
        cell1.setCellValue(o + "");
    }

    //create table with Name Auto and Value rock in uear fron table "Календарь Производительность автосамосвалов"
    public  void createTableAutoValue() {
        Workbook excelLoad = new XSSFWorkbook();
        //create sheet in new file excel
        Sheet sheet0 = excelLoad.createSheet("Авто & Объемы");
        //Create 4 Row and fill Array for better use
        Row[] arrRow = new Row[4];
        for (int i = 0; i < arrRow.length; i++) {
            arrRow[i] = sheet0.createRow(i);
        }
        ArrayList<String> listAuto = null;
        ArrayList<String> listRock = null;
        Workbook excel = null;
        // create list with name auto and Rock
        try {
            excel = new XSSFWorkbook("D:\\1\\КАЛЕНДАРЬ.xlsx");

            listAuto = fillList(excel, 6);
            listRock = fillList(excel, 7);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < listAuto.size(); i++) {
            //fill name auto in excel
            fillFileXLSX(arrRow[0], i * 3, listAuto.get(i));
            //create map for Rock <nameRock, value for Auto>
            HashMap<String, Integer> mapValueRock = new HashMap<>();
            for (int j = 0; j < listRock.size(); j++) {
                mapValueRock.put(listRock.get(j), 0);
            }

            for (int cell = 3; cell < 26; cell++) {
                // get name auto from column
                String nameAuto = null;
                try {
                    // if in cell String
                    nameAuto = excel.getSheetAt(0).getRow(6).getCell(cell).getStringCellValue();
                }// IF in cell Numerical, do it in int
                catch (IllegalStateException e) {
                    nameAuto = (int) (excel.getSheetAt(0).getRow(6).getCell(cell).getNumericCellValue()) + "";
                } catch (NullPointerException e) {

                    break;
                }
                // create map for correct name auto with all value in year (b - value for rock)
                try {
                    if (nameAuto.equals(listAuto.get(i))) {
                        int b = (int) (excel.getSheetAt(0).getRow(74).getCell(cell).getNumericCellValue());
                        String nameRock = excel.getSheetAt(0).getRow(7).getCell(cell).getStringCellValue();
                        int value = mapValueRock.get(nameRock);
                        mapValueRock.put(nameRock, value + b);

                    }
                } catch (NullPointerException e) {
                    System.out.println("End");
                }
            }
            // fill rock an value in excel
            int j =0;
            for(Map.Entry<String, Integer> entry : mapValueRock.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                fillFileXLSX(arrRow[j], i*3+1, key);
                fillFileXLSX(arrRow[j], i*3+2, value);
                j++;
            }
        }

        try{
            FileOutputStream fileDoc = new FileOutputStream("D:\\1\\Объемы перевозимые авто в Определнные год.xlsx");
            excelLoad.write(fileDoc);
            fileDoc.close();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }


}



