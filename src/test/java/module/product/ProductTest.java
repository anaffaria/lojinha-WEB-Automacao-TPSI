package module.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes Web do Modulo de Produtos")
public class ProductTest {
    @Test
    @DisplayName("Nao permitir a insercao de produto com valor igual a zero")
    public void DoNotAllowInsertionOfProductWithValueEqualToZero(){

        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        //Maximizar a tela
        browser.manage().window().maximize();

        //Vou definir um tempo de espera padrão de 5 segundos
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a pagina da Lojinha Web
        browser.get("http://165.227.93.41/lojinha-web/v2/");

        //Vou para a tela de registro de produtos
        browser.findElement(By.cssSelector("label[for='usuario']")).click();
        browser.findElement(By.id("usuario")).sendKeys("admin");

        browser.findElement(By.cssSelector("label[for='senha']")).click();
        browser.findElement(By.id("senha")).sendKeys("admin");

        browser.findElement(By.cssSelector("button[type='submit']")).click();

        browser.findElement(By.linkText("ADICIONAR PRODUTO")).click();
        //Vou preencher dados do produto e o valor sera igual a zero


        browser.findElement(By.id("produtonome")).sendKeys("Play Station 5");
        browser.findElement(By.id("produtovalor")).sendKeys("0.00");
        browser.findElement(By.id("produtocores")).sendKeys("preto, branco");

        //Vou submeter o formulario
        browser.findElement(By.cssSelector("button[type='submit']")).click();

        //Vou validar que a mensagem de erro foi apresentada
        String messageToast = browser.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", messageToast);

        //Vou fehcar o navegador
        browser.quit();



    }

}
