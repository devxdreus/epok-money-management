package model;

public class Model_Kartu {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public Model_Kartu(String title, String values) {
        this.title = title;
        this.values = values;
    }

    public Model_Kartu() {
    }

    private String title;
    private String values;
}
