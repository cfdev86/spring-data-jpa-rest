package com.cfprac.constant;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    M("MALE"), F("FEMALE");

    private String name;

    Gender(String name) {
        this.name=name;
    }

    //Indicates a single method that Jackson will use to serialize the entire instance
    @JsonValue
    public String getName(){
        return name;
    }

}
