import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class KontrolerKardial {
    @FXML
    public TableView<DownloadData.CurrencyData> currencyTable;

    @FXML
    public TableColumn<DownloadData.CurrencyData, String> currencyColumn;

    @FXML
    public TableColumn<DownloadData.CurrencyData, String> buyColumn;

    @FXML
    public TableColumn<DownloadData.CurrencyData, String> sellColumn;

    public void initialize() {

        if (isInternetConnectionAvailable()) {
            currencyColumn.setCellValueFactory(new PropertyValueFactory<>("currencyName"));
            buyColumn.setCellValueFactory(new PropertyValueFactory<>("buyRate"));
            sellColumn.setCellValueFactory(new PropertyValueFactory<>("sellRate"));

            currencyTable.setItems(DownloadData.downloadAndPopulateTable("https://kantor.live/kantory/krakow/564840-kantor-kardinal"));
        } else {
            showNoInternetConnectionAlert();
        }
    }

    private void showConnectionErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd połączenia");
        alert.setHeaderText("Błąd podczas nawiązywania połączenia z serwerem");
        alert.setContentText("Sprawdź swoje połączenie internetowe i spróbuj ponownie.");

        ButtonType exitButton = new ButtonType("Zamknij", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(exitButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == exitButton) {
            Platform.exit();
        }
    }

    private boolean isInternetConnectionAvailable() {
        try {
            URL url = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            return connection.getResponseCode() == 200;
        } catch (IOException e) {
            return false;
        }
    }

    private void showNoInternetConnectionAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd połączenia");
        alert.setHeaderText("Brak połączenia z internetem");
        alert.setContentText("Proszę sprawdzić swoje połączenie internetowe.");

        ButtonType exitButton = new ButtonType("Zamknij", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(exitButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == exitButton) {
            Platform.exit();
        }
    }

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
}
