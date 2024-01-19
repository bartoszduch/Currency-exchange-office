import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

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
        currencyColumn.setCellValueFactory(new PropertyValueFactory<>("currencyName"));
        buyColumn.setCellValueFactory(new PropertyValueFactory<>("buyRate"));
        sellColumn.setCellValueFactory(new PropertyValueFactory<>("sellRate"));
        ObservableList<DownloadData.CurrencyData> data = FXCollections.observableArrayList(

        );

        currencyTable.setItems(DownloadData.downloadAndPopulateTable("https://kantor.live/kantory/krakow/564840-kantor-kardinal"));
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
