package shop;

import enums.CarType;
import enums.Color;
import exceptions.CarNotFoundInStorageException;
import exceptions.SaleCarException;
import factory.Conveyor;
import factory.Factory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import models.*;
import garage.Garage;
import types.Camry;
import types.Dyna;
import types.Hiance;
import types.Solara;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import static enums.CarType.*;

@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Manager {
    String name;

    public Manager(String name) {
        this.name = name;
    }

    public Car sale(Consumer consumer, Garage garage) {
        if (consumer.getMoney().compareTo(new BigDecimal(10_000)) < 0) {
            return garage.getCar(NULL_CAR);
        }
        return saleHelper(consumer, garage);
    }

    private Car saleHelper(Consumer consumer, Garage garage) {
        Factory factory = new Factory();
        Conveyor conveyor = new Conveyor(factory);

        if (consumer.getMoney().compareTo(DYNA.getPrice()) >= 0) {
            return garage.getCar(DYNA);
        } else if (garage == null) {
            garage.addCar(conveyor.createCar(DYNA));
        }
        if (consumer.getMoney().compareTo(HIANCE.getPrice()) >= 0) {
            return garage.getCar(HIANCE);
        } else if (garage == null) {
            garage.addCar(conveyor.createCar(HIANCE));
        }
        if (consumer.getMoney().compareTo(SOLARA.getPrice()) >= 0) {
            return garage.getCar(SOLARA);
        } else if (garage == null) {
            garage.addCar(conveyor.createCar(SOLARA));
        }
        if (consumer.getMoney().compareTo(CAMRY.getPrice()) >= 0) {
            return garage.getCar(CAMRY);
        } else if (garage == null) {
            garage.addCar(conveyor.createCar(CAMRY));
        }
        throw new RuntimeException("jib,rf");
    }
}
