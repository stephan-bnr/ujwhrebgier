package com.example.elw_notebook.elwinfo.dataObjects;

/**
 * Class representing a real live vehicle manufacturer. The name is unique.
 */
public class Manufacturer {
    public Manufacturer(String name) {
        this.name = name;
    }

    public Manufacturer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
