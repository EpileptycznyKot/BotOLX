package tests;

import helpers.Ogloszenie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Runner {
    List<String> olxLinks = new ArrayList<>();
    List<String> otoDomLinks = new ArrayList<>();
    List<Ogloszenie> output;
    TempTests tmp;
    public Runner(){
        output = new ArrayList<>();
        tmp = new TempTests();
    }

    public List<Ogloszenie> start(Map<String ,Ogloszenie> znane){
        tmp.start();
        olxLinks = tmp.getlAllOlxLinks();
        otoDomLinks = tmp.getlAllOtoDomxLinks();
        clearList(olxLinks, znane);
        clearList(otoDomLinks, znane);

        for(String link : olxLinks){
            Ogloszenie ogloszenie = tmp.testLinkOlx(link);
            if(ogloszenie != null){
                output.add(ogloszenie);
            }
        }
        for(String link : otoDomLinks){
            Ogloszenie ogloszenie = tmp.testLinkOtoDom(link);
            if(ogloszenie != null){
                output.add(ogloszenie);
            }
        }
        return output;
    }

    public void clearList(List<String> linki, Map<String, Ogloszenie> znane){
        for(int i=linki.size()-1; i>=0; i--){
            if(znane.containsKey(linki.get(i))){
                linki.remove(i);
            }
        }
    }
}
