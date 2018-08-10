package sample.Controll.Programs;

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
        mapEmission.put(110, "диВанадий пентоксид (пыль)");
        mapEmission.put(123, "Оксид Железа");
        mapEmission.put(143, "Марганец и его соединения");
        mapEmission.put(146, "Медь оксид (Меди оксид)");
        mapEmission.put(150, "Натрий гидроксид");
        mapEmission.put(168, "Олово оксид");
        mapEmission.put(184, "Свинец и его неорганические соединения");
        mapEmission.put(203, "Хром");
        mapEmission.put(301, "Азот диоксид");
        mapEmission.put(304, "Азот оксид");
        mapEmission.put(322, "Кислота серная");
        mapEmission.put(328, "Углерод сажа");
        mapEmission.put(330, "Сера диоксид");
        mapEmission.put(333, "Сероводород");
        mapEmission.put(337, "Углерод оксид");
        mapEmission.put(342, "Фтористые");
        mapEmission.put(344, "Фториды");
        mapEmission.put(415, "Смесь предельных углеводородов С1H4-С5H12");
        mapEmission.put(416, "Смесь предельных углеводородов C6H14-С10H22");
        mapEmission.put(501, "Пентилены (амилены - смесь изомеров)");
        mapEmission.put(602, "Бензол");
        mapEmission.put(616, "Диметилбензол (Ксилол)");
        mapEmission.put(621, "Метилбензол (Толуол)");
        mapEmission.put(627, "Этилбензол");
        mapEmission.put(703, "Бенз/а/пирен (3,4-Бензпирен)");
        mapEmission.put(908, "1-Метокси 2-Фторбензол");
        mapEmission.put(1042, "Бутан-1-ол (Спирт н-бутиловый)");
        mapEmission.put(1048, "2-Метилпропан-1-ол (Спирт изобутиловый)");
        mapEmission.put(1061, "Этанол (Спирт этиловый)");
        mapEmission.put(1119, "2-Этоксиэтанол");
        mapEmission.put(1210, "Бутилацетат");
        mapEmission.put(1401, "Пропан-2-он (Ацетон)");
        mapEmission.put(2704, "Бензин (нефтяной, малосернистый)");
        mapEmission.put(2732, "Керосин");
        mapEmission.put(2735, "Масло минеральное нефтяное");
        mapEmission.put(2752, "Уайт-спирит");
        mapEmission.put(2754, "Алканы С12-С19");
        mapEmission.put(2868, "Эмульсол");
        mapEmission.put(2908, "содержание SiО2 70-20%");
        mapEmission.put(2909, "Пыль неорганическая: ниже 20% двуокиси кремния");
        mapEmission.put(2930, "Пыль абразивная");
        mapEmission.put(2978, "Пыль тонко измельченного резинового вулканизата");
        mapEmission.put(3714, "Зола углей Подмосковного");
        mapEmission.put(3749, "Пыль каменного угля");
        mapEmission.put(110110, "диВанадий пентоксид+Сера диоксид");
        mapEmission.put(270184, "Свинец и его неорганические соединения+Сера диоксид");
        mapEmission.put(280322, "Кислота серная+Сера диоксид");
        mapEmission.put(310301, "Азота диоксид+Сера диоксид");
        mapEmission.put(300330, "Сера диоксид+Сероводород");
        mapEmission.put(350330, "Сера диоксид+Фтористые");
        mapEmission.put(520110, "диВанадий пентоксид+Марганец");
        mapEmission.put(560342, "Фтористые+Фториды");
        return mapEmission;
    }
}
