package hcp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"chrome", "chromeMac", "edge"})
public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//button/*[contains(text(),'New')]")
    private WebElement newButton;

    @FindBy(xpath = "//*[text()='Job']")
    private WebElement newJobButton;

    @Autowired
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openNewJobPage() {
        newButton.click();
        newJobButton.click();
    }
}
