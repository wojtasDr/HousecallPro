package hcp.steps;

import hcp.pages.NewCustomerForm;
import io.cucumber.java8.En;

public class NewCustomerFormSteps implements En {

    NewCustomerForm newCustomerForm;

    public NewCustomerFormSteps(NewCustomerForm newCustomerForm) {
        this.newCustomerForm = newCustomerForm;

        When("I set customer \"Contact Info\"", newCustomerForm::setContactInfo);

        When("I set customer \"Address\"", newCustomerForm::setAddress);

        When("I set customer \"Notes\"", newCustomerForm::setNotes);

        When("I click \"CREATE CUSTOMER\" button", newCustomerForm::clickCreateCustomerButton);
    }
}
