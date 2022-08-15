package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Teste Web do Modulos de Produto")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){ //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver_win32\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //Vou maximinizar a tela
        this.navegador.manage().window().maximize();

        // Vou definir um tempo de espera padrao de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Navegar para a pagina da Lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2");

    }
    @Test
    @DisplayName("Nao e permitido registrar um produto com valor igual a zero")
    public void testNaoEPermetidoRegistrarProdutoComValorIgualAZero(){


        //Fazer login
        String mensagemToast = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Playstation")
                .informarValorProduto("000")
                .informarCoresDoproduto("Preto,branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();


        //Vou validar que a mensagem de erro foi apresentada
        //<div class="toast rounded" style="top: 0px; opacity: 1;">O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00</div
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemToast);

        //Vou fechar o navegador
        navegador.quit();

    }
    @Test
    @DisplayName( "Não e permitido registrar um produto com o valor maior que 7.000,00")
    public  void TestNaoEPermetidoRegistarProdutoComValorAcimaDeSeteMil(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Iphone")
                .informarValorProduto("700010")
                .informarCoresDoproduto("Rosa,Branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Posso  Adicionar produtos que estejam na faixa de 0,01 a 7.000,00")
    public void testPossoAdicionarProdutosComValorDeUmCentavosASeteMilReais() {
        String mensagemApresentada =new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("MacBook")
                .informarValorProduto("650000")
                .informarCoresDoproduto("Prata, branco")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso",mensagemApresentada);



    }

        @Test
        @DisplayName("Posso  Adicionar produtos que estejam no Limite de 7.000,00")
        public void testPossoAdicionarProdutosComValorDeSeteMilReais(){
            String mensagemApresentada =new LoginPage(navegador)
                    .informarOUsuario("admin")
                    .informarASenha("admin")
                    .submeterFormularioDeLogin()
                    .acessarFormularioAdicaoNovoProduto()
                    .informarNomeDoProduto("MacBook Pro")
                    .informarValorProduto("700000")
                    .informarCoresDoproduto("Prata, branco")
                    .submeterFormularioDeAdicaoComSucesso()
                    .capturarMensagemApresentada();

            Assertions.assertEquals("Produto adicionado com sucesso",mensagemApresentada);


    }
    @AfterEach
    public void afterEach() {
        //Vou fechar o navegador
        navegador.quit();
    }
}
