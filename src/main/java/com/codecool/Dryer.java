package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Dryer extends HHAppliance {

    public Dryer(List<Cloth> inMachine, String name, int size, boolean badShape) {
        super(inMachine, name, size, badShape);
    }


    void addtoMachine(Cloth c) throws InvalidStateException {
        List<Cloth> temp = getInMachine();
        if (getInMachine().size() >= getSize()) {
            throw new NoMoreSpaceException("No more space in the machine, start washing");
        }
        if (c.getState().equals(State.WET)) {
            temp.add(c);

        } else {
            throw new InvalidStateException("the cloth's state is invalid for the machine type");
        }
        setInMachine(temp);
    }

    void program() {
        List<Cloth> afterProgram = new ArrayList<Cloth>();

        for (Cloth c : getInMachine()) {
            if (isBadShape() && Math.random() > 15) {
                c.setState(State.DESTROYED);
            } else {
                c.setState(State.CLEAN);
            }
            afterProgram.add(c);
        }
        setInMachine(afterProgram);
    }


    void emptyMachine() {
        setInMachine(null);
    }

}
