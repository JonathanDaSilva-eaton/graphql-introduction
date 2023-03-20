package com.example.demo;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@SuperBuilder
public abstract class AbstractAsset implements Asset {
    private String id;
    private String name;
}
