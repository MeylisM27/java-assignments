package com.company;

public class Mask extends Equipment {
    private Integer filterSize;

    public Mask(Integer safetyLevel, Integer filterSize) {
        super(safetyLevel);
        this.filterSize = filterSize;
    }

    @Override
    public String toString() {
        return "Mask{" +
                "safetylevel=" + getSafetyLevel() +
                ",filterSize=" + filterSize +
                "} ";
    }
}
