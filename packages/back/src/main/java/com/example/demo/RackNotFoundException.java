package com.example.demo;

public class RackNotFoundException extends RuntimeException {
    public RackNotFoundException() {
        super("Rack NOT_FOUND");
    }
}
