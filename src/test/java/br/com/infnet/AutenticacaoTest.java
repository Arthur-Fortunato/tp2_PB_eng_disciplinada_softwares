package br.com.infnet;

import br.com.infnet.pages.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutenticacaoTest extends BaseTest {
    @Test
    void deveTestarCadastroValido() {
        HomePage home = new HomePage(driver);
        AutenticationPage login = home.clicarNoLinkSignup();
        assertThat(driver.getCurrentUrl(), containsString("login"));

        String nome = "Ark" + Math.random();
        String email = "ark" + Math.random() + "@teste.com";
        login.preencherSignup(nome, email);

        SignupPage signup = new SignupPage(driver);
        signup.preencherFormularioCompleto();

        AccountCreatedPage accountCreated = new AccountCreatedPage(driver);
        assertThat(accountCreated.obterMensagem(), is("ACCOUNT CREATED!"));
    }

    @Test
    void naoDevePermitirCadastroSemDominioDoEmail() {
        HomePage home = new HomePage(driver);
        AutenticationPage login = home.clicarNoLinkSignup();

        String nome = "Ark" + Math.random();
        String email = "ark" + Math.random() + "@.com";

        login.preencherSignup(nome, email);

        String mensagem = login.getMensagemValidacaoEmailSignup();

        assertThat(mensagem, not(isEmptyString()));
    }

    @Test
    void devePreencherLoginValido() {
        HomePage home = new HomePage(driver);
        AutenticationPage login = home.clicarNoLinkSignup();
        assertThat(driver.getCurrentUrl(), containsString("login"));

        String email = "arttest@gmail.com";
        String senha = "123456789";
        login.preencherLogin(email, senha);

        HomePageLogada loggedPage = new HomePageLogada(driver);
        assertTrue(loggedPage.usuarioLogado(),"O Usuário deveria estar logado.");
    }

    @Test
    void deveExibirErroComLoginInvalido() {
        HomePage home = new HomePage(driver);
        AutenticationPage login = home.clicarNoLinkSignup();
        login.preencherLogin("email_randomqnexiste@teste.com", "senhadoida");
        assertTrue(login.erroVisivel(), "Deve aparecer a mensagem de erro 'Your email or password is incorrect!'");
    }

}