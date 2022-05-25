package tests;

import constants.Links;
import constants.Settings;
import helpers.ExtractorOgloszenia;
import helpers.Ogloszenie;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BoardPage;
import pages.OgloszeniePage;
import pages.OgloszeniePageOtoDom;

import java.util.ArrayList;
import java.util.List;


public class TempTests {

    private WebDriver driver;

    public TempTests(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    public void start(){
        driver.manage().window().minimize();
        driver.get(Links.MIESZKANIA_FILTERED);
    }

    public void finish(){
        driver.quit();
    }

    public List<String> getlAllOlxLinks(){
        BoardPage boardPage = new BoardPage(driver);
        List<WebElement> posts = boardPage.getAllPosts();
        List<String> links = new ArrayList<>();
        for(WebElement element : posts){
            WebElement e = element.findElement(By.tagName("a"));
            String link = e.getAttribute("href");
            if(link.contains("olx.pl")){
                links.add(link);
            }
        }
        return links;
    }

    public List<String> getlAllOtoDomxLinks(){
        BoardPage boardPage = new BoardPage(driver);
        List<WebElement> posts = boardPage.getAllPosts();
        List<String> links = new ArrayList<>();
        for(WebElement element : posts){
            WebElement e = element.findElement(By.tagName("a"));
            String link = e.getAttribute("href");
            if(link.contains("otodom.pl")){
                links.add(link);
            }
        }
        return links;
    }

    public Ogloszenie testLinkOlx(String link){
        OgloszeniePage ogloszenie = new OgloszeniePage(driver);
        driver.get(link);
        int czasOdDodania = ogloszenie.getTimeSincePost();
        int cena = ogloszenie.getPrice();
        if((czasOdDodania <= Settings.MAX_MINUTES_SINCE_POST) && (cena >= Settings.LOWER_BOUND && cena <= Settings.UPPER_BOUND)){
            return new Ogloszenie(cena, link, czasOdDodania);
        }
        return null;
    }

    public Ogloszenie testLinkOtoDom(String link){
        OgloszeniePageOtoDom oglszenie = new OgloszeniePageOtoDom(driver);
        driver.get(link);
        int cena = oglszenie.getPrice();
        if(cena >= Settings.LOWER_BOUND && cena <= Settings.UPPER_BOUND){
            return new Ogloszenie(cena, link, 0);
        }
        return null;
    }


}
