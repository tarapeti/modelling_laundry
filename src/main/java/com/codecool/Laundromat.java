package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Laundromat {

    //a ruhak 'lekovetese'
    //a machinelist az marad

    private List<Cloth> allCloth = new ArrayList<Cloth>();
    private List<HHAppliance> machines = new ArrayList<HHAppliance>();

    public List<Cloth> getAllCloth() {
        return allCloth;
    }

    public List<HHAppliance> getMachines() {
        return machines;
    }

    public void setAllCloth(List<Cloth> allCloth) {
        this.allCloth = allCloth;
    }

    public void setMachines(List<HHAppliance> machines) {
        this.machines = machines;
    }

    public void addToAllCloth(Cloth c) {
        allCloth.add(c);
    }

    public void addToMachines(HHAppliance machine) {
        machines.add(machine);
    }

    public Cloth findCloth(List<Cloth> fromWhere, int id) {

        for (Cloth c : fromWhere) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;

    }
}
