import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DownloadData extends CurrentDate{
    public static ObservableList<CurrencyData> downloadAndPopulateTable(String url) {
        ObservableList<CurrencyData> data = FXCollections.observableArrayList();

        try {
            Document document = Jsoup.connect(url).get();
            Elements tableRows = document.select("table tr");

            int printedRows = 0;
            for (Element row : tableRows) {
                if (printedRows >= 2 && printedRows < 17) {
                    Elements columns = row.select("td");

                    if (columns.size() >= 4) {
                        String currencyColumn = columns.get(0).text();
                        String buyColumn = columns.get(2).text();
                        String sellColumn = columns.get(3).text();

                        CurrencyData currency = new CurrencyData(currencyColumn, buyColumn, sellColumn);
                        data.add(currency);

                    }
                }
                printedRows++;

                if (printedRows >= 20) {
                    break;
                }
            }
            System.out.println(data.get(0).currencyName);
            System.out.println(data.get(0).buyRate);
            System.out.println(data.get(0).sellRate);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static class CurrencyData {
        private final String currencyName;
        private final String buyRate;
        private final String sellRate;

        public CurrencyData(String currencyName, String buyRate, String sellRate) {
            this.currencyName = currencyName;
            this.buyRate = buyRate;
            this.sellRate = sellRate;
        }

        public String getCurrencyName() {
            return currencyName;
        }

        public String getBuyRate() {
            return buyRate;
        }

        public String getSellRate() {
            return sellRate;
        }
    }
}
