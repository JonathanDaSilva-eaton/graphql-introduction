package com.example.demo;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import java.util.Optional;

@Data
@SuperBuilder
public class PduOutlet {
    String id;
    String label;
    PduOutletType plugType;
}
