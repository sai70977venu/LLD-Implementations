package lld.parkinglotmanagement.entity;

import java.time.LocalDateTime;

public class Ticket {

    private final String ticketNo;

    private final String vehicleRegNo;

    private final String status;

    private final LocalDateTime entryTimestamp;

    private LocalDateTime exitTimestamp;

    public Ticket(String ticketNo, String vehicleRegNo, String status) {
        this.ticketNo = ticketNo;
        this.vehicleRegNo = vehicleRegNo;
        this.status = status;
        this.entryTimestamp = LocalDateTime.now();
    }

    public String getTicketNo() {
        return this.ticketNo;
    }

    public String getVehicleRegNo() {
        return this.vehicleRegNo;
    }

    public String getStatus() {
        return this.status;
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
