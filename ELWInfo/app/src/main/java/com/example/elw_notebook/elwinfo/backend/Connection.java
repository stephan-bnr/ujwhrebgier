package com.example.elw_notebook.elwinfo.backend;

import com.example.elw_notebook.elwinfo.dataObjects.Vehicle;

import java.util.List;

/**
 * Interface for Connection solutions for retrieving vehicle data sets.
 */
public interface Connection {
    /**
     * Returns a list of the names all available vehicles at the moment. List may be empty.
     * @return
     */
    public List<String> getAvailableVehicles();

    /**
     * Returns the corresponding vehicle object to the given name.
     * @param name
     * @return
     * @throws IllegalArgumentException if the vehicle isn't available anymore.
     */
    public Vehicle getVehicleByName(String name) throws IllegalArgumentException;


}
