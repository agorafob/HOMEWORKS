package hw03.controler;

public interface RegexContainer {
    String REGEX_LINE_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_LINE_LAT = "^[A-Z][a-z]{1,20}$";
    String REGEX_LOGIN = "^[A-Za-z0-9_-]{8,20}$";
    String REGEX_SKYPE = "^[A-Za-z0-9_-]{1,20}$";
    String REGEX_PHONE =  "^[0-9]{10}+$";
    String REGEX_DIGITS = "^[0-9]+$";
    String REGEX_DATE = "^\\d{2}-\\d{2}-\\d{2}";
    String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
}
