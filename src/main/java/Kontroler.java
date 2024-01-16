import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

import java.io.IOException;

public class Kontroler {
    @FXML
    private Button kantor1913Button;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button clickedButton = (Button) event.getSource();
            String buttonText = clickedButton.getText();
            System.out.println("Kliknięto przycisk: " + buttonText);
        }

    }

    @FXML
    private VBox view;

    public void initialize() {
        // Inicjalizacja widoku, jeśli to konieczne
    }

    @FXML
    private void handleButtonAction(javafx.event.ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button clickedButton = (Button) event.getSource();
            String currencyName = clickedButton.getText();
            showCurrency(currencyName);
        }
    }

    public void showCurrency(String currencyName) {
        // Wczytaj odpowiedni plik FXML
        String fxmlFileName = currencyName + ".fxml";
        Node currencyNode = loadFXML(fxmlFileName);

        // Wyczyszczenie dotychczasowego widoku i dodanie nowego
        view.getChildren().clear();
        view.getChildren().add(currencyNode);
    }

    private Node loadFXML(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            // Tutaj obsłuż wyjątek, na przykład pokaż komunikat o błędzie
            return new javafx.scene.control.Label("Błąd podczas ładowania pliku FXML");
        }
    }
}
