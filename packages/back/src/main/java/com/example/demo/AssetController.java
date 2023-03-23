package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AssetController {
    @Autowired
    AssetService assetService;
    @Autowired
    LocationService locationService;

    @QueryMapping
    public List<AbstractAsset> assets() {
        return assetService.getAll();
    }

    @QueryMapping
    public AbstractAsset asset(@Argument String id) {
        return assetService.getById(id);
    }

    @QueryMapping
    public Datacenter datacenter() {
        return locationService.getDatacenter();
    }

    @QueryMapping
    public List<Room> rooms() {
        return locationService.getRooms();
    }

    @QueryMapping
    public List<AbstractLocation> locations() {
        ArrayList<AbstractLocation> locations = new ArrayList<>();
        locations.add(locationService.getDatacenter());
        locations.addAll(locationService.getRooms());
        locations.addAll(locationService.getRows());
        locations.addAll(locationService.getRacks());
        return locations;
    }

    @QueryMapping
    public Room room(@Argument String id) {
        return locationService.getRoom(id);
    }

    @QueryMapping
    public List<Row> rows() {
        return locationService.getRows();
    }

    @QueryMapping
    public Row row(@Argument String id) {
        return locationService.getRow(id);
    }

    @QueryMapping
    public List<Rack> racks() {
        return locationService.getRacks();
    }

    @QueryMapping
    public Rack rack(@Argument String id) {
        return locationService.getRack(id);
    }

    @SchemaMapping(typeName = "Datacenter", field = "rooms")
    public List<Room> datacenterRooms() {
        return locationService.getRooms();
    }

    @SchemaMapping(typeName = "Room", field = "rows")
    public List<Row> roomRows(Room room) {
        return locationService.getRowForRoomId(room.id);
    }

    @SchemaMapping(typeName = "Row", field = "racks")
    public List<Rack> rowRacks(Row row) {
        return locationService.getRackForRowId(row.id);
    }

    @SchemaMapping(typeName = "Rack", field = "assets")
    public List<AbstractAsset> rackAssets(Rack rack) {
        return assetService.getAssetsForRack(rack.id);
    }

    @SchemaMapping(typeName = "Room", field = "parent")
    public Datacenter roomParent(Room room) {
        return locationService.getDatacenter();
    }

    @SchemaMapping(typeName = "Row", field = "parent")
    public Room rowParent(Row row) {
        return locationService.getRoom(row.parentId);
    }

    @SchemaMapping(typeName = "Rack", field = "parent")
    public Row rackParent(Rack rack) {
        return locationService.getRow(rack.parentId);
    }

    @SchemaMapping(typeName = "Pdu", field = "parent")
    public AbstractLocation pduParent(Pdu pdu) {
        return locationService.getRack(pdu.getParentId());
    }

    @SchemaMapping(typeName = "Ups", field = "parent")
    public AbstractLocation assetParent(Ups ups) {
        return locationService.getRack(ups.getParentId());
    }

    @MutationMapping
    public AbstractAsset createAsset(@Argument String name, @Argument String parentId) {
        return assetService.createRandomAsset(name, parentId);
    }
}
