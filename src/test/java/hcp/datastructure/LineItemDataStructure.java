package hcp.datastructure;

import lombok.Getter;

public enum LineItemDataStructure {
    DESCRIPTION("description"),
    NAME("name"),
    QTY("qty"),
    UNIT_COST("unitCost"),
    UNIT_PRICE("unitPrice");

    @Getter
    private String fieldName;

    LineItemDataStructure(String fieldName) {
        this.fieldName = fieldName;
    }
}
