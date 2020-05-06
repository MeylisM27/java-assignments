package com.company;

public class Box<T> implements Comparable {
    private T item;
    private int numberOfItems = 0;
    private Integer slotId = null;
    Integer date = null;

    Box(T item, int numberOfItems, Integer date) {
        this.numberOfItems = numberOfItems;
        this.item = item;
        this.date = date;
    }

    public void setItem(T item) {
        if(item instanceof Equipment || item instanceof Product) { this.item = item; }
    }

    public T getItem() {
        return item;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public Integer getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Box{" +
                "item=" + item +
                ", numberOfItems=" + numberOfItems +
                ", slotId=" + slotId +
                ", date=" + date +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        //Sorting by type
        return this.getItem().getClass().getSimpleName().compareTo(((Box)o).getItem().getClass().getSimpleName());
    }
}
