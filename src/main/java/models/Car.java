package models;

import components.*;
import enums.*;
import exceptions.StartCarException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

import enums.ComponentType;

import static enums.ComponentType.ENGINE;
import static enums.ComponentType.ELECTRICIAN;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Car {

    Color color;
    Speed speed;
    Transmission transmission;
    Boolean isMotionNow;

    List<Wheel> wheels = List.of(
            new Wheel(0, false),
            new Wheel(0, false),
            new Wheel(0, false),
            new Wheel(0, false)
    );
    GasTank gasTank;
    BigDecimal price;
    List<Component> components = List.of(
            new Component(ENGINE, true),
            new Component(ELECTRICIAN, true),
            new Component(ComponentType.LIGHTS, true)
    );
    CarType carType;

    public Car(Color color, Speed speed, Transmission transmission, Boolean isMotionNow, List<Wheel> wheels,
               GasTank gasTank, BigDecimal price, List<Component> components, CarType carType) {
        this.color = color;
        this.speed = speed;
        this.transmission = transmission;
        this.isMotionNow = isMotionNow;
        this.wheels = wheels;
        this.gasTank = gasTank;
        this.price = price;
        this.components = components;
        this.carType = carType;
    }

    public void start() {
        if (this.wheels.size() < 4) {
            throw new StartCarException("Недостаточно колес для старта");
        }
        if (!this.wheels.stream().noneMatch(Wheel::getIsBroken)) throw new StartCarException("Колесо сломанно");
        if (this.gasTank.getFuel() == 0) {
            throw new StartCarException("Отсутствует топливо");
        }
        if (components.stream()
                .anyMatch(component -> component.equals(new Component(ENGINE, true)) && !component.getIsWorkable())) {
            throw new StartCarException("Двигатель сломан");
        } else if (components.stream()
                .anyMatch(component -> (component.getComponentType() == ELECTRICIAN) && !component.getIsWorkable())) {
            throw new StartCarException("Элекроника сломана");
        }
        setIsMotionNow(true);
        System.out.println("Машина поехала");
    }

    public void stop() {
        setIsMotionNow(false);
        System.out.println("Машина остановилась");
    }

    public void turnOnLights() {
        components.stream()
                .filter(component -> component.getComponentType() == ELECTRICIAN)
                .forEach(component -> {
                    component.setIsWorkable(true);
                    System.out.println("Фары включены");
                });
    }

    public void turnOffLights() {
        components.stream()
                .filter(component -> component.getComponentType() == ELECTRICIAN)
                .forEach(component -> {
                    component.setIsWorkable(false);
                    System.out.println("Фары выключены");
                });
    }
}


