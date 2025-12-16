package br.com.infnet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By tabelaCarrinho = By.id("cart_info_table");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean produtoEstaNoCarrinho() {
        return !driver.findElements(tabelaCarrinho).isEmpty();
    }
}