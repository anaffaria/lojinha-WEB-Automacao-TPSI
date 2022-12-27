package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductEditionFormPage {
    private WebDriver browser;

    public ProductEditionFormPage(WebDriver browser){
        this.browser = browser;
    }

    public String captureDisplayedMessagetoEditionPage(){
        return browser.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
