package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AssetService {
    ArrayList<Asset> list = new ArrayList<>();

    public AssetService() {
        list.add(Pdu.builder().id("1").name("test1").outletCount(45).build());
        list.add(Pdu.builder().id("2").name("test2").outletCount(45).build());
        list.add(Pdu.builder().id("3").name("test3").outletCount(45).build());
        list.add(Ups.builder().id("4").name("test4").batteryPercentage(45).build());
        list.add(Pdu.builder().id("5").name("test5").outletCount(45).build());
        list.add(Ups.builder().id("6").name("test6").batteryPercentage(45).build());
        list.add(Pdu.builder().id("7").name("test7").outletCount(45).build());
        list.add(Ups.builder().id("8").name("test8").batteryPercentage(45).build());
        list.add(Pdu.builder().id("9").name("test9").outletCount(45).build());
    }

    public List<Asset> getAll() {
        return list;
    }

    public Asset getById(String id) {
        return list.stream().filter(asset -> asset.getId().equals(id)).findFirst().get();
    }
}
