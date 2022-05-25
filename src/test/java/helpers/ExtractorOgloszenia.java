package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class ExtractorOgloszenia {
    public static int extractPricePrice(WebElement ogloszenie){
        WebElement priceTag= ogloszenie.findElement(By.xpath("//following-sibling::p"));
        System.out.println(priceTag);
        return getPrice(priceTag);
    }

    public static String extractLink(WebElement ogloszenie){
        WebElement link = ogloszenie.findElement(By.xpath("//a"));
        String as = link.getAttribute("href");
        return link.getAttribute("href");
    }


    private static int getPrice(WebElement priceTag){
        String text = priceTag.getText();
        int price = Integer.valueOf(removeNoneDigits(text));
        return price;
    }

    private static String removeNoneDigits(String napis){
        String output = "";
        for(int i=0;i<napis.length();i++){
            if(Character.isDigit(napis.charAt(i))){
                output += napis.charAt(i);
            }
        }
        return output;
    }
}
