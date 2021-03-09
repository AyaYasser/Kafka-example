package com.hr.model;

public enum Status {
    SUCCESS(true),
    FAILED(false);

    boolean status;
    Status(boolean status){
        this.status=status;
    }
}
