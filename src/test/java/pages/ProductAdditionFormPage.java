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

    public ProductAdditionFormPage addProductValue(Double productValue){
        browser.findElement(By.id("produtovalor")).sendKeys(productValue.toString());
        return this;
    }

    public ProductAdditionFormPage addProductColor(List<String> productColor){
        browser.findElement(By.id("produtocores")).sendKeys("preto, branco");
        return this;
    }
}
