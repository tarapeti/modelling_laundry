package com.codecool;

public enum Colors {
    RED, SKYBLUE, GREEN, YELLOW, BLACK, WHITE, ORANGE, PURPLE;

    public static Colors getEnumC(String s){
        if(RED.name().equals(s.toUpperCase())){
            return RED;
        }else if(SKYBLUE.name().equals(s.toUpperCase())){
            return SKYBLUE;
        }else if(GREEN.name().equals(s.toUpperCase())){
            return GREEN;
        }else if (YELLOW.name().equals(s.toUpperCase())){
            return YELLOW;
        }else if (WHITE.name().equals(s.toUpperCase())){
            return WHITE;
        }else if (ORANGE.name().equals(s.toUpperCase())){
            return ORANGE;
        }else if (PURPLE.name().equals(s.toUpperCase())){
            return PURPLE;
        }else if (BLACK.name().equals(s.toUpperCase())){
            return BLACK;
        }
        throw new IllegalArgumentException("No Enum specified for this string");
    }
}
