import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Dvorovenko.DI on 20.07.2017.
 */
public class Live_or_SZZ_Zone {
    public static XWPFDocument go(XWPFDocument doc, int zone){
        // Загрязняющие вещества с номеров в виде ключа
        HashMap<Integer, String> mapEmission = HelpModule.map();

        // Отурыть файл записи
        if (zone == 2) {
            HelpModule.createParag(doc, 0, "Расчетные максимальные приземные концентрации загрязняющих веществ с учетом фонового загрязнения на территории жилой застройки не превысят гигиенических нормативов и составят:");
        }
        if (zone == 3) {
            HelpModule.createParag(doc, 0, "Расчетные максимальные приземные концентрации загрязняющих веществ с учетом фонового загрязнения на границе ориентировочной СЗЗ не превысят гигиенических нормативов и составят:");
        }
        try{

            // открыть файл эксель и прочитать ячейку
            Workbook excel = new XSSFWorkbook("D:\\1\\tbl3_5.xlsx");
            // число чтобы выполнить вывод текста "Группа сумации" один раз
            int a = 0;
            // проходит циклом по ячекам с 13 строки  2го столбца
            for (int i = 8; i < 100; i++) {
                String cellStringValue = excel.getSheetAt(0).getRow(i).getCell(zone).getStringCellValue();
                String[] s = cellStringValue.split("/");
                String s1 = s[0];
                // замена скобок на пробел, поискать лучший вариант. ДОлжен быть
                String s2 = s1.replaceAll("\\(", " ").replaceAll("\\)", " ");

                //Разбиение на две цифры и сравнение их и 0,1
                String[] stringCurrentNumber = s2.split(" ");
                //Конечная строка записи в файл
                String stringInDocx = null;
                // Числовое значение суммы выбросов хагрязняющего вещества
                int numbEmiss = 0;
                // Если нету значения в скобках то выбросит исключение
                // если сравниваеться пустая ячека с 0,1 выбюросит исключение
                try{
                    if (Double.parseDouble(stringCurrentNumber[0]) > 0.1){

                        try{
                            numbEmiss = Integer.parseInt(excel.getSheetAt(0).getRow(i).getCell(0).getStringCellValue().replace(" ", ""));
                            if (Integer.toString(numbEmiss).length() > 4){
                                for ( ; a <1 ; a++) {
                                    // Если группа сумации то вывести надпись групп сумации
                                    HelpModule.inputInTable(doc, "Группы суммации:", "");
                                }
                            }
                        }catch (NumberFormatException e ){
                            System.out.println("НЕ правильная цифра номера выбросов");
                        }
                        HelpModule.inputInTable(doc, mapEmission.get(numbEmiss), stringCurrentNumber[0] + " ПДК (вклад объекта " +  stringCurrentNumber[1] + " ПДК)");
                    }
                }catch (ArrayIndexOutOfBoundsException e1){
                    System.out.println("нету скобок");
                    if (numbEmiss == 2908){
                        HelpModule.inputInTable(doc, "Пыль неорганическая ", "");
                    }
                    HelpModule.inputInTable(doc, mapEmission.get(numbEmiss), stringCurrentNumber[0] + " ПДК");

                }catch (NumberFormatException e ){
                    System.out.println("пустая строка сравнивается с 0,1");
                }
            }

        }catch (FileNotFoundException e ){
            System.out.println("No file");

        }
        catch (Exception e){
            System.out.println("eror");
            e.printStackTrace();
        }

        // запись параграфов с текстом
        if (zone == 3) {
            HelpModule.createParag(doc, 0,"По остальным загрязняющим веществам приземные концентрации ниже 0,1 ПДК.");
            HelpModule.createParag(doc, 0,"Перечень источников, дающих наибольшие вклады в уровень загрязнения атмосферы и расчетные максимальные приземные концентрации загрязняющих веществ в жилой зоне и на границе СЗЗ приведены в таблице 5.3-4.");
        }

        // Запись файла docx на диск
        return doc;
    }
}

