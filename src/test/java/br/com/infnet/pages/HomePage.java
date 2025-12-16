package br.com.infnet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;
    private By linkSignup = By.cssSelector("a[href='/login']");
    private By primeiroViewProduct = By.xpath("(//a[contains(text(),'View Product')])[1]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AutenticationPage clicarNoLinkSignup() {
        driver.findElement(linkSignup).click();
        return new AutenticationPage(driver);
    }

    public ProductPage clicarNoPrimeiroProduto() {
        var elemento = driver.findElement(primeiroViewProduct);

        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
        return new ProductPage(driver);
    }
}
