import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.scene.control.Label;
public class MainApp extends Application {

    private static final Logger logger = LogManager.getLogger(MainApp.class);
    public static void main(String[] args) {
        launch(args);
        logger.info("Aplikacja startuje...");

        // Twój kod

        logger.info("Aplikacja zakończona.");
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello, JavaFX!");
        Scene scene = new Scene(label, 400, 200);

        // Tutaj dodaj kod inicjalizujący interfejs użytkownika JavaFX
        primaryStage.setTitle("Currency App");
        primaryStage.show();
    }
}
