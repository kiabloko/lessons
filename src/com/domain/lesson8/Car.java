package com.domain.lesson8;

import java.util.Objects;

public class Car implements Cloneable{
    private String brand;
    private String color;
    //после добавки владельца класс добавляем его
    private Owner owner;

    public Car(String brand, String color, Owner owner) {
        this.brand = brand;
        this.color = color;
        this.owner = owner;
    }

    //конструктор
    public Car(String brand, String color) {
        this.brand = brand; //setBrand(brand);
        this.color = color; //setColor(color);


    }

    public void setBrand(String brand) {
        //сделать проверку
        this.brand = brand;
    }

    public void setColor(String color) {
        //сделать проверку
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }
//метод ту стринг через альт инсерт - чтобы объект определеился без хэшкода (а не как у котов по началу)

        //что угодно подставить


    //переопределение хэшкода и иквелс - попробовать дома по разному -


    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return brand.equals(car.brand) &&
                color.equals(car.color) &&
                owner.equals(car.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, owner);
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        //здесь добавить реализацию
        return (Car) super.clone();
    }
}
