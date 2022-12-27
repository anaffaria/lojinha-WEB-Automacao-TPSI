package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListProductPage {
    private WebDriver browser;

    public  ListProductPage(WebDriver browser){
        this.browser = browser;
    }

    public ProductAdditionFormPage productAdditionForm(){
        browser.findElement(By.linkText("ADICIONAR PRODUTO")).click();
        return new ProductAdditionFormPage(browser);
    }

    public String captureDisplayedMessage(){
        return browser.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
