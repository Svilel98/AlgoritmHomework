package org.example;

import java.util.Arrays;

public class ElementListServiceImpl implements ElementsList {
    private Integer[] arrayString;
    private int size = 5;

    public ElementListServiceImpl() {
        this.arrayString = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] == null) {
                arrayString[i] = item;
                return arrayString[i];
            }
        }
        throw new ArrayIndexOutOfBoundsException("Массив заполнен");
    }

    @Override
    public Integer add(Integer index, Integer item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Ты крокодил");
        }
        if (index < arrayString.length) {
            if (arrayString[index] == null) {
                arrayString[index] = item;
                return arrayString[index];
            } else {
                Integer[] arrayString2 = new Integer[size + 1];
                System.arraycopy(arrayString, 0, arrayString2, 0, index);
                arrayString2[index] = item;
                System.arraycopy(arrayString, index, arrayString2, index + 1, arrayString.length - index);
                arrayString = arrayString2;
            }
            return item;
        } else {
            throw new ArrayIndexOutOfBoundsException("Значение индекса больше размера массива");
        }
    }

    @Override
    public Integer set(Integer index, Integer item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        if (index <= arrayString.length - 1) {
            arrayString[index] = item;
            return arrayString[index];
        }
        throw new ArrayIndexOutOfBoundsException("Значение индекса больше размера массива");
    }

    @Override
    public Integer remove(Integer item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        int index = indexOf(item);
        System.arraycopy(arrayString, index + 1, arrayString, index, size - 1);
        return item;
    }

    @Override
    public Integer removeByIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Ты крокодил");
        }
        if (arrayString[index] == null) {
            throw new IllegalArgumentException("Нет такого элемента");
        }
        Integer item = arrayString[index];
        System.arraycopy(arrayString, index + 1, arrayString, index, size - 1);
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        sortSelection();
        return binarySearcher(item);
    }

    private boolean binarySearcher(Integer item) {
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arrayString[mid]) {
                return true;
            }

            if (item < arrayString[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public Integer indexOf(Integer item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] == item) {
                return 1;
            }
        }
        return -1;
    }

    @Override
    public Integer lastIndexOf(Integer item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        for (int i = arrayString.length - 1; i >= 0; i--) {
            if (arrayString[i] == item) {
                return 1;
            }
        }
        return -1;
    }

    @Override
    public Integer get(Integer index) {
        if (index <= arrayString.length - 1) {
            return arrayString[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Такого индекса в массиве нет");
        }
    }

    @Override
    public boolean equals(ElementsList otherList) {
        return Arrays.equals(otherList.toArray(), arrayString);
    }

    @Override
    public Integer size() {
        return arrayString.length;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = null;
        }
    }

    @Override
    public Integer[] toArray() {
        Integer[] newArray = new Integer[size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = arrayString[i];
        }
        return newArray;
    }

    //    @Override
//    public void findFastMethodSort(ElementsList otherList){
//
//    };
    private static void swapElements(Integer[] arr, Integer indexA, Integer indexB) {
        Integer tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }


    private void sortSelection() {
        for (int i = 0; i < arrayString.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arrayString.length; j++) {
                if (arrayString[j] < arrayString[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arrayString, i, minElementIndex);
        }
    }

//    @Override
//    public Integer[] generateRandomArray() {
//        java.util.Random random = new java.util.Random();
//        Integer[] arr = new Integer[100];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = random.nextInt(100_000) + 100_000;
//        }
//        return arr;
//    }
}
