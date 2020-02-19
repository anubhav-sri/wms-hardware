package com.sai.wms.hardwaremodule.controllers.it;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.component.temperature.TemperatureSensorBase;
import com.pi4j.io.w1.W1Master;
import com.pi4j.temperature.TemperatureScale;
import com.sai.wms.hardwaremodule.models.TempScale;
import com.sai.wms.hardwaremodule.models.TemperatureSensorDevice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TemperatureDeviceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private W1Master w1Master;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldBeAbleToGetTheDevicesConnected() throws Exception {
        when(w1Master.getDevices(TemperatureSensor.class)).thenReturn(List.of(new TestSensor()));
        mockMvc
                .perform(get("/registered-temperature-devices"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(List.of(new TemperatureSensorDevice("test-name", 43.34, TempScale.FARENHEIT)))));

    }

    private static class TestSensor extends TemperatureSensorBase {

        @Override
        public double getTemperature() {
            return 43.34;
        }

        @Override
        public double getTemperature(TemperatureScale scale) {
            return 43.34;
        }

        @Override
        public TemperatureScale getScale() {
            return TemperatureScale.FARENHEIT;
        }

        @Override
        public String getName() {
            return "test-name";
        }
    }
}
