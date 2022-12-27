package module.product;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

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
    public void testDoNotAllowInsertionOfProductWithValueEqualToZero(){

        String messageToast = new LoginPage(browser)
                .informTheUser("admin")
                .informThePassword("admin")
                .submitLoginForm()
                .productAdditionForm()
                .addProductName("PlayStation 5")
                .addProductValue("0.00")
                .addProductColor("preto, branco")
                .submitProductAdditionForm()
                .captureDisplayedMessage();


        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", messageToast);
    }
    @Test
    @DisplayName("Nao permitir a insercao de produto com o valor igual a 7000.01")
    public void testDoNotAllowInsertionOfProductWithValueSevenThousantPointZeroOne(){
        String messageToast = new LoginPage(browser)
                .informTheUser("admin")
                .informThePassword("admin")
                .submitLoginForm()
                .productAdditionForm()
                .addProductName("PlayStation 5")
                .addProductValue("7000.01")
                .addProductColor("preto, branco")
                .submitProductAdditionForm()
                .captureDisplayedMessage();


        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", messageToast);
    }

    @Test
    @DisplayName("Permitir a insercao do valor de produto limite igual a 0.01")
    public void testDoNotAllowInsertionOfProductWithValueEqualToZeroPointZeroOne(){
        String messageToast = new LoginPage(browser)
                .informTheUser("admin")
                .informThePassword("admin")
                .submitLoginForm()
                .productAdditionForm()
                .addProductName("PlayStation 5")
                .addProductValue("0.01")
                .addProductColor("preto, branco")
                .submitProductWithSucessAdditionForm()
                .captureDisplayedMessagetoEditionPage();


        Assertions.assertEquals("Produto adicionado com sucesso", messageToast);
    }

    @Test
    @DisplayName("Permitir a insercao do valor de produto limite igual a 7000.00")
    public void testDoNotAllowInsertionOfProductWithValueEqualToSevenThousand(){
        String messageToast = new LoginPage(browser)
                .informTheUser("admin")
                .informThePassword("admin")
                .submitLoginForm()
                .productAdditionForm()
                .addProductName("PlayStation 5")
                .addProductValue("7000,00")
                .addProductColor("preto, branco")
                .submitProductWithSucessAdditionForm()
                .captureDisplayedMessagetoEditionPage();


        Assertions.assertEquals("Produto adicionado com sucesso", messageToast);
    }

    @Test
    @DisplayName("Cadastrar um produto com valores entre 0.01 e 7000.00")
    public void testSuccessfullyRegisterProduct(){
        String messageToast = new LoginPage(browser)
                .informTheUser("admin")
                .informThePassword("admin")
                .submitLoginForm()
                .productAdditionForm()
                .addProductName("PlayStation 5")
                .addProductValue("5000.01")
                .addProductColor("preto, branco")
                .submitProductWithSucessAdditionForm()
                .captureDisplayedMessagetoEditionPage();


        Assertions.assertEquals("Produto adicionado com sucesso", messageToast);
    }

    @AfterEach
    public void AfterEach(){
        //Vou fechar o navegador
        browser.quit();
    }
}
