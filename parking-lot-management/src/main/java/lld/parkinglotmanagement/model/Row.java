package lld.parkinglotmanagement.model;

import lld.parkinglotmanagement.types.EntityStatus;

import java.time.LocalDateTime;

public class Row {

    private final String ticketNo;

    private final Long floorNo;

    private final String vehicleRegNo;

    private EntityStatus status;

    private final LocalDateTime entryTimestamp;

    private LocalDateTime exitTimestamp;

    public Row(String ticketNo, Long floorNo, String vehicleRegNo, EntityStatus status) {
        this.ticketNo = ticketNo;
        this.floorNo = floorNo;
        this.vehicleRegNo = vehicleRegNo;
        this.status = status;
        this.entryTimestamp = LocalDateTime.now();
    }

    public String getTicketNo() {
        return this.ticketNo;
    }

    public Long getFloorNo() {
        return floorNo;
    }

    public String getVehicleRegNo() {
        return this.vehicleRegNo;
    }

    public EntityStatus getStatus() {
        return this.status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public LocalDateTime getEntryTimestamp() {
        return this.entryTimestamp;
    }

    public void setExitTimestamp(LocalDateTime dateTime) {
        this.exitTimestamp = dateTime;
    }

    public LocalDateTime getExitTimestamp() {
        return this.exitTimestamp;
    }
}