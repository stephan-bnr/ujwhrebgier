package com.example.elw_notebook.elwinfo.dataObjects;

import com.example.elw_notebook.elwinfo.MainActivity;

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

    private List<Manufacturer> manufacturers = null;

    public List<Manufacturer> getMaufacturers() {
        return manufacturers;
    }

    /**
     * Returns true if successful. False if the manufacturer name is empty or already exists.
     * Not case sensitive.
     *
     * @param newManufacturer
     * @return
     */
    public boolean addManufacturer(Manufacturer newManufacturer) {
        // Test if empty.
        if (newManufacturer.getName() == null || newManufacturer.getName().equals("")) {
            return false;
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
        }
        return newMan;
    }

    /**
     * Deletes manufacturer. Returns true if successful, false if they can't be found.
     *
     * @param name
     * @return
     */
    public boolean removeManufacturer(String name) {
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.getName().equalsIgnoreCase(name)) {
                manufacturers.remove(manufacturer);
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes manufacturer. Returns true if successful, false if they can't be found.
     *
     * @param manufacturer
     * @return
     */
    public boolean removeManufacturer(Manufacturer manufacturer) {
        try {
            return manufacturers.remove(manufacturer);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
        // Third round: Levenshtein distance 1 ignoring case.
        for (Manufacturer manufacturer : manufacturers) {
            if (LevenshteinDistance(name.toLowerCase(), manufacturer.getName().toLowerCase()) <= 1) {
                return manufacturer;
            }
        }
        // Forth round: Levenshtein distance 2 ignoring case.
        for (Manufacturer manufacturer : manufacturers) {
            if (LevenshteinDistance(name.toLowerCase(), manufacturer.getName().toLowerCase()) <= 2) {
                return manufacturer;
            }
        }
        // Fifth round: Levenshtein distance 3 ignoring case.
        for (Manufacturer manufacturer : manufacturers) {
            if (LevenshteinDistance(name.toLowerCase(), manufacturer.getName().toLowerCase()) <= 3) {
                return manufacturer;
            }
        }
        return null;
    }

    /**
     * Calculates recursively the difference between two strings.
     *
     * @param string1
     * @param string2
     * @return
     */
    private int LevenshteinDistance(String string1, String string2) {
        int cost;
        int string1Length = string1.length();
        int string2Length = string2.length();
        char[] charArray1 = string1.toCharArray();
        char[] charArray2 = string2.toCharArray();

        /* base case: empty strings */
        if (string1Length == 0) return string2Length;
        if (string2Length == 0) return string1Length;

        /* test if last characters of the strings match */
        if (charArray1[string1Length - 1] == charArray2[string2Length - 1])
            cost = 0;
        else
            cost = 1;

        /* return minimum of delete char from s, delete char from t, and delete char from both */
        return Math.min(Math.min((LevenshteinDistance(new String(charArray1), new String(charArray2)) + 1),
                (LevenshteinDistance(new String(charArray1), new String(charArray2)) + 1)),
                (LevenshteinDistance(new String(charArray1), new String(charArray2)) + cost));
    }


}
