package helpers;

public class Ogloszenie {
    private int cena;
    private String link;
    private int kiedyDodana;

    public Ogloszenie(int cena, String link, int kiedyDodana) {
        this.cena = cena;
        this.link = link;
        this.kiedyDodana = kiedyDodana;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getKiedyDodana() {
        return kiedyDodana;
    }

    public void setKiedyDodana(int kiedyDodana) {
        this.kiedyDodana = kiedyDodana;
    }

    @Override
    public String toString() {
        String dodano = "";
        if(kiedyDodana==0){
            dodano = "no information";
        }else{
            dodano = String.valueOf(kiedyDodana);
        }
        return "Ogloszenie{" +
                "cena=" + cena +
                ", link='" + link + '\'' +
                ", kiedyDodana=" + dodano +
                '}';
    }


}
