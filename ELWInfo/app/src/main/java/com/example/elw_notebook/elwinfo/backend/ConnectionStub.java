package com.example.elw_notebook.elwinfo.backend;

import com.example.elw_notebook.elwinfo.dataObjects.Manufacturer;
import com.example.elw_notebook.elwinfo.dataObjects.ManufacturerList;
import com.example.elw_notebook.elwinfo.dataObjects.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Test connection. Returns a test set of vehicle data.
 */
public class ConnectionStub implements Connection {
    List<Vehicle> vehicleList = null;

    public ConnectionStub() {
        ManufacturerList manufacturerList = new ManufacturerList(true);
        Manufacturer daimlerBenz = manufacturerList.getManufacturerByName("daimler");
        Manufacturer ford = manufacturerList.getManufacturerByName("ford");
        Manufacturer vw = manufacturerList.getManufacturerByName("volkswagen");
        Manufacturer man = manufacturerList.getManufacturerByName("man");

        Vehicle elwFrankfurt = new Vehicle("ELWFrankfurt", daimlerBenz,
                "WDD 169 007-1J-236589", "12,6V",
                "12,8V", "230V", "50Hz",
                "10bar", "500L", "", "");

        Vehicle elwMainz = new Vehicle("ELWMainz", vw,
                "WVWZZZ1JZ3W386752", "12,8V",
                "11,8V", "110V", "60Hz",
                "20bar", "750L", "Feuerwehr Einsatzleitung",
                "");
        vehicleList = new ArrayList<Vehicle>();
        vehicleList.add(elwFrankfurt);
        vehicleList.add(elwMainz);
    }

    @Override
    public List<String> getAvailableVehicles() {
        List<String> names = new ArrayList<String>();
        for (Vehicle vehicle : vehicleList) {
            names.add(vehicle.getVehicleName());
        }
        return new ArrayList<String>(names);
    }

    @Override
    public Vehicle getVehicleByName(String name) throws IllegalArgumentException {
        for (Vehicle vehicle : vehicleList) {
            if (name.equalsIgnoreCase(vehicle.getVehicleName())) {
                return vehicle;
            }
        }
        throw new IllegalArgumentException("not found");
    }
}
