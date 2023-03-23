package com.example.demo;

import lombok.experimental.SuperBuilder;
import java.time.LocalDate;

@SuperBuilder
public class Datacenter extends AbstractLocation {
    LocalDate createAt;
}
