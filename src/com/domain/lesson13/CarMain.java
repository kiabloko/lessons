package com.domain.lesson13;

import java.util.ArrayList;
import java.util.Comparator;

public class CarMain {
    public static void main(String[] args) {
        Car opel1 = new Car("black", "opel", 2000);
        Car opel2 = new Car("red", "opel", 2500);
        Car mazda1 = new Car("yellow", "mazda", 3000);
        Car mazda2 = new Car("green", "mazda", 3000);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(opel1);
        cars.add(opel2);
        cars.add(mazda1);
        cars.add(mazda2);

        for (Car car : cars) {
            System.out.println(car);
        }
        //brand price color
        Comparator<Car> carComparator = new BrandComparator().thenComparing(new PriceComparator()).thenComparing(new ColorComparator());
        cars.sort(carComparator);
        System.out.println(cars);
    }//если одинаковые бренды,то сотировка дальше уже по остальным свойствам

}

    class BrandComparator implements Comparable<Car>{
//переопределяем метод компейр ту
        @Override
        public int compare(Car o1, Car o2) {
            return o1.getBrand().compareTo(o2.getBrand());
        }


    }

    class PriceComparator implements Comparable<Car>{
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getPrice(),o2.getPrice());
    }
}
class ColorComparator implements Comparable<Car>{
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getColor().compareTo(o2.getColor());
    }
}

