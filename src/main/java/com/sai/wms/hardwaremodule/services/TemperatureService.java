package com.sai.wms.hardwaremodule.services;

import com.sai.wms.hardwaremodule.hardwares.RaspberryPi;
import com.sai.wms.hardwaremodule.models.Device;
import com.sai.wms.hardwaremodule.models.TemperatureSensorDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureService {
    private final RaspberryPi raspberryPi;

    @Autowired
    public TemperatureService(RaspberryPi raspberryPi) {
        this.raspberryPi = raspberryPi;
    }

    public List<Device> getAllDevices() {
        return raspberryPi.getAllTemperatureSensors();
    }
}
