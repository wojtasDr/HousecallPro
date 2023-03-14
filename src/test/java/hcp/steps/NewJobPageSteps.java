package hcp.steps;

import hcp.pages.NewJobPage;
import hcp.validators.CommonValidators;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.assertj.core.api.Assertions;

public class NewJobPageSteps implements En {

    private NewJobPage newJobPage;
    private CommonValidators commonValidators;

    public NewJobPageSteps(NewJobPage newJobPage, CommonValidators commonValidators) {
        this.newJobPage = newJobPage;
        this.commonValidators = commonValidators;

        When("I open new customer form", newJobPage::openAddNewCustomerForm);

        When("I add new \"Line item\"", newJobPage::addLineItem);

        When("I add {string} \"Private note\"", newJobPage::addPrivateNote);

        Then("\"Private note\" {string} was added correctly", (String expectedNote) ->
                Assertions.assertThat(newJobPage.getPrivateNoteText()).isEqualTo(expectedNote));

        When("I click \"SAVE JOB\" button", newJobPage::clickSaveJobButton);

        Then("\"Line items\" total amount equals {string}", newJobPage::lineItemsTotalAmountIsCorrect);

        Then("Customer was saved correctly with following data", (DataTable expectedData) -> {
            String customerData = newJobPage.getCustomerSectionText();
            commonValidators.checkIfTextContainsAllData(customerData, expectedData);
        });
    }
}
