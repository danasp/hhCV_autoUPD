import java.io.*;

/**
 * Created by Danila on 22.10.15.
 */
public class Config {

    private String access_token;
    private String resume_id;
    private int update_period;
    private static Config instance = null;

    private Config(String access_token, String resume_id, int update_period) {
        this.access_token = access_token;
        this.resume_id = resume_id;
        this.update_period = update_period;
    }

    public static Config getInstance() {

        String token = "";
        String resume = "";
        int period = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./src/main/resources/config.txt"), "UTF8"));
            token = reader.readLine().split(":")[1];
            resume = reader.readLine().split(":")[1];
            period = Integer.parseInt(reader.readLine().split(":")[1]);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Не найден файл с конфигурацией.");
            System.exit(1);
//            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Неправильная кодировка файла. Поддерживается только UTF8");
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (instance == null) {
            instance = new Config(token, resume, period);
        }
        return instance;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getResume_id() {
        return resume_id;
    }

    public int getUpdate_period() {
        return update_period;
    }
}
