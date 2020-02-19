package com.sai.wms.hardwaremodule.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class TemperatureSensorDevice implements Device {
    private String boardName;
    private double value;
    private TempScale scale;

    public TemperatureSensorDevice(String boardName, double value, TempScale scale) {
        this.boardName = boardName;
        this.value = value;
        this.scale = scale;
    }

    @Override
    @JsonIgnore
    public CurrentReading getCurrentReading() {
        return null;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String getBoardName() {
        return boardName;
    }

    @Override
    public TempScale getScale() {
        return scale;
    }
}
