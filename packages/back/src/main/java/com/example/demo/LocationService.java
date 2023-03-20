package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocationService {
    Datacenter datacenter = Datacenter.builder().id("1").name("datacanter").build();
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Row> rows = new ArrayList<>();
    ArrayList<Rack> racks = new ArrayList<>();

    public LocationService() {
        rooms.add(Room.builder().id("1").name("Room-1").parentId("1").build());
        rooms.add(Room.builder().id("2").name("Room-1").parentId("1").build());

        rows.add(Row.builder().id("1").name("Row-1").parentId("1").build());
        rows.add(Row.builder().id("2").name("Row-2").parentId("1").build());
        rows.add(Row.builder().id("3").name("Row-3").parentId("2").build());
        rows.add(Row.builder().id("4").name("Row-4").parentId("2").build());
        rows.add(Row.builder().id("5").name("Row-5").parentId("1").build());

        racks.add(Rack.builder().id("1").name("Rack-1").parentId("1").build());
        racks.add(Rack.builder().id("2").name("Rack-2").parentId("2").build());
        racks.add(Rack.builder().id("3").name("Rack-3").parentId("3").build());
        racks.add(Rack.builder().id("4").name("Rack-4").parentId("4").build());
        racks.add(Rack.builder().id("5").name("Rack-5").parentId("5").build());
        racks.add(Rack.builder().id("6").name("Rack-6").parentId("6").build());
        racks.add(Rack.builder().id("7").name("Rack-7").parentId("7").build());
        racks.add(Rack.builder().id("8").name("Rack-8").parentId("8").build());
        racks.add(Rack.builder().id("9").name("Rack-9").parentId("9").build());
    }

    public Datacenter getDatacenter() {
        return datacenter;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Row> getRowForRoomId(String id) {
        return rows.stream().filter(row -> row.parentId.equals(id)).toList();
    }

    public List<Rack> getRackForRowId(String id) {
        return racks.stream().filter(rack -> rack.parentId.equals(id)).toList();
    }
}
