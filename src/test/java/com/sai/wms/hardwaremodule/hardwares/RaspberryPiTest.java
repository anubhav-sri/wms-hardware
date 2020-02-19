package com.sai.wms.hardwaremodule.hardwares;

import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.component.temperature.TemperatureSensorBase;
import com.pi4j.io.w1.W1Master;
import com.pi4j.temperature.TemperatureScale;
import com.sai.wms.hardwaremodule.models.Device;
import com.sai.wms.hardwaremodule.models.TempScale;
import com.sai.wms.hardwaremodule.models.TemperatureSensorDevice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RaspberryPiTest {
    @Mock
    private W1Master w1Master;

    @Test
    void shouldReadTheListOf1WireDevices() {
        List<TemperatureSensor> sensorList = List.of(new TestSensor());
        List<Device> expectedSensors = List.of(new TemperatureSensorDevice("test-sensor", 34.13, TempScale.FARENHEIT));
        when(w1Master.getDevices(TemperatureSensor.class)).thenReturn(sensorList);

        List<Device> actualSensors = new RaspberryPi(w1Master).getAllTemperatureSensors();
        assertThat(actualSensors).usingFieldByFieldElementComparator().isEqualTo(expectedSensors);
    }

    @Test
    void shouldReturnEmptyListIfNoSensorsAreConnected() {
        List<TemperatureSensor> sensorList = List.of();
        when(w1Master.getDevices(TemperatureSensor.class)).thenReturn(sensorList);

        List<Device> actualSensors = new RaspberryPi(w1Master).getAllTemperatureSensors();
        assertThat(actualSensors).isEmpty();
    }

    private static class TestSensor extends TemperatureSensorBase {

        @Override
        public double getTemperature() {
            return 34.13;
        }

        @Override
        public double getTemperature(TemperatureScale scale) {
            return 34.13;
        }

        @Override
        public TemperatureScale getScale() {
            return TemperatureScale.FARENHEIT;
        }

        @Override
        public String getName() {
            return "test-sensor";
        }
    }
}