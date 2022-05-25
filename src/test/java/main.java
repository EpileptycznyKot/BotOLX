import tests.TempTests;

import java.util.List;

public class main {
    public static void main(String[] args) throws InterruptedException {
        TempTests tmp = new TempTests();
        tmp.start();
        tmp.test();
        //List<String> linki = tmp.getAllLinks();
        //linki.forEach(System.out::println);
        //Thread.sleep(10000);
        //tmp.finish();
    }
}
