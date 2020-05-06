package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Shelf {
    private ArrayList<Box> boxes = new ArrayList<>();

    public void addBox(Box box) {
        boxes.add(box);
    }

    public void removeBox(int slotId) {
        for(int i=0; i<this.boxes.size(); i++) {
            if(this.boxes.get(i).getSlotId() == slotId) {
                this.boxes.remove(i);
                break;
            }
        }
    }

    public Box getBoxBySlot(int slotId) {
        for(int i=0; i<this.boxes.size(); i++) {
            if(this.boxes.get(i).getSlotId() == slotId) return this.boxes.get(i);
        }
        return null;
    }

    public Box getBox(int i) {
        return i < getBoxNumber() ? this.boxes.get(i) : null;
    }

    public void sort(Comparator comparator) {
        if (comparator == null) {
            Collections.sort(this.boxes);
        } else {
            Collections.sort(this.boxes, comparator);
        }
    }

    public int getBoxNumber() {
        return this.boxes.size();
    }
}
