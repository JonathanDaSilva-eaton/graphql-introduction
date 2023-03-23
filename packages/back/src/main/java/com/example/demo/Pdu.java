package com.example.demo;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@Data
@SuperBuilder
public class Pdu extends AbstractAsset {
    private Integer outletCount;
    private List<PduOutlet> outlets;
}
