package factory;

import enums.*;
import exceptions.CountyFactoryNotEqualException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import models.Car;
import types.*;

import java.math.BigDecimal;

import static enums.CarType.*;
import static enums.Color.BLACK;
import static enums.Color.WHITE;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Conveyor {
    Factory factory;

    public Conveyor(Factory factory) {
        //Не смог реализовать:
//        if (!this.factory.country.equals(factory.country)) {
//            throw new CountyFactoryNotEqualException("страна &s не совпала с cтраной %s",
//                    this.factory.country, factory.country);
//        }
        this.factory = factory;
    }

    public Camry createCamry(Color color, BigDecimal price) {
        return new Camry(color, Speed.CAMRY_SPEED, Transmission.MECHANIC,
                false, factory.makeWheels(17), factory.makeGazTank(), price, factory.makeBaseComponents(),
                CAMRY, factory.makeCruiseControl(), factory.makeUsb());
    }

    public Solara createSolara(Color color, BigDecimal price) {
        return new Solara(color, Speed.SOLARA_SPEED, Transmission.AUTOMATIC, false,
                factory.makeWheels(16), factory.makeGazTank(), price, factory.makeBaseComponents(), SOLARA,
                factory.makeRoof(), factory.makeFridge());
    }

    public Hiance createHiance(Color color, BigDecimal price) {
        return new Hiance(color, Speed.HIANCE_SPEED, Transmission.AUTOMATIC, false,
                factory.makeWheels(20), factory.makeGazTank(), price, factory.makeBaseComponents(), HIANCE,
                CarryingCapacity.HIANCE_CAPACITY, factory.makeWheel(20));
    }

    public Dyna createDyna(Color color, BigDecimal price) {
        return new Dyna(color, Speed.DYNA_SPEED, Transmission.AUTOMATIC, false, factory.makeWheels(20),
                factory.makeGazTank(), price, factory.makeBaseComponents(),
                DYNA, CarryingCapacity.DYNA_CAPACITY, factory.makeRosette());
    }

    public NullCar createNullCar() {
        return new NullCar(WHITE, Speed.DEFAULT_SPEED, Transmission.AUTOMATIC, false,
                factory.makeWheels(1), factory.makeGazTank(), new BigDecimal(0),
                factory.makeBaseComponents(), NULL_CAR);
    }

    public Car createCar(CarType carType) {
        if (carType.equals(CAMRY)) {
            return createCamry(BLACK, CAMRY.getPrice());
        } else if (carType.equals(SOLARA)) {
            return createSolara(BLACK, SOLARA.getPrice());
        } else if (carType.equals(HIANCE)) {
            return createHiance(BLACK, HIANCE.getPrice());
        } else if (carType.equals(DYNA)) {
            return createDyna(BLACK, DYNA.getPrice());
        } else if (carType.equals(NULL_CAR)) {
            return createNullCar();
        }
        throw new RuntimeException("машины с такой моделью не найдено");
    }
}
