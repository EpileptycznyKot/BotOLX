package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BoardPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public BoardPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "//div[@data-cy='l-card']")
    List<WebElement> allPosts;

    public List<WebElement> getAllPosts(){
        return allPosts;
    }


}
