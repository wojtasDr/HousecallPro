package hcp.validators;

import io.cucumber.datatable.DataTable;
import org.assertj.core.api.Assertions;
import org.springframework.stereotype.Component;

@Component
public class CommonValidators {
    /**
     * This method validates if given text contains all expected substrings
     *
     * @param givenText    text to be examined
     * @param expectedData expected substrings of given text
     */
    public void checkIfTextContainsAllData(String givenText, DataTable expectedData) {
        expectedData.asList().forEach((eD) -> Assertions.assertThat(givenText).contains(eD));
    }
}
