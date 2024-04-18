package types;

import components.Component;
import components.GasTank;
import components.Wheel;
import enums.*;
import models.Truck;

import java.math.BigDecimal;
import java.util.List;

public class Hiance extends Truck {

    Wheel spareWheel;

    public Hiance(Color color, Speed speed, Transmission transmission, Boolean isMotionNow, List<Wheel> wheels,
                  GasTank gasTank, BigDecimal price, List<Component> components, CarType carType,
                  CarryingCapacity capacity, Wheel spareWheel) {
        super(color, speed, transmission, isMotionNow, wheels, gasTank, price, components, carType, capacity);
        this.spareWheel = spareWheel;
    }
}
