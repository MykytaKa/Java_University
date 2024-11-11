package org.example.lab_5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.lab_5.model.Person;
import org.example.lab_5.view.PersonEditDialogController;
import org.example.lab_5.view.PersonOverviewController;

import java.io.IOException;
public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public MainApp(){
        //Як зразок додаємо деякі дані
        personData.add(new Person("Петро","П'яточкін"));
        personData.add(new Person("Іван","Зайців"));
        personData.add(new Person("Катерина","Васильченка"));
        personData.add(new Person("Ольга","Жук"));
        personData.add(new Person("Людміла","Алексєєва"));
        personData.add(new Person("Даніл","Кац"));
        personData.add(new Person("Євген","Васнецов"));
        personData.add(new Person("Дмитро","Жуликів"));
        personData.add(new Person("Мрат","Алібов"));
        personData.add(new Person("Martin","Mueller"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("StudentGroupApp");
        initRootLayout();
        showPersonOverview();
    }
    /**
     * Ініціалізує кореневий макет.
     */
    public void initRootLayout(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        // Завантажуємо кореневий макет з файлу fxml.
        fxmlLoader.setLocation(getClass().getResource("/org/example/lab_5/RootLayout.fxml"));
        try {
            rootLayout = (BorderPane) fxmlLoader.load();
            //Відображаємо сцену, яка містить кореневий макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Показує у кореневому макеті відомості про студентів.
     */
    public void showPersonOverview(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        // Завантажуємо відомості про студентів.
        fxmlLoader.setLocation(MainApp.class.getResource("/org/example/lab_5/PersonOverview.fxml"));
        try {
            AnchorPane personOverview = (AnchorPane) fxmlLoader.load();
            PersonOverviewController controller = fxmlLoader.getController();
            controller.setMainApp(this);
            // Поміщаємо відомості про студентів до центру кореневого макета.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Повертає головну сцену.
     * @return
     */
    public Stage getPrimaryStage(){
        return primaryStage;
    }

    /**
     * Відкриває діалогове вікно зміни даних зазначеного студента.
     * Якщо користувач натиснув OK, то зміни зберігаються у наданому
     * об'єкт студента і повертається значення true.
     *
     * @param person – об'єкт студента, який треба змінити
     * @return true, якщо користувач натиснув OK, інакше false.
     */
    public boolean showPersonEditDialog(Person person) {
        try{
            // Завантажуємо файл fxml і створюємо нову сцену для діалогового вікна.
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("/org/example/lab_5/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            // Створюємо діалогове вікно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            // Передаємо студента до контролера.
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);
            // Відображаємо діалогове вікно та чекаємо, поки користувач його не закриє
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

