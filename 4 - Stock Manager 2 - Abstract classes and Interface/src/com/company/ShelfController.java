package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class ShelfController {
    private Shelf myshelf;

    public ShelfController() {
        myshelf = new Shelf();
    }

    public Box addBox(Box box) {
        box.setSlotId(getFirstAvailableSlot());
        myshelf.addBox(box);
        return null;
    }

    public Box addBox(Box box, int slotID) {
        //Checking for occupied slots
        for(int i=0; i<myshelf.getBoxNumber(); i++) {
            if(myshelf.getBox(i).getSlotId() == slotID) {
                System.out.println("Already occupied");
                return null;
            }
        }
        box.setSlotId(slotID);
        myshelf.addBox(box);
        return null;
    }

    private int getFirstAvailableSlot() {
        // Here, I am trying to get first available slot
        // In other words, I am trying to find first missing positive integer in slots array
        HashMap<Integer, Boolean> slotID = new HashMap<>();
        int max;
        if(myshelf.getBoxNumber() == 0) {
            slotID.put(0, true);
            return 1;
        } else {
            max = myshelf.getBox(0).getSlotId();
        }

        for(int i=0; i<myshelf.getBoxNumber(); i++) {
            if(myshelf.getBox(i).getSlotId() > max) max = myshelf.getBox(i).getSlotId();
            slotID.put(myshelf.getBox(i).getSlotId()-1, true);
        }

        for(int i=0; i<max; i++) {
            if(!slotID.containsKey(i)) return i+1;
        }
        return max+1;
    }

    public void print() {
        for(int i=0; i<myshelf.getBoxNumber(); i++) {
            System.out.println(myshelf.getBox(i));
        }
    }

    public String search(String type, int count) {
        ArrayList<Box> foundItems = new ArrayList();
        sortByDate();
        for(int i=0; i<myshelf.getBoxNumber(); i++) {
            String nameOfBoxItem = myshelf.getBox(i).getItem().getClass().getSimpleName();
            if(nameOfBoxItem.equals(type)) foundItems.add(myshelf.getBox(i));
        }

        String result = "", finalResult = "";
        int sum = 0, neededItemNumber = 0;
        for(int j=0; j<foundItems.size(); j++) {
            result = "";
            sum = 0;
            for (int i = j; i < foundItems.size(); i++) {
                sum += foundItems.get(i).getNumberOfItems();
                if (sum > count) {
                    neededItemNumber = foundItems.get(i).getNumberOfItems() - (sum - count);
                    result += ("Slot:" + Integer.toString(foundItems.get(i).getSlotId()) + ",Count:" + Integer.toString(neededItemNumber)) + " ";
                    break;
                } else {
                    result += ("Slot:" + Integer.toString(foundItems.get(i).getSlotId()) + ",Count:" + Integer.toString(foundItems.get(i).getNumberOfItems())) + " ";
                }
            }
            finalResult += (sum >= count ? (result + "\n") : "");
        }
        return result.equals("") ? "No results found" : finalResult;
    }

    public void pick(int slotId, int count) {
        for(int i=0; i<myshelf.getBoxNumber(); i++) {
            if(myshelf.getBox(i).getSlotId() == slotId) {
                if(myshelf.getBox(i).getNumberOfItems() == count) {
                    myshelf.removeBox(myshelf.getBox(i).getSlotId());
                } else {
                    if(myshelf.getBox(i).getNumberOfItems()-count > 0) {
                        myshelf.getBox(i).setNumberOfItems(myshelf.getBox(i).getNumberOfItems()-count);
                    } else {
                        System.out.println("Not enough item");
                    }
                }
            }
        }
    }

    public void sortByDate() {
        myshelf.sort((a, b) -> ((Box)a).getDate() - ((Box)b).getDate());
    }

    public void sortBySlot() {
        myshelf.sort((a, b) -> ((Box)a).getSlotId() - ((Box)b).getSlotId());
    }

    public void sortByType() {
        myshelf.sort(null);
    }

    public void removeBox(int slotId) {
        myshelf.removeBox(slotId);
    }

}
