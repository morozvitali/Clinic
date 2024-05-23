package org.police.model;

public class Dog extends Pet {
    private String size;

    public void setBank (String size) {
        this.size = size;
    }

    public String getSize () {
        return size;
    }
}
