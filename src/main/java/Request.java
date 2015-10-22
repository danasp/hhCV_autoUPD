import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

/**
 * Created by Danila on 22.10.15.
 */
public class Request {

    private Config config = Config.getInstance();

    public void date_update() throws IOException {

        HttpsURLConnection connection = null;
        URL url;
        try {

            url = new URL("https://api.hh.ru/resumes/"+ config.getResume_id() +"/publish");
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(true);
            connection.setRequestProperty("User-Agent", "cv_autoUPD/1.0 (dvereschakov@mail.ru)");
            connection.setRequestProperty("Authorization", "Bearer " + config.getAccess_token());
            connection.setHostnameVerifier(new DummyHostnameVerifier());

            int responseCode = connection.getResponseCode();
            if (responseCode == 204) {
                System.out.println("Резюме успешно обновлено");
            } else if (responseCode == 429) {
                System.out.println("Резюме не обновлено. Обновлять резюме можно каждые 4 часа");
            }

        }
        finally {
            if(connection != null) {
                connection.disconnect();
            }
        }

    }
}
