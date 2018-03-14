package com.example.elw_notebook.elwinfo.dataObjects;

import android.content.Context;
import android.content.res.Resources;

import com.example.elw_notebook.elwinfo.MainActivity;
import com.example.elw_notebook.elwinfo.R;

public enum Manufacturer {

    AUDI("AUDI"),
    OTHER("OTHER");

    private String name = null;

    private Manufacturer(String name) {
        this.name = name;
    }

    public String getName() {
        if (MainActivity.getContext() == null) {
            throw new NullPointerException("Application not running, Resources can't be fetched.");
        }
        int id = MainActivity.getContext().getResources().getIdentifier(this.getName(),
                "string", MainActivity.getContext().getPackageName());
        return MainActivity.getContext().getResources().getString(id);
    }

    public static Manufacturer getManufacturerByName(String name) {
        if (name.toLowerCase().contains(AUDI.getName().toLowerCase())) {
            return AUDI;
        } else {
            return OTHER;
        }
    }

}
