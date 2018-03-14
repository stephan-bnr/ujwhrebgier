package com.example.elw_notebook.elwinfo.dataObjects;


public class Vehicle {
    public Vehicle(String vehicleName, String manufacturer, String chassisNumber,
                   String automotiveBattery, String additionalBattery, String inputTerminalVoltage,
                   String supplyPressure, String fireWaterVolume, String general,
                   String miscellaneous) {
        this.vehicleName = vehicleName;
        this.manufacturer = manufacturer;
        this.chassisNumber = chassisNumber;
        this.automotiveBattery = automotiveBattery;
        this.additionalBattery = additionalBattery;
        this.inputTerminalVoltage = inputTerminalVoltage;
        this.supplyPressure = supplyPressure;
        this.fireWaterVolume = fireWaterVolume;
        this.general = general;
        this.miscellaneous = miscellaneous;
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
    public String getManufacturer() {
        if (manufacturer == null || manufacturer.equals("")) {
            return null;
        }
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * returns null if not available.
     *
     * @return
     */
    public String getChassisNumber() {
        if (chassisNumber == null || chassisNumber.equals("")) {
            return null;
        }
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
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
    private String manufacturer = "";
    private String chassisNumber = "";
    private String automotiveBattery = "";
    private String additionalBattery = "";
    private String inputTerminalVoltage = "";
    private String supplyPressure = "";
    private String fireWaterVolume = "";
    private String general = "";
    private String miscellaneous = "";
}
