package edu.pte.mik.prog2;

public class Storage1 {
    private String name;
    private Object[] items;
    private Integer numberOfStoredItems;

    public String getName() {
        return name;
    }

    public Integer getNumberOfItems() {
        return numberOfStoredItems;
    }

    public Storage1(String name, Integer numberOfItems) {
        this.name = name;
        items = new Object[numberOfItems];
        numberOfStoredItems = 0;
    }

    public void addItem(Object newItem) {
        if(numberOfStoredItems < items.length) {
            items[numberOfStoredItems++] = newItem;
        }
        else {
            System.out.println("Can not register more items!");
        }
    }

    public Object getItem(int index) {
        if(index < items.length) {
            return items[index];
        }
        return null;
    }
}
