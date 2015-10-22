package vereshchakov.main;

import java.io.IOException;

/**
 * Created by Danila on 22.10.15.
 */
public class Main {
    public static void main(String[] args) {

        boolean running = true;
        while (running) {
            try {
                new Request().date_update();
                Thread.sleep(1000 * 60 * 60 * Config.getInstance().getUpdate_period());
            } catch (InterruptedException e) {
                running = false;
                System.out.println("Приложение остановлено!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
