package shop;

import enums.CarType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import models.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Cashier {
    List<BigDecimal> salesIncome = new ArrayList<>();
    List<CarType> soldCars = new ArrayList<>();

    public void acceptTheOrder(Car car) {
        salesIncome.add(car.getPrice());
    }

    public void acceptTheOrder(List<Car> cars) {
        salesIncome.addAll(cars.stream().map(Car::getPrice).toList());
        soldCars.addAll(cars.stream().map(Car::getCarType).toList());
    }
}
