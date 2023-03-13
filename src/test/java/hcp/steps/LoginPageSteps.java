package hcp.steps;

import hcp.pages.LoginPage;
import io.cucumber.java8.En;

public class LoginPageSteps implements En {

    LoginPage loginPage;

    public LoginPageSteps(LoginPage loginPage) {
        this.loginPage = loginPage;

        Given("Login page is opened", loginPage::openLoginPage);

        When("I login with username {string} and password {string}", loginPage::logIn);
    }
}
