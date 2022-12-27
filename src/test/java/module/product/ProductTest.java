package module.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ListProductPage;
import pages.LoginPage;
import pages.ProductAdditionFormPage;

import java.time.Duration;

@DisplayName("Testes Web do Modulo de Produtos")
public class ProductTest {

    private WebDriver browser;

    @BeforeEach
    public void BeforeEach(){
        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver\\chromedriver.exe");
        this.browser = new ChromeDriver();

        //Maximizar a tela
        this.browser.manage().window().maximize();

        //Vou definir um tempo de espera padrão de 5 segundos
        this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a pagina da Lojinha Web
        this.browser.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("Nao permitir a insercao de produto com valor igual a zero")
    public void DoNotAllowInsertionOfProductWithValueEqualToZero(){

        //Fazer Login
        new LoginPage(browser)
                .informTheUser("admin")
                .informThePassword("admin")
                .submitLoginForm()
                .productAdditionForm();







        //Vou preencher dados do produto e o valor sera igual a zero




        //Vou submeter o formulario
        browser.findElement(By.cssSelector("button[type='submit']")).click();

        //Vou validar que a mensagem de erro foi apresentada
        String messageToast = browser.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", messageToast);

        //Vou fehcar o navegador
        browser.quit();




    }

}
