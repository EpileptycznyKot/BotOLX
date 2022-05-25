package tests;

import constants.Links;
import helpers.ExtractorOgloszenia;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BoardPage;

import java.util.ArrayList;
import java.util.List;

public class TempTests {

    private WebDriver driver;

    public TempTests(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    public void start(){
        driver.get(Links.MIESZKANIA_FILTERED);
    }

    public void finish(){
        driver.quit();
    }

    public List<String> getAllLinks(){
        BoardPage boardPage = new BoardPage(driver);
        List<String> links = new ArrayList<>();
        for(WebElement ogloszenie : boardPage.getAllPosts()){
            links.add(ExtractorOgloszenia.extractLink(ogloszenie));
        }
        return links;
    }

    public void test(){
        BoardPage boardPage = new BoardPage(driver);
        List<WebElement> posts = boardPage.getAllPosts();
        WebElement t = posts.get(2);
        System.out.println(posts.get(1).getAttribute("class"));
    }


}
