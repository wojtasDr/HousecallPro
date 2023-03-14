package hcp.steps;

import hcp.pages.HomePage;
import io.cucumber.java8.En;


public class HomePageSteps implements En {
    private HomePage homePage;

    public HomePageSteps(HomePage homePage) {
        this.homePage = homePage;

        When("I open new job page", homePage::openNewJobPage);
    }
}
