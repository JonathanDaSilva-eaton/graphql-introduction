package com.example.demo;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Room extends AbstractLocation {
    String parentId;
}
