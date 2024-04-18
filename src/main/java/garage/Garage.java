package garage;

import enums.CarType;
import exceptions.CarNotFoundInStorageException;
import factory.Conveyor;
import factory.Factory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import models.Car;
import types.Camry;
import types.Dyna;
import types.Hiance;
import types.Solara;
//    Для этого нам потребуется создать склад машин. Каждый склад может хранить в себе до 1000 машин разных типов.
//    Поэтому необходимо:
//            1. Создать новый класс склад. Который имеет количество машин при создании - 0.
//            2. Создать в нем переменные, которые будут отвечать за хранение конкретного типа машин.
//3. Создать методы добавления машин по каждому типу в переменные из шага два. При добавлении машины, свободное место на складе должно уменьшаться.
//            4. Создать методы взятия машин со склада: общий счетчик уменьшается на 1, а в переменной ответственной за хранение машины определенной модели должна быть удалена конкретная машина. Методы возвращают экземпляр модели.
//            5. Написать методы, которые будут показывать количество машин по каждой модели.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Garage {

    private int countCars = 0;
    static final int MAX_CARS = 1000;
    private final Map<CarType, List<Car>> cars = new HashMap<>();
    final Factory factory = new Factory();
    final Conveyor conveyor = new Conveyor(factory);

    public void addCar(Car car) {
        if (countCars >= MAX_CARS) {
            throw new RuntimeException("Хранилище переполнено");
        }
        if (!cars.containsKey(car.getCarType())) {
            cars.put(car.getCarType(), new ArrayList<>());
        }
        cars.get(car.getCarType()).add(car);
        countCars++;
    }

    public Car getCar(CarType carType) {
        List<Car> carList = cars.get(carType);
        if (carList != null && !carList.isEmpty()) {
            countCars--;
            return carList.remove(carList.size() - 1);
        }
        return conveyor.createCar(carType);
    }
}

/*
 * Старые методы
 * */
//    public Camry getCamry()   {
//        return (Camry) getCar(CarType.CAMRY);
//    }
//
//    public Solara getSolara()   {
//        return (Solara) getCar(CarType.SOLARA);
//    }
//
//    public Hiance getHiance()   {
//        return (Hiance) getCar(CarType.HIANCE);
//    }
//    public Dyna getDyna()   {
//        return (Dyna) getCar(CarType.DYNA);
//    }
//    }
