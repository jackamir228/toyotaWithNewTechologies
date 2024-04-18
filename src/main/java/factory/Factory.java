package factory;

import components.Component;
import enums.ComponentType;
import components.GasTank;
import components.Wheel;
import enums.Country;

import java.util.List;

import static enums.ComponentType.ENGINE;

public class Factory {
    Country country;


    public List<Component> makeBaseComponents() {
        return List.of(
                new Component(ENGINE, true),
                new Component(ComponentType.ELECTRICIAN, true),
                new Component(ComponentType.LIGHTS, true)
        );
    }

    public List<Wheel> makeWheels(Integer diameter) {
        return List.of(
                new Wheel(diameter, false),
                new Wheel(diameter, false),
                new Wheel(diameter, false),
                new Wheel(diameter, false)
        );
    }

    public Component makeCruiseControl() {
        return new Component(ComponentType.CRUISE_CONTROL, true);
    }

    public Component makeFridge() {
        return new Component(ComponentType.FRIDGE, true);
    }

    public Component makeRosette() {
        return new Component(ComponentType.FRIDGE, true);
    }

    public Component makeUsb() {
        return new Component(ComponentType.USB, true);
    }

    public Component makeRoof() {
        return new Component(ComponentType.ROOF, true);
    }

    public GasTank makeGazTank() {
        return new GasTank(0);
    }

    public Wheel makeWheel(Integer diameter) {
        return new Wheel(diameter, false);
    }
}
