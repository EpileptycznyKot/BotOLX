package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class OgloszeniePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private boolean bannerClosed;

    public OgloszeniePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        PageFactory.initElements(this.driver, this);
        bannerClosed = false;
    }

    @FindBy(xpath = "//h3[@class='css-okktvh-Text eu5v0x0']")
    WebElement priceHeader;

    @FindBy(xpath = "//span[@data-cy='ad-posted-at']")
    WebElement dateAddedSpan;

    public int getPrice(){
        String text = priceHeader.getText();
        int price = Integer.valueOf(removeNoneDigits(text));
        return price;
    }

    public int getTimeSincePost(){
        return getTimeInMinutesSincePost(getTime());
    }

    private String getTime(){
        String data = dateAddedSpan.getText().substring(10);
        return data;
    }

    private String removeNoneDigits(String napis){
        String output = "";
        for(int i=0;i<napis.length();i++){
            if(Character.isDigit(napis.charAt(i))){
                output += napis.charAt(i);
            }
        }
        return output;
    }

    private int getTimeInMinutesSincePost(String timePosted){

        String currentTime = getCurrentTime();
        int currentTimeValue = convertTimeToInteger(currentTime);
        int timePostedValue = convertTimeToInteger(timePosted);
        return currentTimeValue - timePostedValue;
    }

    private String getCurrentTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date data = new Date();
        return formatter.format(data);
    }

    private int convertTimeToInteger(String czas){
        String []time = czas.split(":");
        return Integer.valueOf(time[0])*60+Integer.valueOf(time[1]);
    }

}
