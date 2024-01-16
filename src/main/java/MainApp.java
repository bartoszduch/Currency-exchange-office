import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        Image backgroundImage = new Image("file:C:\\Users\\Barte\\OneDrive\\Pulpit\\Waluty\\Waluty\\src\\main\\resources/tlo.jpg");

        // Utwórz obiekt BackgroundImage
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        // Utwórz obiekt Background z użyciem BackgroundImage
        Background backgroundFinal = new Background(background);

        Button button = new Button("Kliknij mnie");
        button.setOnAction(e -> System.out.println("Hello, JavaFX!"));

        // Utwórz kontener StackPane jako główny kontener
        StackPane root = new StackPane();

        // Ustaw tło sceny na obiekt Background
        root.setBackground(backgroundFinal);

        // Dodaj przycisk do kontenera StackPane
        root.getChildren().add(button);

        // Utwórz scenę z kontenerem StackPane
        Scene scene = new Scene(root, 800, 600);

        // Ustaw scenę
        primaryStage.setScene(scene);

        // Ustaw tytuł i pokaż scenę
        primaryStage.setTitle("Waluty");
        primaryStage.show();
    }
}
