package com.example.demo;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException() {
        super("Room NOT_FOUND");
    }
}
