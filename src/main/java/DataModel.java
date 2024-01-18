import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataModel {
    private final StringProperty currency;
    private final StringProperty buy;
    private final StringProperty sell;

    public DataModel(String currency, String buy, String sell) {
        this.currency = new SimpleStringProperty(currency);
        this.buy = new SimpleStringProperty(buy);
        this.sell = new SimpleStringProperty(sell);
    }

    public StringProperty currencyProperty() {
        return currency;
    }

    public StringProperty buyProperty() {
        return buy;
    }

    public StringProperty sellProperty() {
        return sell;
    }
}
