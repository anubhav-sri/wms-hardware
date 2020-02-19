package com.sai.wms.hardwaremodule.models;

public interface Device {
    public CurrentReading getCurrentReading();

    public double getValue();

    public String getBoardName();

    public TempScale getScale();
}
