package com.sai.wms.hardwaremodule.hardwares;

import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.io.w1.W1Master;
import com.pi4j.temperature.TemperatureScale;
import com.sai.wms.hardwaremodule.models.CurrentReading;
import com.sai.wms.hardwaremodule.models.Device;
import com.sai.wms.hardwaremodule.models.TempScale;
import com.sai.wms.hardwaremodule.models.TemperatureSensorDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RaspberryPi {
    private W1Master w1Master;

    @Autowired
    public RaspberryPi(W1Master w1Master) {
        this.w1Master = w1Master;
    }

    public List<Device> getAllTemperatureSensors() {
        List<TemperatureSensor> temperatureSensors = w1Master.getDevices(TemperatureSensor.class);
        return temperatureSensors.stream().map(ts -> new TemperatureSensorDevice(
                ts.getName(),
                new CurrentReading(ts.getTemperature(TemperatureScale.FARENHEIT),
                        TempScale.FARENHEIT))).collect(Collectors.toList());
    }
}
