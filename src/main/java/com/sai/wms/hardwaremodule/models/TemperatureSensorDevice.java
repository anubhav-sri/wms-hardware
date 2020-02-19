package com.sai.wms.hardwaremodule.models;

public class TemperatureSensorDevice implements Device {
    private String boardName;
    private final double temperature;
    private final TempScale farenHeit;

    public TemperatureSensorDevice(String boardName, double temperature, TempScale farenHeit) {
        this.boardName = boardName;
        this.temperature = temperature;
        this.farenHeit = farenHeit;
    }

    @Override
    public CurrentReading getCurrentReading() {
        return null;
    }
}
