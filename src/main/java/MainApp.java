import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.scene.Parent;
import javax.imageio.IIOException;
import javafx.scene.control.Button;
public class MainApp extends Application {

    private static final Logger logger = LogManager.getLogger(MainApp.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("KontrolerA.fxml"));
        primaryStage.setTitle("Waluty");
        primaryStage.setScene(new Scene(root,500,500));
        primaryStage.show();


    }
    @Override
    public void stop() {
        // Perform cleanup or other tasks before the application closes
        logger.info("Aplikacja kończy działanie.");
    }
}