import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Dvorovenko.DI on 20.07.2017.
 */
public class MainLiveOrSzzZoneFromTableEra {
    public static void main(String[] args) throws IOException {
        XWPFDocument doc = new XWPFDocument();

        // live zone n 3 column
        doc = Live_or_SZZ_Zone.go(doc, 2);
        // SZZ zone in 4 column
        doc = Live_or_SZZ_Zone.go(doc, 3);
        //doc = SZZ_Zone.go(doc);

        // Запись файла
        try{
            FileOutputStream fileDoc = new FileOutputStream("D:\\1\\Расчетн. приземн концентрац.docx");
            doc.write(fileDoc);
            fileDoc.close();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
