package com.sai.wms.hardwaremodule.services;

import com.sai.wms.hardwaremodule.hardwares.RaspberryPi;
import com.sai.wms.hardwaremodule.models.Device;
import com.sai.wms.hardwaremodule.models.TemperatureSensorDevice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TemperatureServiceTest {

    @Mock
    private RaspberryPi raspberryPi;

    @Test
    public void shouldGetAllDevicesConnected() {
        List<Device> temperatureDevices = List.of(mock(Device.class));
        when(raspberryPi.getAllTemperatureSensors()).thenReturn(temperatureDevices);
        List<Device> allDevices = new TemperatureService(raspberryPi).getAllDevices();
        assertThat(allDevices).containsAll(temperatureDevices);
    }

}