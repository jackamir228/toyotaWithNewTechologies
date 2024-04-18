package types;

import components.Component;
import components.GasTank;
import components.Wheel;
import enums.CarType;
import enums.Color;
import enums.Speed;
import enums.Transmission;
import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import models.Car;

import java.math.BigDecimal;
import java.util.List;

@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NullCar extends Car {
    public NullCar(Color color, Speed speed, Transmission transmission, Boolean isMotionNow, List<Wheel> wheels,
                   GasTank gasTank, BigDecimal price, List<Component> components, CarType carType) {
        super(color, speed, transmission, isMotionNow, wheels, gasTank, price, components, CarType.NULL_CAR);
    }
}
