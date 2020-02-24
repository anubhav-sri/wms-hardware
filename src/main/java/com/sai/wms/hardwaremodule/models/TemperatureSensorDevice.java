package com.sai.wms.hardwaremodule.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class TemperatureSensorDevice implements Device {
    private String boardName;
    private CurrentReading currentReading;

    public TemperatureSensorDevice(String boardName, CurrentReading currentReading) {
        this.boardName = boardName;
        this.currentReading = currentReading;
    }

    @Override
    @JsonIgnore
    public CurrentReading getCurrentReading() {
        return currentReading;
    }

    @Override
    public String getBoardName() {
        return boardName;
    }
}
