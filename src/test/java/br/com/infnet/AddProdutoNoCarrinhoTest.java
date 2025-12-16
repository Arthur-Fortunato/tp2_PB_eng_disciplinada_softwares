package br.com.infnet;

import br.com.infnet.pages.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddProdutoNoCarrinhoTest extends BaseTest {
    @Test
    void deveAdicionarProdutoAoCarrinho() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        ProductPage productPage;
        CartPage cartPage;

        productPage = homePage.clicarNoPrimeiroProduto();
        productPage.adicionarAoCarrinho();
        Thread.sleep(500);
        cartPage = productPage.irParaOCarrinho();

        assertTrue(cartPage.produtoEstaNoCarrinho(),"O produto não foi encontrado no carrinho");
    }
}
