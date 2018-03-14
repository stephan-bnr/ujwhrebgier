package com.example.elw_notebook.elwinfo.dataObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * List of vehicle data sets.
 */
public class VehicleList {

    private List<Vehicle> vehicles = new ArrayList<>();

    public VehicleList() {

    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Adds vehicle to list. Must have a valid name and a new unique vehicle indent number.
     *
     * @param newVehicle
     * @return
     */
    public void addVehicle(Vehicle newVehicle) throws IllegalArgumentException {
        if (newVehicle == null) {
            throw new IllegalArgumentException("Vehicle must be valid");
        }
        if (newVehicle.getVehicleName() == null || newVehicle.getVehicleName().equals("")) {
            throw new IllegalArgumentException("Vehicle name must be valid");
        }
        if (newVehicle.getVehicleIdentificationNumber() == null
                || newVehicle.getVehicleIdentificationNumber().equals("")) {
            throw new IllegalArgumentException("Vehicle identification number must be valid");
        }

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleIdentificationNumber()
                    .equalsIgnoreCase(newVehicle.getVehicleIdentificationNumber())) {
                throw new IllegalArgumentException("The vehicle is already in list.");
            }
        }
        vehicles.add(newVehicle);
    }

    /**
     * Deletes Vehicle.
     * @param vehicle
     * @throws IllegalArgumentException if it can't be found.
     */
    public void removeVehicle(Vehicle vehicle) throws IllegalArgumentException {
        if(vehicle == null) {
            throw new IllegalArgumentException("Vehicle must be valid");
        }
        if(!vehicles.remove(vehicle)){
            throw new IllegalArgumentException("Vehicle is not in the list.");
        }
    }

    /**
     * Deletes Vehicle.
     * @param vin vehicle identification number.
     * @throws IllegalArgumentException if it can't be found.
     */
    public void removeVehicle(String vin) throws IllegalArgumentException {
        if(vin == null || vin.equals("")) {
            throw new IllegalArgumentException("Vehicle Identification Number must be valid");
        }
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleIdentificationNumber()
                    .equalsIgnoreCase(vin)) {
                vehicles.remove(vehicle);
            }
        }
        throw new IllegalArgumentException("Vehicle is not in the list.");
    }

    /**
     * Tries to find the vehicle in multiple rounds. If none can be found null is returned.
     *
     * @param name
     * @return
     * @throws IllegalArgumentException if string is empty or null
     */
    public Vehicle getVehicleByName(String name) throws IllegalArgumentException {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        // First round: equals ignoring case.
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleName().equalsIgnoreCase(name)) {
                return vehicle;
            }
        }
        // Second round: name containing manufacturer name ignoring case.
        for (Vehicle vehicle : vehicles) {
            if (name.toLowerCase().contains(vehicle.getVehicleName().toLowerCase())) {
                return vehicle;
            }
        }
        // Third round: manufacturer name containing name ignoring case.
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleName().toLowerCase().contains(name.toLowerCase())) {
                return vehicle;
            }
        }
        // Forth round: Levenshtein distance 1 ignoring case.
        for (Vehicle vehicle : vehicles) {
            if (General.LevenshteinDistance(name.toLowerCase(), vehicle.getVehicleName().toLowerCase()) <= 1) {
                return vehicle;
            }
        }
        // Fifth round: Levenshtein distance 2 ignoring case.
        for (Vehicle vehicle : vehicles) {
            if (General.LevenshteinDistance(name.toLowerCase(), vehicle.getVehicleName().toLowerCase()) <= 2) {
                return vehicle;
            }
        }
        // Sixth round: Levenshtein distance 3 ignoring case.
        for (Vehicle vehicle : vehicles) {
            if (General.LevenshteinDistance(name.toLowerCase(), vehicle.getVehicleName().toLowerCase()) <= 3) {
                return vehicle;
            }
        }
        return null;
    }

    /**
     * Returns null if not in list.
     * @param vin
     * @return
     */
    public Vehicle getVehicleByVIN(String vin) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleIdentificationNumber().equalsIgnoreCase(vin)){
                return vehicle;
            }
        }
        return null;
    }

}
