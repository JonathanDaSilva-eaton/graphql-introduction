package com.example.demo;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Ups extends AbstractAsset {
    private Integer batteryPercentage;
}
