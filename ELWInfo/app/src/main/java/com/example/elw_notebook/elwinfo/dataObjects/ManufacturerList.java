package com.example.elw_notebook.elwinfo.dataObjects;

import com.example.elw_notebook.elwinfo.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * All the manufacturer the list currently knows. Contains Daimler, MAN, Ford, VW
 * and Other as default.
 */
public class ManufacturerList {
    public ManufacturerList() {

    }

    /**
     * Creates new ManufacturerList with default if withDefault is true. Otherwise the normal
     * constructor is called.
     *
     * @param withDefault
     */
    public ManufacturerList(Boolean withDefault) {
        this();

        if (withDefault) {
            if (MainActivity.getContext() == null) {
                throw new NullPointerException("Application not running, Resources can't be fetched.");
            }
            //Add Daimler
            int id = MainActivity.getContext().getResources().getIdentifier("DAIMLER",
                    "string", MainActivity.getContext().getPackageName());
            String name = MainActivity.getContext().getResources().getString(id);
            Manufacturer daimler = new Manufacturer(name);
            this.addManufacturer(daimler);

            //Add Ford
            id = MainActivity.getContext().getResources().getIdentifier("FORD",
                    "string", MainActivity.getContext().getPackageName());
            name = MainActivity.getContext().getResources().getString(id);
            Manufacturer ford = new Manufacturer(name);
            this.addManufacturer(ford);

            //Add VW
            id = MainActivity.getContext().getResources().getIdentifier("VW",
                    "string", MainActivity.getContext().getPackageName());
            name = MainActivity.getContext().getResources().getString(id);
            Manufacturer vw = new Manufacturer(name);
            this.addManufacturer(vw);

            //Add MAN
            id = MainActivity.getContext().getResources().getIdentifier("MAN",
                    "string", MainActivity.getContext().getPackageName());
            name = MainActivity.getContext().getResources().getString(id);
            Manufacturer man = new Manufacturer(name);
            this.addManufacturer(man);

            //Add Other
            id = MainActivity.getContext().getResources().getIdentifier("OTHER",
                    "string", MainActivity.getContext().getPackageName());
            name = MainActivity.getContext().getResources().getString(id);
            Manufacturer other = new Manufacturer(name);
            this.addManufacturer(other);
        }
    }

    private List<Manufacturer> manufacturers = new ArrayList<>();

    public List<Manufacturer> getMaufacturers() {
        return manufacturers;
    }

    /**
     * @param newManufacturer
     * @return
     * @throws IllegalArgumentException if the manufacturer name is empty or already exists.
     *                                  Not case sensitive.
     */
    public void addManufacturer(Manufacturer newManufacturer) throws IllegalArgumentException {
        // Test if empty.
        if (newManufacturer.getName() == null || newManufacturer.getName().equals("")) {
            throw new IllegalArgumentException("Manufacturer name must be valid.");
        }
        // Test if exists.
        boolean newMan = true;
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.getName().equalsIgnoreCase(newManufacturer.getName())) {
                newMan = false;
            }
        }
        if (newMan) {
            manufacturers.add(newManufacturer);
        } else {
            throw new IllegalArgumentException("Manufacturer already exits.");
        }
    }

    /**
     * Deletes manufacturer.
     *
     * @param name
     * @return
     * @throws IllegalArgumentException if they can't be found.
     */
    public void removeManufacturer(String name) throws IllegalArgumentException {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name must be valid");
        }
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.getName().equalsIgnoreCase(name)) {
                manufacturers.remove(manufacturer);
            }
        }
        throw new IllegalArgumentException("Manufacturer is not in the list.");
    }

    /**
     * Deletes manufacturer.
     *
     * @param manufacturer
     * @return
     * @throws IllegalArgumentException if they can't be found.
     */
    public void removeManufacturer(Manufacturer manufacturer) {
        if (manufacturer == null) {
            throw new IllegalArgumentException("Manufacturer must be valid");
        }
        if (!manufacturers.remove(manufacturer)) {
            throw new IllegalArgumentException("Manufacturer is not in the list.");
        }

    }

    /**
     * Tries to find the manufacturer in multiple rounds. If none can be found null is returned.
     *
     * @param name
     * @return
     * @throws IllegalArgumentException if string is empty or null
     */
    public Manufacturer getManufacturerByName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        // First round: equals ignoring case.
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.getName().equalsIgnoreCase(name)) {
                return manufacturer;
            }
        }
        // Second round: name containing manufacturer name ignoring case.
        for (Manufacturer manufacturer : manufacturers) {
            if (name.toLowerCase().contains(manufacturer.getName().toLowerCase())) {
                return manufacturer;
            }
        }
        // Third round: manufacturer name containing name ignoring case.
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.getName().toLowerCase().contains(name.toLowerCase())) {
                return manufacturer;
            }
        }
        // Forth round: Levenshtein distance 1 ignoring case.
        for (Manufacturer manufacturer : manufacturers) {
            if (General.LevenshteinDistance(name.toLowerCase(), manufacturer.getName().toLowerCase()) <= 1) {
                return manufacturer;
            }
        }
        // Fifth round: Levenshtein distance 2 ignoring case.
        for (Manufacturer manufacturer : manufacturers) {
            if (General.LevenshteinDistance(name.toLowerCase(), manufacturer.getName().toLowerCase()) <= 2) {
                return manufacturer;
            }
        }
        // Sixth round: Levenshtein distance 3 ignoring case.
        for (Manufacturer manufacturer : manufacturers) {
            if (General.LevenshteinDistance(name.toLowerCase(), manufacturer.getName().toLowerCase()) <= 3) {
                return manufacturer;
            }
        }
        return null;
    }

}
