package com.sai.wms.hardwaremodule.config;

import com.pi4j.io.w1.W1Master;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RaspberryPiConfig {

    @Bean
    public W1Master w1Master() {
        return new W1Master();
    }
}
