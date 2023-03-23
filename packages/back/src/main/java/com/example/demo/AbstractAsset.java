package com.example.demo;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@SuperBuilder
public abstract class AbstractAsset {
    private String id;
    private String name;
    private String parentId;
}
