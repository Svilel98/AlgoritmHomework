package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        ElementsList serviceList = new ElementListServiceImpl();
        serviceList.add(1);
        serviceList.add(2);
        serviceList.add(3);
        serviceList.add(4);
        serviceList.add(5);
        serviceList.add(0,5);
//        serviceList.add(-1,"new");
////        serviceList.set(1, "second");
//        serviceList.remove(3);
//        serviceList.generateRandomArray();
//        serviceList.sortSelection();
        System.out.println(serviceList.contains(3));
        System.out.println(serviceList.contains(6));
//        serviceList.remove("three");
//        System.out.println(serviceList.contains("firstElement"));
//        System.out.println(serviceList.indexOf("firstElement"));
//        System.out.println(serviceList.lastIndexOf("firstElement"));
//        System.out.println(serviceList.get(0));
//        System.out.println(serviceList.size());
//        System.out.println(serviceList.isEmpty());
//        serviceList.clear();
        System.out.println(Arrays.stream(serviceList.toArray()).map(Object::toString).collect(Collectors.joining(", ")));
    }
}