package hcp.pages;

import com.google.common.collect.Lists;
import hcp.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile({"chrome", "chromeMac", "edge"})
public class JobDetailsPage {
    private WebDriver driver;
    private WaitUtils waitUtils;

    //Activity feed elements
    @FindBy(xpath = "//*[contains(text(),'Activity feed')]/../../../../..")
    private WebElement activityFeedSection;

    @FindBy(xpath = "//*[contains(@class,'Summary-root')]")
    private List<WebElement> activityFeedSectionPanels;

    @Autowired
    public JobDetailsPage(WebDriver driver, WaitUtils waitUtils) {
        this.driver = driver;
        this.waitUtils = waitUtils;
        PageFactory.initElements(driver, this);
    }

    public String getActivityFeedSectionText() {
        return activityFeedSection.getText();
    }

    public void expandAllActivityFeedPanels() {
        activityFeedSection.isDisplayed();
        Lists.reverse(activityFeedSectionPanels).forEach(el -> {
            el.click();
            waitUtils.waitUntilElementAttributeHasValue(30, el, "aria-expanded", "true");
        });
    }
}
