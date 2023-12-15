package com.geffry.todo.DTO;


import lombok.Data;


@Data
public class ResponseDTO<T> {
    private Boolean error;
    private String errorMessage;
    private T data;
}
