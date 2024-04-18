package shop;

import enums.CarType;
import garage.Garage;
import lombok.Getter;
import lombok.ToString;
import models.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

@ToString
@Getter
public class Report {
    public Report() {
    }

    public void createReport(Manager manager, Cashier cashier) throws IOException {
        reportHelper(manager, cashier);
    }

    private void reportHelper(Manager manager, Cashier cashier) throws IOException {
        BigDecimal totalIncome = new BigDecimal(cashier.getSoldCars().stream()
                .map(CarType::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add).toString());
        BigDecimal totalExpenses = new BigDecimal(cashier.getSoldCars().stream()
                .map(CarType::getCostPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add).toString());
        BigDecimal profit = new BigDecimal(String.valueOf(totalIncome.subtract(totalExpenses)));

        FileWriter fileWriter = new FileWriter("src/main/resources/report", false);
        String name = manager.getName();

        fileWriter.write("Менеджер: " + name);
        fileWriter.append("\n");
        fileWriter.write(cashier.getSoldCars().stream().map(Enum::name).toList().toString());
        fileWriter.append("\n");
        fileWriter.append("\t");
        fileWriter.write(cashier.getSoldCars().stream().map(CarType::getPrice).toList().toString());
        fileWriter.append("\n");
        fileWriter.write("Общие доходы с продаж: " + totalIncome + "\n");
        fileWriter.write("Общие Затраты на производство: " + totalExpenses + "\n");
        fileWriter.write("Общая прибыль: " + profit + "\n");
        fileWriter.close();
    }
}
