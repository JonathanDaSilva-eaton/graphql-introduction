package com.example.demo;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class AbstractAsset implements Asset {
    private String id;
    private String name;
}
