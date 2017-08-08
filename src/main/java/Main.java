import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

public class Main {
    private final static String API_KEY = "trnsl.1.1.20170807T101130Z.f157a372e67fc266.b4b186c62a303bcb970c743897289126e4ffea2a";
    private final static String URL = "https://translate.yandex.net/api/v1.5/tr/translate?key=%s&text=%s&lang=en-ru";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String phrase = br.readLine();
        phrase = URLEncoder.encode(phrase, "UTF-8");
        Document response = Jsoup.connect(String.format(URL, API_KEY, phrase)).get();
        System.out.println(response.getElementsByTag("text").text());
    }
}
