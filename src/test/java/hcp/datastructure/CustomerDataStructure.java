package hcp.datastructure;

import lombok.Getter;

public enum CustomerDataStructure {
    //Contact info
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    MOBILE_PHONE("mobilePhone"),
    COMPANY("company"),
    DISPLAY_NAME("displayName"),
    HOME_PHONE("homePhone"),
    JOB_TITLE("jobTitle"),
    EMAIL("email"),
    WORK_PHONE("workPhone"),
    //Address
    STREET("street"),
    UNIT("unit"),
    CITY("city"),
    STATE("state"),
    ZIP("zip"),
    ADDRESS_NOTES("addressNotes"),
    //Notes
    CUSTOMER_NOTES("customerNotes"),
    THIS_CUSTOMER_BILLS_TO("thisCustomerBillsTo"),
    CUSTOMER_TAGS("customerTags"),
    LEAD_SOURCE("leadSource");

    @Getter
    private String fieldName;

    CustomerDataStructure(String fieldName) {
        this.fieldName = fieldName;
    }
}
