package hcp.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class WaitUtils {

    private WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method waits until given element has expected text
     *
     * @param timeout      wait timout in seconds
     * @param element      web element to be examined
     * @param expectedText text to be present in given web element
     */
    public void waitUntilElementHasText(int timeout, WebElement element, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    /**
     * This method waits until given element attribute has expected value
     *
     * @param timeout                wait timout in seconds
     * @param element                web element to be examined
     * @param attributeName          web element attribute to be examined
     * @param expectedAttributeValue attribute value to be present in given web element attribute
     */
    public void waitUntilElementAttributeHasValue(int timeout, WebElement element, String attributeName, String expectedAttributeValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.attributeToBe(element, attributeName, expectedAttributeValue));
    }
}
