package com.sai.wms.hardwaremodule.controllers;

import com.sai.wms.hardwaremodule.models.Device;
import com.sai.wms.hardwaremodule.services.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TemperatureDeviceController {
    private TemperatureService temperatureService;

    @Autowired
    public TemperatureDeviceController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/registered-temperature-devices")
    public List<Device> getAllDevicesOnBoard() {
        return temperatureService.getAllDevices();
    }
}
