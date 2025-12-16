package br.com.infnet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private WebDriver driver;

    private By botaoAddToCart = By.cssSelector("button.cart");
    private By botaoViewCart  = By.xpath("//u[text()='View Cart']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void adicionarAoCarrinho() {
        driver.findElement(botaoAddToCart).click();
    }

    public CartPage irParaOCarrinho() {
        driver.findElement(botaoViewCart).click();
        return new CartPage(driver);
    }
}
