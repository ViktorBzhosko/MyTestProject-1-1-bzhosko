package by.ita.je.model.enums;

public enum PlaceOfSale {

    THE5ELEMENT("5element"),
    ELECTROSILA("Electrosila"),
    THE21VEK("21Vek");

    private final String message;

    PlaceOfSale(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
