package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Cloth {

    private static int counter = 1;
    private int id;

    private String name;
    private Colors color;
    private State state;


    public Cloth(int id, String name, Colors color, State state) {
        this.id = counter++;
        this.name = name;
        this.color = color;
        this.state = state;
    }

    public Cloth() {
    }

    @Override
    public String toString() {
        return "Cloth{" +
                "objID=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", state=" + state +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public static Cloth createCloth(String name, String color, String state) {
        return new Cloth(counter, name, Colors.getEnumC(color), State.getEnum(state));
    }

}
