package com.codecool;

public enum State {
    DIRTY,
    CLEAN,
    DESTROYED,
    WET;

    public static State getEnum(String s) {
        if (DIRTY.name().equals(s.toUpperCase())) {
            return DIRTY;
        } else if (CLEAN.name().equals(s.toUpperCase())) {
            return CLEAN;
        } else if (WET.name().equals(s.toUpperCase())) {
            return WET;
        } else if (DESTROYED.name().equals(s.toUpperCase())){
            return DESTROYED;
        }
        throw new IllegalArgumentException("No Enum specified for this string");
    }
}
