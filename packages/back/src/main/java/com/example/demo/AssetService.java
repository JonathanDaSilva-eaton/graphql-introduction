package com.example.demo;

import graphql.com.google.common.base.CharMatcher;
import graphql.com.google.common.collect.Iterables;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class AssetService {
    ArrayList<AbstractAsset> list = new ArrayList<>();
    Random rand = new Random();

    public AssetService() {
        PduOutlet outlet1 = PduOutlet.builder().id("1").plugType(PduOutletType.C13).build();
        PduOutlet outlet2 = PduOutlet.builder().id("2").label("SRV47").plugType(PduOutletType.C19).build();
        PduOutlet outlet3 = PduOutlet.builder().id("3").plugType(PduOutletType.C13).build();

        list.add(Pdu.builder().id("pdu-01").name("test1").parentId("rack-01").outletCount(1).outlets(Arrays.asList(outlet1)).build());
        list.add(Pdu.builder().id("pdu-02").name("test2").parentId("rack-01").outletCount(2).outlets(Arrays.asList(outlet1, outlet2)).build());
        list.add(Pdu.builder().id("pdu-03").name("test3").parentId("rack-01").outletCount(3).outlets(Arrays.asList(outlet1, outlet2, outlet3)).build());
        list.add(Ups.builder().id("ups-04").name("test4").parentId("rack-02").batteryPercentage(45).build());
        list.add(Pdu.builder().id("pdu-05").name("test5").parentId("rack-02").outletCount(1).outlets(Arrays.asList(outlet1)).build());
        list.add(Ups.builder().id("ups-06").name("test6").parentId("rack-03").batteryPercentage(45).build());
        list.add(Pdu.builder().id("pdu-07").name("test7").parentId("rack-03").outletCount(2).outlets(Arrays.asList(outlet1, outlet2)).build());
        list.add(Ups.builder().id("ups-08").name("test8").parentId("rack-04").batteryPercentage(45).build());
        list.add(Pdu.builder().id("pdu-09").name("test9").parentId("rack-04").outletCount(1).outlets(Arrays.asList(outlet1)).build());
    }

    public List<AbstractAsset> getAll() {
        return list;
    }

    public AbstractAsset getById(String id) {
        return list.stream().filter(asset -> asset.getId().equals(id)).findFirst().orElseThrow(AssetNotFoundException::new);
    }

    public List<AbstractAsset> getAssetsForRack(String id) {
        return list.stream().filter(asset -> asset.getParentId().equals(id)).toList();
    }

    public AbstractAsset createRandomAsset(String name, String parentId) {
        AbstractAsset last = Iterables.getLast(list);
        Integer num = getNumberFromId(last.getId());
        if(rand.nextBoolean()) {
             Pdu pdu = Pdu.builder()
                     .id(generateId("pdu", num + 1)).name(name).parentId(parentId).outletCount(rand.nextInt(100)).build();
             list.add(pdu);
             return pdu;
        }
        Ups ups = Ups.builder().id(generateId("ups", num + 1)).name(name).parentId(parentId).batteryPercentage(rand.nextInt(100)).build();
        list.add(ups);
        return ups;
    }

    private Integer getNumberFromId(String id) {
        return Integer.parseInt(CharMatcher.inRange('0', '9').retainFrom(id));
    }

    private String generateId(String type, Integer num) {
        return type + "-" + String.format("%02d", num);
    }
}
