package com.company;

public class Gloves extends Equipment {
    private Integer size;

    public Gloves(Integer safetyLevel, Integer size) {
        super(safetyLevel);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Gloves{" +
                "safetylevel=" + getSafetyLevel() +
                ",size=" + size +
                "} ";
    }
}
