package edu.pte.mik.prog2;

public class Storage2<T> {
    private String name;
    private T[] items;
    private Integer numberOfStoredItems;

    public String getName() {
        return name;
    }

    public Integer getNumberOfItems() {
        return numberOfStoredItems;
    }

    public Storage2(String name, T[] emptyArray) {
        this.name = name;
        items = emptyArray;
        numberOfStoredItems = 0;
    }

    public void addItem(T newItem) {
        if(numberOfStoredItems < items.length) {
            items[numberOfStoredItems++] = newItem;
        }
        else {
            System.out.println("Can not register more items!");
        }
    }

    public T getItem(int index) {
        if(index < items.length) {
            return items[index];
        }
        return null;
    }
}
