package com.example.demo;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class LocationService {
    Datacenter datacenter = Datacenter.builder().id("dc-01").name("datacenter").createAt(LocalDate.now()).build();
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Row> rows = new ArrayList<>();
    ArrayList<Rack> racks = new ArrayList<>();

    public LocationService() {
        rooms.add(Room.builder().id("room-01").name("Room-1").parentId("dc-01").build());
        rooms.add(Room.builder().id("room-02").name("Room-1").parentId("dc-01").build());

        rows.add(Row.builder().id("row-01").name("Row-1").parentId("room-01").build());
        rows.add(Row.builder().id("row-02").name("Row-2").parentId("room-01").build());
        rows.add(Row.builder().id("row-03").name("Row-3").parentId("room-02").build());

        racks.add(Rack.builder().id("rack-01").name("Rack-1").parentId("row-01").build());
        racks.add(Rack.builder().id("rack-02").name("Rack-2").parentId("row-01").build());
        racks.add(Rack.builder().id("rack-03").name("Rack-3").parentId("row-01").build());
        racks.add(Rack.builder().id("rack-04").name("Rack-4").parentId("row-02").build());
        racks.add(Rack.builder().id("rack-05").name("Rack-5").parentId("row-02").build());
    }

    public Datacenter getDatacenter() {
        return datacenter;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getRoom(String id) {
        return rooms.stream().filter(room -> room.id.equals(id)).findFirst().orElseThrow(RoomNotFoundException::new);
    }

    public List<Row> getRows() {
        return rows;
    }

    public Row getRow(String id) {
        return rows.stream().filter(row -> row.id.equals(id)).findFirst().orElseThrow(RowNotFoundException::new);
    }

    public List<Rack> getRacks() {
        return racks;
    }

    public Rack getRack(String id) {
        return racks.stream().filter(rack -> rack.id.equals(id)).findFirst().orElseThrow(RackNotFoundException::new);
    }

    public List<Row> getRowForRoomId(String id) {
        return rows.stream().filter(row -> row.parentId.equals(id)).toList();
    }

    public List<Rack> getRackForRowId(String id) {
        return racks.stream().filter(rack -> rack.parentId.equals(id)).toList();
    }
}
