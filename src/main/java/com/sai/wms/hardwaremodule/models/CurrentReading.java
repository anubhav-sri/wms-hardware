package com.sai.wms.hardwaremodule.models;

public class CurrentReading {
    private final double value;
    private final Scale scale;

    public CurrentReading(double value, Scale scale) {
        this.value = value;
        this.scale = scale;
    }

    public double getValue() {
        return value;
    }

    public Scale getScale() {
        return scale;
    }
}
