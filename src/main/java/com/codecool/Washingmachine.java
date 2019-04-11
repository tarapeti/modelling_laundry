package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Washingmachine extends HHAppliance {


    public Washingmachine(List<Cloth> inMachine, String name, int size, boolean badShape) {
        super(inMachine, name, size, badShape);
    }

    public Washingmachine() {
    }


    void addtoMachine(Cloth c) throws InvalidStateException {
        List<Cloth> temp = getInMachine();
        if (getInMachine().size() < getSize()) {
            if (!c.getState().equals(State.CLEAN)) {
                temp.add(c);
            } else {
                throw new InvalidStateException("the cloth's state is invalid for the machine type");
            }

            setInMachine(temp);

        } else {
            throw new NoMoreSpaceException("No more space in the machine, start washing");
        }
    }


    void program() {
        List<Cloth> afterProgram = new ArrayList<Cloth>();
        for (Cloth c : getInMachine()) {
            if (isBadShape() && Math.random() > 15) {
                c.setState(State.DESTROYED);
            } else {
                c.setState(State.WET);
            }
            afterProgram.add(c);
        }
        setInMachine(afterProgram);

    }

    void emptyMachine() {
        setInMachine(null);
    }


}
