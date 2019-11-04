package com.epam.workingwithfiles.task1.appliances.collections;

import java.util.Arrays;

public class DynamicArray<T> {

    private int size;
    private Object[] data;

    public DynamicArray() {
        this.data = new Object[10];
        this.size = 0;
    }

    public DynamicArray(int capacity) {
        this.data = new Object[capacity];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public void add(T value) {
        if (data.length == size) {
            Object[] temp = data;
            data = new Object[(size * 3) / 2 + 1];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
        data[size] = value;
        size++;
    }

    public void remove(int index) {
        Object[] temp = new Object[size - 1];
        for (int i = 0; i < index; i++) {
            temp[i] = data[i];
        }
        for (int i = index + 1; i < size; i++) {
            temp[i - 1] = data[i];
        }
        data = temp;
        size--;
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "size=" + size +
                ", data=" + Arrays.toString(data) +
                '}';
    }

}
