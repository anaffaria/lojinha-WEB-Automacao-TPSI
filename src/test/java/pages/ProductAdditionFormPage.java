package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ProductAdditionFormPage {
    private WebDriver browser;

    public ProductAdditionFormPage(WebDriver browser){
        this.browser = browser;
    }

    public ProductAdditionFormPage addProductName(String productName){
        browser.findElement(By.id("produtonome")).sendKeys(productName);
        return this;
    }

    public ProductAdditionFormPage addProductValue(String productValue){
        browser.findElement(By.id("produtovalor")).sendKeys(productValue);
        return this;
    }

    public ProductAdditionFormPage addProductColor(String productColor){
        browser.findElement(By.id("produtocores")).sendKeys(productColor);
        return this;
    }

    public ProductEditionFormPage submitProductWithSucessAdditionForm(){
        browser.findElement(By.cssSelector("button[type='submit']")).click();
        return new ProductEditionFormPage(browser);
    }
    public ListProductPage submitProductAdditionForm(){
        browser.findElement(By.cssSelector("button[type='submit']")).click();
        return new ListProductPage(browser);
    }

}
