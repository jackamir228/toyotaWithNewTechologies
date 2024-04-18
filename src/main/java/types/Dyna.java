package types;

import components.Component;
import enums.ComponentType;
import components.GasTank;
import components.Wheel;
import enums.*;
import models.Truck;

import java.math.BigDecimal;
import java.util.List;

public class Dyna extends Truck {

    Component rosette = new Component(ComponentType.ROSETTE, true);

    public Dyna(Color color, Speed speed, Transmission transmission, Boolean isMotionNow, List<Wheel> wheels,
                GasTank gasTank, BigDecimal price, List<Component> components, CarType carType,
                CarryingCapacity capacity, Component rosette) {
        super(color, speed, transmission, isMotionNow, wheels, gasTank, price, components, carType, capacity);
        this.rosette = rosette;
    }
}
