import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DownloadData {

    public static void downloadAndPrintData(String url) {
        try {
            // Pobieranie strony jako obiekt Document
            Document document = Jsoup.connect(url).get();

            // Pobranie danych z tabeli (przykład)
            Elements tableRows = document.select("table tr");

            int printedRows = 0;
            for (Element row : tableRows) {
                // Pomijaj pierwsze dwa wiersze (nagłówki) i ostatni wiersz
                if (printedRows >= 2 && printedRows < 10) {
                    Elements columns = row.select("td");

                    // Pomijanie pierwszej, drugiej i ostatniej kolumny
                    for (int i = 1; i < columns.size() - 1; i++) {
                        System.out.print(columns.get(i).text() + "\t");
                    }

                    System.out.println(); // Nowa linia po każdym wierszu
                }

                printedRows++;

                if (printedRows >= 10) {
                    break; // Przerwij pętlę po wypisaniu 8 wierszy
                }
            }



            // Możesz także wykonywać inne operacje w zależności od struktury strony
            // np. pobieranie tekstu, obrazków, itp.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
