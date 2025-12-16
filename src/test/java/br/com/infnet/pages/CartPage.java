package br.com.infnet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By tabelaCarrinho = By.id("cart_info_table");
    private By nomeProduto = By.cssSelector(".cart_description h4 a");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean produtoEstaNoCarrinho() {
        return !driver.findElements(tabelaCarrinho).isEmpty();
    }

    public String obterNomeProduto() {
        return driver.findElement(nomeProduto).getText();
    }

    public void removerProduto() {
        driver.findElement(By.cssSelector(".cart_quantity_delete")).click();
    }

    public boolean carrinhoEstaVazio() {
        return !driver.findElements(By.xpath("//b[text()='Cart is empty!']")).isEmpty();
    }
}