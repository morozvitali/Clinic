package org.clinic.model;

public class Dog extends Pet {
    private String size;

    public void setSize (String size) {
        this.size = size;
    }

    public String getSize () {
        return size;
    }
}
