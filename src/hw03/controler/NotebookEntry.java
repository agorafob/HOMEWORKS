package hw03.controler;

import java.util.Scanner;

import hw03.view.TextConstant;
import hw03.view.View;

public class NotebookEntry implements TextConstant, RegexContainer {
    private UtilityController utilityController;

    private String firstName;
    private String secondName;
    private String fathersName;
    private String login;
    private String group;
    private String phoneNumberHome;
    private String phoneNumberMobile;
    private String email;
    private String skype;
    private Address address;
    private String currentDate;

    public NotebookEntry(View view, Scanner sc) {
        this.utilityController = new UtilityController(sc, view);
    }

    public void inputNote() {
        String str = (String.valueOf(View.bundle.getLocale()).equals("en"))
                ? REGEX_LINE_UKR : REGEX_LINE_LAT;
        setFirstName(str);
        setSecondName(str);
        setFathersName(str);
        setLogin();
        setGroup();
        setPhoneNumberHome();
        setPhoneMobile();
        setEmail();
        setSkype();
        setAddress();
        setCurrentDate();

    }

    private void setFirstName(String str) {
        this.firstName =
                utilityController.inputStringValueWithScanner
                        (FIRST_NAME, str);
    }

    private void setSecondName(String str) {
        this.secondName = utilityController.inputStringValueWithScanner
                (SECOND_NAME, str);
    }

    private void setFathersName(String str) {
        this.fathersName = utilityController.inputStringValueWithScanner(FATHERS_NAME, str);
    }

    private void setLogin() {
        this.login = utilityController.inputStringValueWithScanner(LOGIN_DATA, REGEX_LOGIN);
    }

    private void setGroup() {
        String temp = utilityController.inputStringValueWithScanner(GROUP_NAME, REGEX_LINE_LAT);
        while (!temp.equals(Group.ADMIN.title) & !temp.equals(Group.PROFESSOR.title) & !temp.equals(Group.STUDENT.title)) {
            setGroup();
        }
        this.group = temp;
    }

    private void setPhoneNumberHome() {
        this.phoneNumberHome = utilityController.inputStringValueWithScanner(PHONE_NUMBER_HOME,REGEX_PHONE);
    }

    private void setPhoneMobile() {
        this.phoneNumberMobile = utilityController.inputStringValueWithScanner(PHONE_NUMBER_MOBILE,REGEX_PHONE);
    }

    private void setEmail() {
        this.email = utilityController.inputStringValueWithScanner(EMAIL_ADDRESS,REGEX_EMAIL);
    }

    private void setSkype() {
        this.skype = utilityController.inputStringValueWithScanner(SKYPE, REGEX_SKYPE);;
    }

    private void setAddress() {
       this.address=new Address(utilityController);
       address.setIndex();
       address.setCity();
       address.setStreet();
       address.setNumberHouse();
       address.setNumberFlat();
    }

    private void setCurrentDate() {
        this.currentDate = utilityController.inputStringValueWithScanner(CURRENT_DATE,REGEX_DATE);
    }

    @Override
    public String toString() {
        return "NotebookEntry{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", login='" + login + '\'' +
                ", group='" + group + '\'' +
                ", phoneNumberHome='" + phoneNumberHome + '\'' +
                ", phoneNumberMobile='" + phoneNumberMobile + '\'' +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                ", address=" + address +
                ", currentDate='" + currentDate + '\'' +
                '}';
    }
}
