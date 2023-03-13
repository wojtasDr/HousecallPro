package hcp.steps;

import hcp.pages.JobDetailsPage;
import hcp.validators.CommonValidators;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

public class JobDetailsPageSteps implements En {

    JobDetailsPage jobDetailsPage;
    CommonValidators commonValidators;

    public JobDetailsPageSteps(JobDetailsPage jobDetailsPage, CommonValidators commonValidators) {
        this.jobDetailsPage = jobDetailsPage;
        this.commonValidators = commonValidators;

        Then("Created job has following data in \"Activity feed section\"", (DataTable expectedData) -> {
            jobDetailsPage.expandAllActivityFeedPanels();
            String actualActivityFeedText = jobDetailsPage.getActivityFeedSectionText();
            commonValidators.checkIfTextContainsAllData(actualActivityFeedText, expectedData);
        });
    }
}
