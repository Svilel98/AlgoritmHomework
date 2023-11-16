package org.example;

public interface ElementsList {
    Integer add(Integer item);

    Integer add(Integer index, Integer item);


    Integer set(Integer index, Integer item);

    Integer remove(Integer item);


    Integer removeByIndex(int index);


    boolean contains(Integer item);


    Integer indexOf(Integer item);


    Integer lastIndexOf(Integer item);


    Integer get(Integer index);


    boolean equals(ElementsList otherList);


    Integer size();


    boolean isEmpty();


    void clear();


    Integer[] toArray();
//    Integer[] generateRandomArray();
}
