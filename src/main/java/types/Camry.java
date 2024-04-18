package types;

import components.Component;
import enums.ComponentType;
import components.GasTank;
import components.Wheel;
import enums.CarType;
import enums.Color;
import enums.Speed;
import enums.Transmission;
import models.PassengerCar;

import java.math.BigDecimal;
import java.util.List;

public class Camry extends PassengerCar {

    Component usb = new Component(ComponentType.USB, true);

    public Camry(Color color, Speed speed, Transmission transmission, Boolean isMotionNow, List<Wheel> wheels,
                 GasTank gasTank, BigDecimal price, List<Component> components, CarType carType,
                 Component cruiseControl, Component usb) {
        super(color, speed, transmission, isMotionNow, wheels, gasTank, price, components, carType, cruiseControl);
        this.usb = usb;
    }

    public void turnOnUsb() {
        if (usb.getComponentType() == ComponentType.USB) {
            usb.setIsWorkable(true);
            System.out.println("Музыка включена");
        }
    }

    public void turnOffUsb() {
        if (usb.getComponentType() == ComponentType.USB) {
            usb.setIsWorkable(false);
            System.out.println("Музыка выключена");
        }
    }
}
