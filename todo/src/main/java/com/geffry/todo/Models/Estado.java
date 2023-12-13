package com.geffry.todo.Models;


public enum Estado {
    ON_TIME("ON_TIME"),
    LATE("LATE");

    String value;
    
    Estado(String value){
        this.value = value;
    }
}
