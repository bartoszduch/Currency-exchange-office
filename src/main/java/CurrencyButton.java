import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CurrencyButton extends Button {

    private final Kontroler controller;
    private final String currencyName;

    public CurrencyButton(String currencyName, Kontroler controller) {
        super(currencyName);
        this.currencyName = currencyName;
        this.controller = controller;

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.showCurrency(currencyName);
            }
        });
    }
}