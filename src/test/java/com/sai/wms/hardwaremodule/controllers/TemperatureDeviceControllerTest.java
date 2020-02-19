package com.sai.wms.hardwaremodule.controllers;

import com.sai.wms.hardwaremodule.models.Device;
import com.sai.wms.hardwaremodule.models.TempScale;
import com.sai.wms.hardwaremodule.models.TemperatureSensorDevice;
import com.sai.wms.hardwaremodule.services.TemperatureService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TemperatureDeviceControllerTest {

    @Mock
    private TemperatureService temperatureService;

    @Test
    void shouldGetAllTemperatureDevices() {
        TemperatureSensorDevice device = new TemperatureSensorDevice("sensor-1", 34.45, TempScale.FARENHEIT);
        when(temperatureService.getAllDevices()).thenReturn(List.of(device));
        List<Device> actualDevices = new TemperatureDeviceController(temperatureService).getAllDevicesOnBoard();

        assertThat(actualDevices).isEqualTo(List.of(device));

    }
}