package models;

import components.Component;
import components.GasTank;
import components.Wheel;
import enums.*;

import java.math.BigDecimal;
import java.util.List;

public abstract class Truck extends Car {

    CarryingCapacity capacity;

    public Truck(Color color, Speed speed, Transmission transmission, Boolean isMotionNow,
                 List<Wheel> wheels, GasTank gasTank, BigDecimal price, List<Component> components,
                 CarType carType, CarryingCapacity capacity) {
        super(color, speed, transmission, isMotionNow, wheels, gasTank, price, components, carType);
        this.capacity = capacity;
    }
}
