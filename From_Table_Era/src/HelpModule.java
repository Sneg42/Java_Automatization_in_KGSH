import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;

import java.util.HashMap;

/**
 * Created by Dvorovenko.DI on 20.07.2017.
 */
public class HelpModule {
    // Создание и Запись текста в таблицу с двумя ячейками
    public static void inputInTable(XWPFDocument doc, String nameEmission, String numberEmission){
        XWPFTable table = doc.createTable();
        XWPFTableRow row0 = table.getRow(0);
        XWPFTableCell cell0 = row0.getCell(0);
        cell0.removeParagraph(0);

        XWPFTableCell cell1 = row0.createCell();
        cell1.removeParagraph(0);
        // удаление всех border в таблице
        table.getCTTbl().getTblPr().unsetTblBorders();
        table.setRowBandSize(100);

// добавление в первую ячейку имени выбросов
        XWPFParagraph par = cell0.addParagraph();
        XWPFRun run = par.createRun();
        run.setFontSize(12);
        run.setFontFamily("Times new Roman");
        run.setText(nameEmission);
        par.setSpacingBetween(1.5);
        par.setSpacingAfter(0);

// добавление во вторую ячейку цифр выбросов
        XWPFParagraph par1 = cell1.addParagraph();
        XWPFRun run1 = par1.createRun();
        run1.setFontSize(12);
        run1.setFontFamily("Times new Roman");
        run1.setText(numberEmission);
        par1.setSpacingBetween(1.5);
        par1.setSpacingAfter(0);
    }
    // запись текста в следующий параграф
    // 0 - int а выделяет текст желтым
    public static void createParag(XWPFDocument doc, int a, String s){
        XWPFParagraph par = doc.createParagraph();
        par.setIndentationFirstLine(1000);
        XWPFRun run = par.createRun();
        run.setText(s);
        run.setFontSize(12);
        run.setFontFamily("Times new Roman");
        //run.setColor("009e2f");
        if (a!=0){
            run.getCTR().addNewRPr().addNewHighlight().setVal(STHighlightColor.YELLOW);
        }
        par.setSpacingBetween(1.5);
        par.setSpacingAfter(0);
    }
    // Таблица с загрязняющими веществами с номером вещества в виде ключа
    public static HashMap<Integer, String> map(){
        HashMap<Integer, String> mapEmission = new HashMap();
        mapEmission.put(123, "диЖелезо триоксид");
        mapEmission.put(143, "Марганец и его соединения");
        mapEmission.put(203, "Хром");
        mapEmission.put(301, "Азот диоксид");
        mapEmission.put(304, "Азот оксид");
        mapEmission.put(328, "Углерод сажа");
        mapEmission.put(330, "Сера диоксид");
        mapEmission.put(333, "Сероводород");
        mapEmission.put(337, "Углерод оксид");
        mapEmission.put(342, "Фтористые");
        mapEmission.put(344, "Фториды");
        mapEmission.put(908, "1-Метокси 2-Фторбензол");
        mapEmission.put(2732, "Керосин");
        mapEmission.put(2754, "Алканы С12-С19");
        mapEmission.put(2908, "содержание SiО2 70-20%");
        mapEmission.put(3749, "Пыль каменного угля");
        mapEmission.put(310301, "Азота диоксид+Сера диоксид");
        mapEmission.put(300330, "Сера диоксид+Сероводород");
        mapEmission.put(350330, "Сера диоксид+Фтористые");
        mapEmission.put(560342, "Фтористые+Фториды");
        return mapEmission;
    }
}
