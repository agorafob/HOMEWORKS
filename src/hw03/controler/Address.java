package hw03.controler;

import hw03.view.TextConstant;

public class Address implements TextConstant,RegexContainer {
    private String index;
    private String city;
    private String street;
    private String numberHouse;
    private String numberFlat;
    private UtilityController utilityController;

    Address(UtilityController utilityController){
        this.utilityController=utilityController;
    }

    public void setIndex() {
        this.index = utilityController.inputStringValueWithScanner(INDEX,REGEX_DIGITS);
    }

    public void setCity() {
        this.city = utilityController.inputStringValueWithScanner(CITY,REGEX_LINE_LAT);
    }

    public void setStreet() {
        this.street = utilityController.inputStringValueWithScanner(STREET,REGEX_LINE_LAT);
    }

    public void setNumberHouse() {
        this.numberHouse = utilityController.inputStringValueWithScanner(HOUSE,REGEX_DIGITS);
    }

    public void setNumberFlat() {
        this.numberFlat = utilityController.inputStringValueWithScanner(FLAT,REGEX_DIGITS);
    }


    @Override
    public String toString() {
        return "Address{" +
                "index='" + index + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberHouse='" + numberHouse + '\'' +
                ", numberFlat='" + numberFlat + '\'' +
                '}';
    }
}
