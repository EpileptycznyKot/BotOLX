import helpers.Ogloszenie;
import tests.Runner;
import tests.TempTests;

import java.text.SimpleDateFormat;
import java.util.*;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Ogloszenie> znane = new HashMap<>();
        List<Ogloszenie> ogloszeniaTmp;

        Runner run = new Runner();

        while(true) {
            ogloszeniaTmp = run.start(znane);
            for (Ogloszenie o : ogloszeniaTmp) {
                if(!znane.containsKey(o.getLink())){
                    znane.put(o.getLink(), o);
                    System.out.println(getCurrentTime()+" : "+ o);
                }
            }
        }
    }

    private static String getCurrentTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date data = new Date();
        return formatter.format(data);
    }
}
