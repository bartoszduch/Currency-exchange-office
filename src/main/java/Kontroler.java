import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.List;

public class Kontroler {

    private Button kantor1913Button;

    @FXML
    private VBox view;

    @FXML
    private TreeTableView<DataModel> currencyTable;
    @FXML
    private TreeTableColumn<DataModel, String> currencyColumn;
    @FXML
    private TreeTableColumn<DataModel, String> buyColumn;
    @FXML
    private TreeTableColumn<DataModel, String> sellColumn;


    public void handleButtonClick(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            try {
                Button clickedButton = (Button) event.getSource();
                String buttonText = clickedButton.getText();
                System.out.println("Kliknięto przycisk: " + buttonText);
                if (buttonText.equals("Powrót do MENU")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("KontrolerA.fxml"));
                    Parent root = loader.load();

                    // Ustaw nowy widok w istniejącym oknie
                    Stage stage = (Stage) clickedButton.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } else {
                    // Wczytaj nowy widok FXML
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(buttonText + ".fxml"));
                    Parent root = loader.load();

                    // Tutaj możesz dodać logikę do obsługi nowego widoku
                    // ...

                    // Przykład: Ustaw nowy widok w istniejącym oknie
                    Stage stage = (Stage) clickedButton.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Obsłuż wyjątek ładowania pliku FXML
            }
        }
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