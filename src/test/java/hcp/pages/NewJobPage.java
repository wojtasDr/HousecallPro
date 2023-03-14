package hcp.pages;

import hcp.datastructure.LineItemDataStructure;
import hcp.utils.WaitUtils;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Profile({"chrome", "chromeMac", "edge"})
public class NewJobPage {
    private WebDriver driver;
    private WaitUtils waitUtils;

    //Header elements
    @FindBy(xpath = "//button/*[contains(text(),'ave job')]")
    private WebElement saveJobButton;

    // Customer elements
    @FindBy(xpath = "//button/*[contains(text(),'ew customer')]")
    private WebElement newCustomerButton;

    @FindBy(xpath = "//*[text()='Customer']/../../../../..")
    private WebElement customerSection;

    @FindBy(xpath = "//*[contains(text(),'ustomer history')]")
    private WebElement customerHistoryButton;

    // Line items elements
    @FindBy(id = "item-name")
    private WebElement lineItemNameInput;

    @FindBy(id = "qty")
    private WebElement lineItemQtyInput;

    @FindBy(id = "unit-price")
    private WebElement lineItemUnitPriceInput;

    @FindBy(id = "description")
    private WebElement lineItemDescriptionInput;

    @FindBy(xpath = "//*[contains(text(),'nit cost')]/..//input")
    private WebElement lineItemUnitCostInput;

    @FindBy(xpath = "//*[text()='Total']/../..//h6")
    private WebElement totalValue;

    // Private notes elements
    @FindBy(xpath = "//*[contains(text(),'ivate notes')]")
    private WebElement privateNotesLabel;

    @FindBy(css = "[data-testid='private-notes-textfield']")
    private WebElement privateNotesTextarea;

    @Autowired
    public NewJobPage(WebDriver driver, WaitUtils waitUtils) {
        this.driver = driver;
        this.waitUtils = waitUtils;
        PageFactory.initElements(driver, this);
    }

    // Header methods
    public void clickSaveJobButton() {
        saveJobButton.click();
    }

    // Customer methods
    public void openAddNewCustomerForm() {
        newCustomerButton.click();
    }

    public String getCustomerSectionText() {
        customerHistoryButton.isDisplayed();
        return customerSection.getText();
    }

    // Line items methods
    public void setLineItemName(String name) {
        lineItemNameInput.click();
        lineItemNameInput.sendKeys(name);
    }

    public void setLineItemQty(String qty) {
        lineItemQtyInput.click();
        lineItemQtyInput.sendKeys(Keys.chord(Keys.HOME), qty);
    }

    public void setLineItemUnitPrice(String unitPrice) {
        lineItemUnitPriceInput.click();
        lineItemUnitPriceInput.sendKeys(Keys.chord(Keys.HOME), unitPrice);
    }

    public void setLineItemDescription(String description) {
        lineItemDescriptionInput.click();
        lineItemDescriptionInput.sendKeys(description);
    }

    public void setLineItemUnitCost(String unitCost) {
        lineItemUnitCostInput.click();
        lineItemUnitCostInput.sendKeys(Keys.chord(Keys.HOME), unitCost);
    }

    public void addLineItem(DataTable lineItemData) {
        Map<String, String> lineItem = lineItemData.transpose().asMap();
        setLineItemName(lineItem.get(LineItemDataStructure.NAME.getFieldName()));
        setLineItemQty(lineItem.get(LineItemDataStructure.QTY.getFieldName()));
        setLineItemUnitPrice(lineItem.get(LineItemDataStructure.UNIT_PRICE.getFieldName()));
        setLineItemDescription(lineItem.get(LineItemDataStructure.DESCRIPTION.getFieldName()));
        setLineItemUnitCost(lineItem.get(LineItemDataStructure.UNIT_COST.getFieldName()));
    }

    public void lineItemsTotalAmountIsCorrect(String expectedAmount) {
        waitUtils.waitUntilElementHasText(30, totalValue, expectedAmount);
    }

    // Private notes methods
    public void addPrivateNote(String note) {
        privateNotesLabel.click();
        privateNotesTextarea.sendKeys(note);
    }

    public String getPrivateNoteText() {
        return privateNotesTextarea.getText();
    }
}
