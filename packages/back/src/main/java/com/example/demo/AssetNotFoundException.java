package com.example.demo;

public class AssetNotFoundException extends RuntimeException {
    public AssetNotFoundException() {
        super("Asset NOT_FOUND");
    }
}
