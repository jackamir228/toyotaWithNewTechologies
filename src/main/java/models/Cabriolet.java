package models;

import components.Component;
import enums.ComponentType;
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

public abstract class Cabriolet extends Car {
    Component roof = new Component(ComponentType.ROOF, true);

    public Cabriolet(Color color, Speed speed, Transmission transmission, Boolean isMotionNow,
                     List<Wheel> wheels, GasTank gasTank, BigDecimal price, List<Component> components,
                     CarType carType, Component roof) {
        super(color, speed, transmission, isMotionNow, wheels, gasTank, price, components, carType);
        this.roof = roof;
    }

    public void raiseTheRoof() {
        if (roof.getComponentType() == ComponentType.ROOF) {
            roof.setIsWorkable(true);
            System.out.println("Крыша поднята");
        }
    }

    public void lowerTheRoof() {
        if (roof.getComponentType() == ComponentType.ROOF) {
            roof.setIsWorkable(false);
            System.out.println("Крыша опущена");
        }
    }
}
