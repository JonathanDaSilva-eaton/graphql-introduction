package com.example.demo;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Ups extends AbstractAsset {
    private Integer batteryPercentage;
}
