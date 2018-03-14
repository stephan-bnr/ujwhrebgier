package com.example.elw_notebook.elwinfo.dataObjects;


/**
 * Class representing a vehicle data set.
 */
public class Vehicle {
    public String getInputFrequency() {
        if (inputFrequency == null || inputFrequency.equals("")) {
            return null;
        }
        return inputFrequency;
    }

    public void setInputFrequency(String inputFrequency) {
        this.inputFrequency = inputFrequency;
    }

    private String inputFrequency;

    public Vehicle(String vehicleName, Manufacturer manufacturer, String vehicleIdentificationNumber,
                   String automotiveBattery, String additionalBattery, String inputTerminalVoltage,
                   String inputFrequency, String supplyPressure, String fireWaterVolume,
                   String general, String miscellaneous) {
        this.setVehicleName(vehicleName);
        this.setManufacturer(manufacturer);
        this.setVehicleIdentificationNumber(vehicleIdentificationNumber);
        this.setAutomotiveBattery(automotiveBattery);
        this.setAdditionalBattery(additionalBattery);
        this.setInputTerminalVoltage(inputTerminalVoltage);
        this.setInputFrequency(inputFrequency);
        this.setSupplyPressure(supplyPressure);
        this.setFireWaterVolume(fireWaterVolume);
        this.setGeneral(general);
        this.setMiscellaneous(miscellaneous);
    }

    public Vehicle() {
    }

    /**
     * returns null if not available.
     *
     * @return
     */
    public String getVehicleName() {
        if (vehicleName == null || vehicleName.equals("")) {
            return null;
        }
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    /**
     * returns null if not available.
     *
     * @return
     */
    public Manufacturer getManufacturer() {
        if (manufacturer == null) {
            return null;
        }
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * returns null if not available.
     *
     * @return
     */
    public String getVehicleIdentificationNumber() {
        if (vehicleIdentificationNumber == null || vehicleIdentificationNumber.equals("")) {
            return null;
        }
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    /**
     * returns null if not available.
     *
     * @return
     */
    public String getAutomotiveBattery() {
        if (automotiveBattery == null || automotiveBattery.equals("")) {
            return null;
        }
        return automotiveBattery;
    }

    public void setAutomotiveBattery(String automotiveBattery) {
        this.automotiveBattery = automotiveBattery;
    }

    /**
     * returns null if not available.
     *
     * @return
     */
    public String getAdditionalBattery() {
        if (additionalBattery == null || additionalBattery.equals("")) {
            return null;
        }
        return additionalBattery;
    }

    public void setAdditionalBattery(String additionalBattery) {
        this.additionalBattery = additionalBattery;
    }

    /**
     * returns null if not available.
     *
     * @return
     */
    public String getInputTerminalVoltage() {
        if (inputTerminalVoltage == null || inputTerminalVoltage.equals("")) {
            return null;
        }
        return inputTerminalVoltage;
    }

    public void setInputTerminalVoltage(String inputTerminalVoltage) {
        this.inputTerminalVoltage = inputTerminalVoltage;
    }

    /**
     * returns null if not available.
     *
     * @return
     */
    public String getSupplyPressure() {
        if (supplyPressure == null || supplyPressure.equals("")) {
            return null;
        }
        return supplyPressure;
    }

    public void setSupplyPressure(String supplyPressure) {
        this.supplyPressure = supplyPressure;
    }

    /**
     * returns null if not available.
     *
     * @return
     */
    public String getFireWaterVolume() {
        if (fireWaterVolume == null || fireWaterVolume.equals("")) {
            return null;
        }
        return fireWaterVolume;
    }

    public void setFireWaterVolume(String fireWaterVolume) {
        this.fireWaterVolume = fireWaterVolume;
    }

    /**
     * returns null if not available.
     *
     * @return
     */
    public String getGeneral() {
        if (general == null || general.equals("")) {
            return null;
        }
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    /**
     * returns null if not available.
     *
     * @return
     */
    public String getMiscellaneous() {
        if (miscellaneous == null || miscellaneous.equals("")) {
            return null;
        }
        return miscellaneous;
    }

    public void setMiscellaneous(String miscellaneous) {
        this.miscellaneous = miscellaneous;
    }

    private String vehicleName = "";
    private Manufacturer manufacturer = null;
    private String vehicleIdentificationNumber = "";
    private String automotiveBattery = "";
    private String additionalBattery = "";
    private String inputTerminalVoltage = "";
    private String supplyPressure = "";
    private String fireWaterVolume = "";
    private String general = "";
    private String miscellaneous = "";
}
