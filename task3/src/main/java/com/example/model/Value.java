package com.example.model;

public class Value {
    long id;
    String value;

    public Value(long id, String value) {
            this.id = id;
            this.value = value;
        }
        
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", value = " + value;
    }
}
