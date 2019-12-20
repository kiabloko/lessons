package com.domain.lesson10;

public class Main {
    public static void main (String [] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("string 1");
        linkedList.add("string 2");
        linkedList.add("string 3");
        System.out.println(linkedList.get(2));


        Transport transport1 = new Transport("Москва", "Тверь", "123У");
        Transport transport2 = new Transport("Санкт-Петербург", "Тамбов", "486Ф");
        LinkedList<Transport> transportList = new LinkedList<>();
        transportList.add(transport1);
        transportList.add(transport2);

        Bus bus = new Bus("Самара", "Рязань", "2326р", true);
        transportList.add(bus);
        Transport transportFromList = transportList.get(1); //без приведения получаем только транспорт
        //   Bus busFromList = transportList.get(2); //автобус уже не получить
        //    Bus busFromList = (Bus) transportList.get(2); //вот так только
    }
    //3 способа добаить бас
        public static Bus getThird(LinkedList<? extends Transport> list){
            Transport bus = new Bus("Самара", "Рязань", "2326р", true);
            list.add(bus); //не можем добавить, меняем на транспорт. так можно добавить только null и транспорт
            Transport transport = list.get(2);
            return (Bus) transport;
        }
        public void addToList (LinkedList<? super Transport> list){
            Bus bus = new Bus("Самара", "Рязань", "2326р", true);
            list.add(bus);

        }
        public void addToList (LinkedList<? super Transport> list){
            Bus bus = new Bus("Самара", "Рязань", "2326р", true);
            list.add(bus);
        }

}
