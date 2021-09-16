package hw03.controler;

public enum Group {

    STUDENT("Student"),
    ADMIN("Admin"),
    PROFESSOR("Professor");

    String title;

    Group(String title) {
        this.title=title;
    }
}
