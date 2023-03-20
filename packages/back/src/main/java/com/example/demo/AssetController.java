package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AssetController {

    @QueryMapping
    public List<Asset> assets() {
        Asset asset1 = Pdu.builder().id("1").name("test1").outletCount(45).build();
        Asset asset2 = Pdu.builder().id("2").name("test2").outletCount(45).build();
        Asset asset3 = Ups.builder().id("3").name("test3").batteryPercentage(40).build();
        List<Asset> array = new ArrayList<>();
        array.add(asset1);
        array.add(asset2);
        array.add(asset3);
        return array;
    }

    @QueryMapping
    public Asset asset(@Argument String id) {
        return Pdu.builder().id(id).name("test"+id).outletCount(45).build();
    }
}
