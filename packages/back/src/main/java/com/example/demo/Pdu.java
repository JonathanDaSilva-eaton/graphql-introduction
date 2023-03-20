package com.example.demo;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Pdu extends AbstractAsset {
    private Integer outletCount;
}
