package hcp.pages;

import hcp.datastructure.CustomerDataStructure;
import hcp.utils.WaitUtils;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
@Profile({"chrome", "edge"})
public class NewCustomerForm {
    private WebDriver driver;

    //Contact Info elements
    @FindBy(id = "customer-dialog-first-name")
    WebElement firstNameInput;

    @FindBy(name = "last_name")
    WebElement lastNameInput;

    @FindBy(name = "mobile_number")
    WebElement mobilePhoneInput;

    @FindBy(name = "company")
    WebElement companyInput;

    @FindBy(name = "display_name")
    WebElement displayNameInput;

    @FindBy(name = "home_number")
    WebElement homeNumberInput;

    @FindBy(name = "job_title")
    WebElement jobTitleInput;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "work_number")
    WebElement workPhoneInput;

    //Address elements
    @FindBy(xpath = "//input[contains(@id,'addresses[0].street')]")
    WebElement streetInput;

    @FindBy(xpath = "//input[contains(@name,'addresses[0].street_line_2')]")
    WebElement unitInput;

    @FindBy(xpath = "//input[contains(@name,'addresses[0].city')]")
    WebElement cityInput;

    @FindBy(xpath = "//*[contains(@id,'addresses[0].state')]")
    WebElement stateInput;

    @FindBy(xpath = "//input[contains(@name,'addresses[0].zip')]")
    WebElement zipInput;

    @FindBy(xpath = "//*[contains(@name,'addresses[0].notes')]")
    WebElement addressNotesInput;

    //Notes elements
    @FindBy(name = "notes")
    WebElement customerNotesInput;

    @FindBy(xpath = "//*[contains(@placeholder,'Search customers')]")
    WebElement thisCustomerBillsToInput;

    @FindBy(xpath = "//*[contains(text(),'ustomer tag')]/..//input")
    WebElement customerTagsInput;

    @FindBy(xpath = "//*[contains(text(),'ead source')]/..//input")
    WebElement leadSourceInput;

    //Form footer elements
    @FindBy(xpath = "//button/*[contains(text(),'create')]")
    WebElement createCustomerButton;

    private By getStateListElementLocator(String state) {
        return By.xpath(String.format("//li[@data-value='%s']", state));
    }

    @Autowired
    public NewCustomerForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Contact Info methods
    public void setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void setMobilePhone(String mobilePhone) {
        mobilePhoneInput.sendKeys(mobilePhone);
    }

    public void setCompany(String company) {
        companyInput.sendKeys(company);
    }

    public void setDisplayName(String displayName) {
        displayNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), displayName);
    }

    public void setHomePhone(String homePhone) {
        homeNumberInput.sendKeys(homePhone);
    }

    public void setJobTitle(String jobTitle) {
        jobTitleInput.sendKeys(jobTitle);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setWorkPhone(String workPhone) {
        workPhoneInput.sendKeys(workPhone);
    }

    public void setContactInfo(DataTable contactInfoData) {
        Map<String, String> contactInfo = contactInfoData.transpose().asMap();
        setFirstName(contactInfo.get(CustomerDataStructure.FIRST_NAME.getFieldName()));
        setLastName(contactInfo.get(CustomerDataStructure.LAST_NAME.getFieldName()));
        setMobilePhone(contactInfo.get(CustomerDataStructure.MOBILE_PHONE.getFieldName()));
        setCompany(contactInfo.get(CustomerDataStructure.COMPANY.getFieldName()));
        setDisplayName(contactInfo.get(CustomerDataStructure.DISPLAY_NAME.getFieldName()));
        setHomePhone(contactInfo.get(CustomerDataStructure.HOME_PHONE.getFieldName()));
        setJobTitle(contactInfo.get(CustomerDataStructure.JOB_TITLE.getFieldName()));
        setEmail(contactInfo.get(CustomerDataStructure.EMAIL.getFieldName()));
        setWorkPhone(contactInfo.get(CustomerDataStructure.WORK_PHONE.getFieldName()));
    }

    //Address methods
    public void setStreet(String street) {
        streetInput.sendKeys(street);
    }

    public void setUnit(String unit) {
        unitInput.sendKeys(unit);
    }

    public void setCity(String city) {
        cityInput.sendKeys(city);
    }

    public void setState(String state) {
        stateInput.click();
        driver.findElement(getStateListElementLocator(state)).sendKeys(Keys.ENTER);
    }

    public void setZip(String zip) {
        zipInput.sendKeys(zip);
    }

    public void setAddressNotes(String addressNotes) {
        addressNotesInput.sendKeys(addressNotes);
    }

    public void setAddress(DataTable addressData) {
        Map<String, String> address = addressData.transpose().asMap();
        setStreet(address.get(CustomerDataStructure.STREET.getFieldName()));
        setUnit(address.get(CustomerDataStructure.UNIT.getFieldName()));
        setCity(address.get(CustomerDataStructure.CITY.getFieldName()));
        setState(address.get(CustomerDataStructure.STATE.getFieldName()));
        setZip(address.get(CustomerDataStructure.ZIP.getFieldName()));
        setAddressNotes(address.get(CustomerDataStructure.ADDRESS_NOTES.getFieldName()));
    }

    //Notes methods
    public void setCustomerNotes(String customerNotes) {
        customerNotesInput.sendKeys(customerNotes);
    }

    public void setThisCustomerBillsTo(String customer) {
        thisCustomerBillsToInput.sendKeys(customer + Keys.ENTER);
    }

    public void setCustomerTags(String customerTags) {
        Arrays.stream(customerTags.split(";")).forEach((tag) -> customerTagsInput
                .sendKeys(tag + Keys.ENTER));
    }

    public void setLeadSource(String leadSource) {
        leadSourceInput.sendKeys(leadSource + Keys.ESCAPE);
    }

    public void setNotes(DataTable notesData) {
        Map<String, String> notes = notesData.transpose().asMap();
        setCustomerNotes(notes.get(CustomerDataStructure.CUSTOMER_NOTES.getFieldName()));
        setThisCustomerBillsTo(notes.get(CustomerDataStructure.THIS_CUSTOMER_BILLS_TO.getFieldName()));
        setCustomerTags(notes.get(CustomerDataStructure.CUSTOMER_TAGS.getFieldName()));
        setLeadSource(notes.get(CustomerDataStructure.LEAD_SOURCE.getFieldName()));
    }

    //Form footer methods
    public void clickCreateCustomerButton() {
        createCustomerButton.click();
    }
}