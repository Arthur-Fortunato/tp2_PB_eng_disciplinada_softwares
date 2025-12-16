package br.com.infnet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    private WebDriver driver;

    private By tituloAccountCreated = By.xpath("//b[text()='Account Created!']");

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public String obterMensagem() {
        return driver.findElement(tituloAccountCreated).getText();
    }
}
