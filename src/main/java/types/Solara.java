package types;

import components.Component;
import enums.ComponentType;
import components.GasTank;
import components.Wheel;
import enums.CarType;
import enums.Color;
import enums.Speed;
import enums.Transmission;
import exceptions.NoSuchComponentException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import models.Cabriolet;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Solara extends Cabriolet {
    Component fridge = new Component(ComponentType.FRIDGE, true);

    public Solara(Color color, Speed speed, Transmission transmission, Boolean isMotionNow, List<Wheel> wheels,
                  GasTank gasTank, BigDecimal price, List<Component> components, CarType carType, Component roof,
                  Component fridge) {
        super(color, speed, transmission, isMotionNow, wheels, gasTank, price, components, carType, roof);
        this.fridge = fridge;
    }

    public void coolTheDrink() {
        if (fridge.getComponentType() == ComponentType.FRIDGE) {
            fridge.setIsWorkable(true);
            System.out.println("напиток охлаждается");
        } else {
            throw new NoSuchComponentException("Такого компонента нет");
        }
    }
}
