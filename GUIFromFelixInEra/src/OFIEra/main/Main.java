package OFIEra.main;

        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;
/*Основной перенос:
* Эра: Если открывалось что либо короме инвентаризации в Эре то необходимо перезайти в Эру полностью
 * Нажать F7 и установить галочку "Признак неорганизоанного" и нажать ОТМЕНА
 * оставить курсор в "№ ИВ" необходимого источника
 *
 * Felix: Должно быть выбрано "Автоматическое раскрывать группы", кнопка рядом с "Расчет"
 * Открыть необходимый источник и открыть все Автосамосвалы.
 * в Исходных данных и Результатах расчета один раз выбрать колонку со значениями, чтобы
 *
 *
 * Корректировка:
 * Эра: встать в г/с (на Пыление у Авто)
 *
 * Felix: встать в название техники
*
 */


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("OFIEra"); // name window
        Scene scene = new Scene(root, 490, 350);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // not rubber
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

