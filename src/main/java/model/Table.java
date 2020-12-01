package model;

import java.util.ArrayList;

public class Table {

    private String name;
    private ArrayList<String> fields;
    
    public Table(String name) {
        this.name = name;
        this.fields = new ArrayList<>();
    }
    public void addField(String field){
        fields.add(field);
    }

    public ArrayList<String> getFields() {
        return fields;
    }

    public String getName() {
        return name;
    }
    
}
