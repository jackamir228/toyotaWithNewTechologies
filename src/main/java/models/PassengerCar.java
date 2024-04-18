package models;

import components.Component;
import components.GasTank;
import components.Wheel;
import enums.CarType;
import enums.Color;
import enums.Speed;
import enums.Transmission;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class PassengerCar extends Car {

    Component cruiseControl;

    public PassengerCar(Color color, Speed speed, Transmission transmission, Boolean isMotionNow,
                        List<Wheel> wheels, GasTank gasTank, BigDecimal price, List<Component> components,
                        CarType carType, Component cruiseControl) {
        super(color, speed, transmission, isMotionNow, wheels, gasTank, price, components, carType);
        this.cruiseControl = cruiseControl;
    }

    public void turnOnCruiseControl() {
        cruiseControl.setIsWorkable(true);
        System.out.println("Круиз контроль включен");
    }

    public void turnOffCruiseControl() {
        cruiseControl.setIsWorkable(false);
        System.out.println("Круиз контроль выключен");
    }
}
