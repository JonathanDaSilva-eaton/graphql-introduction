package com.example.demo;

public class RowNotFoundException extends RuntimeException {
    public RowNotFoundException() {
        super("Row NOT_FOUND");
    }
}
