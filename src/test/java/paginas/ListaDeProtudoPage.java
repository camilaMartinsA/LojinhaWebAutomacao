package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProtudoPage {
    private WebDriver navegador;

    public ListaDeProtudoPage(WebDriver navegador){
        this.navegador = navegador;
    }
    public FormularioDeAdicaoDeProdutoPage acessarFormularioAdicaoNovoProduto(){
        //Vou para a tela de registro de produto
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new FormularioDeAdicaoDeProdutoPage(navegador);
    }

    public String capturarMensagemApresentada(){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();

    }
}
