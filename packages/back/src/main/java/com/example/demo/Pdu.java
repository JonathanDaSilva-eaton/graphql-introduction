package com.example.demo;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Pdu extends AbstractAsset {
    private Integer outletCount;
}
