package com.domain.lesson10;

public class Garage <T extends Bus>{ //ограничения объектов. только автобусы и его наследники
    private T bus;
    public Garage (T bus){
        this.bus =bus;
    }
    public  T makeDefault (){
        bus.setDepartureSt("Москва");
        bus.setDestSt("Санкт-Петербург");
        bus.setNum("345Р");
        bus.setWiFi(false);
        return bus;

    }
}
