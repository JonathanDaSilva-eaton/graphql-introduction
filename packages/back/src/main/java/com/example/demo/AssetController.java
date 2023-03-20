package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;

import java.util.List;

@Controller
public class AssetController {
    @Autowired
    AssetService assetService;
    @Autowired
    LocationService locationService;

    @QueryMapping
    public List<Asset> assets() {
        return assetService.getAll();
    }

    @QueryMapping
    public Asset asset(@Argument String id) {
        return assetService.getById(id);
    }

    @QueryMapping
    public Datacenter datacenter() {
        return locationService.getDatacenter();
    }

    @SchemaMapping(typeName="Datacenter", field="rooms")
    public List<Room> datacenterRooms() {
        return locationService.getRooms();
    }

    @SchemaMapping(typeName="Room", field="rows")
    public List<Row> roomRows(Room room) {
        return locationService.getRowForRoomId(room.id);
    }

    @SchemaMapping(typeName="Row", field="racks")
    public List<Rack> rowRacks(Row row) {
        return locationService.getRackForRowId(row.id);
    }

}
