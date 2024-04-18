import components.GasTank;
import enums.Color;
import factory.Conveyor;
import factory.Factory;
import garage.Garage;
import models.Car;
import shop.Cashier;
import shop.Consumer;
import shop.Manager;
import shop.Report;
import types.Camry;
import types.Dyna;
import types.Hiance;
import types.Solara;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {

        /*
         * Создание классов для производства автомобилей
         * */
        Garage garage = new Garage();
        Factory factory = new Factory();
        Conveyor conveyor = new Conveyor(factory);

        /*
         * Создание классов для продаж
         * */
        Manager manager = new Manager("Pavlo");
        Cashier cashier = new Cashier();
        Report report = new Report();

        /*
         * Создание машин
         * */
        Camry camry = conveyor.createCamry(Color.BLACK, new BigDecimal(10_000));
        Solara solara = conveyor.createSolara(Color.BLACK, new BigDecimal(12_000));
        Hiance hiance = conveyor.createHiance(Color.WHITE, new BigDecimal(15_000));
        Dyna dyna = conveyor.createDyna(Color.BLACK, new BigDecimal(22_000));

        camry.setGasTank(new GasTank(10));
        dyna.setGasTank(new GasTank(10));

        /*
         * Проверка методов
         * */
        camry.start();
        camry.stop();
        camry.turnOnUsb();
        camry.turnOnLights();
        solara.coolTheDrink();
        solara.raiseTheRoof();
        solara.lowerTheRoof();
        dyna.start();

        /*
         * Добавление машин в хранилище
         * */
        garage.addCar(camry);
        garage.addCar(solara);
        garage.addCar(dyna);
        garage.addCar(hiance);
        /*
         *
         *Создание 8 покупателей
         *
         * */
        Consumer consumer1 = new Consumer(new BigDecimal(10_000), "Slava");
        Consumer consumer2 = new Consumer(new BigDecimal(12_000), "Petr");
        Consumer consumer3 = new Consumer(new BigDecimal(15_000), "Sergay");
        Consumer consumer4 = new Consumer(new BigDecimal(22_000), "Dmitry");
        Consumer consumer5 = new Consumer(new BigDecimal(11_000), "Anton");
        Consumer consumer6 = new Consumer(new BigDecimal(13_000), "Damir");
        Consumer consumer7 = new Consumer(new BigDecimal(8_000), "Yuri");
        Consumer consumer8 = new Consumer(new BigDecimal(10_000), "Emir");
        Consumer consumer9 = new Consumer(new BigDecimal(30_000), "Ilya");

        System.out.println("гараж до продажи: " + garage);
        System.out.println("_______________________________________________________________________________________________________________________________________________");
        manager.sale(consumer1, garage);
        manager.sale(consumer2, garage);
        manager.sale(consumer3, garage);
        manager.sale(consumer4, garage);
        manager.sale(consumer5, garage);
        manager.sale(consumer6, garage);
        manager.sale(consumer7, garage);
        manager.sale(consumer8, garage);
        System.out.println("гараж после продажи: " + garage);

        //Старый метод
        //cashier.acceptTheOrder(manager.sale(consumer1, garage));
        List<Car> carList = List.of(
                manager.sale(consumer1, garage),
                manager.sale(consumer2, garage),
                manager.sale(consumer3, garage),
                manager.sale(consumer4, garage),
                manager.sale(consumer5, garage),
                manager.sale(consumer6, garage),
                manager.sale(consumer7, garage),
                manager.sale(consumer8, garage)
        );
        cashier.acceptTheOrder(carList);
        report.createReport(manager, cashier);
    }
}
