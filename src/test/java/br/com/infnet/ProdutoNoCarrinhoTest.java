package br.com.infnet;

import br.com.infnet.pages.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProdutoNoCarrinhoTest extends BaseTest {
    @Test
    void deveAdicionarProdutoCorretoAoCarrinho() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage;
        CartPage cartPage;

        productPage = homePage.clicarNoPrimeiroProduto();
        productPage.adicionarAoCarrinho();
        Thread.sleep(500);
        cartPage = productPage.irParaOCarrinho();

        assertTrue(cartPage.produtoEstaNoCarrinho(),"O produto não foi encontrado no carrinho");
        assertThat(cartPage.obterNomeProduto(), containsString("Blue Top"));
    }

    @Test
    void deveRemoverProdutoDoCarrinho() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage;
        CartPage cartPage;

        productPage = homePage.clicarNoPrimeiroProduto();
        productPage.adicionarAoCarrinho();
        Thread.sleep(500);

        cartPage = productPage.irParaOCarrinho();
        cartPage.removerProduto();
        Thread.sleep(500);

        assertTrue(cartPage.carrinhoEstaVazio(),"O carrinho deveria estar vazio após a remoção do produto");
    }
}
