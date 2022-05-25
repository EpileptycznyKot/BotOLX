package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OgloszeniePageOtoDom {
    private WebDriver driver;


    public OgloszeniePageOtoDom(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//strong[@aria-label='Cena']")
    WebElement priceDiv;


    public int getPrice(){
        String text = priceDiv.getText();
        int price = Integer.valueOf(removeNoneDigits(text));
        return price;
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
}
