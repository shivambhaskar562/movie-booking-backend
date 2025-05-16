package com.moviebooking.www.response;

import java.time.LocalDateTime;

public class ResponseStructure<T>{
    private String status;
    private int statusCode;
    private String message;
    private T data;
    private LocalDateTime dateTime;

    public ResponseStructure(String status, int statusCode, String message, T data, LocalDateTime dateTime) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
        this.dateTime = dateTime;
    }

    public ResponseStructure() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
