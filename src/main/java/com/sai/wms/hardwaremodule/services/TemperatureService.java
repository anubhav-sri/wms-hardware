package com.sai.wms.hardwaremodule.services;

import com.sai.wms.hardwaremodule.hardwares.RaspberryPi;
import com.sai.wms.hardwaremodule.models.Device;

import java.util.List;

public class TemperatureService {
    private final RaspberryPi raspberryPi;

    public TemperatureService(RaspberryPi raspberryPi) {
        this.raspberryPi = raspberryPi;
    }

    public List<Device> getAllDevices() {
        return raspberryPi.getAllTemperatureSensors();
    }
}
