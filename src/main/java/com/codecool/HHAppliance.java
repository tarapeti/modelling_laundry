package com.codecool;

import java.util.ArrayList;
import java.util.List;

abstract class HHAppliance {

    private List<Cloth> inMachine;
    private String name;
    private int size;
    private boolean badShape;

    public HHAppliance(List<Cloth> inMachine, String name, int size, boolean badShape) {
        this.inMachine = inMachine;
        this.name = name;
        this.size = size;
        this.badShape = badShape;
    }

    public HHAppliance() {
    }

    public List<Cloth> getInMachine() {
        return inMachine;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public boolean isBadShape() {
        return badShape;
    }

    public void setInMachine(List<Cloth> inMachine) {
        this.inMachine = inMachine;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setBadShape(boolean badShape) {
        this.badShape = badShape;
    }


    static HHAppliance makeMachine(String type, int size) throws NoSuchMachineException {
        List<Cloth> temp = new ArrayList<Cloth>();
        boolean badShape;

        if (Math.random() > 5) {
            badShape = true;
        } else {
            badShape = false;
        }

        if (type.equals("washing machine")) {
            return new Washingmachine(temp, "washingmachine ", size, badShape);
        } else if (type.equals("dryer")) {
            return new Dryer(temp, "dryer", size, badShape);
        }
        throw new NoSuchMachineException("No such machine in stock");
    }

    @Override
    public String toString() {
        return "HHAppliance{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }

    abstract void addtoMachine(Cloth c) throws InvalidStateException;

    abstract void program();

    abstract void emptyMachine();

}
