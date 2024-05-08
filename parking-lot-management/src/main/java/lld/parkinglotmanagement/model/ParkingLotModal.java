package lld.parkinglotmanagement.model;

import lld.parkinglotmanagement.model.notificationdeletor.ParkingLotChangeNotifier;
import lld.parkinglotmanagement.types.EntityStatus;

import java.util.Map;
import java.util.Optional;

public class ParkingLotModal {

    private final Map<String, Row> tickets;

    private final ParkingLotChangeNotifier notifier;

    public ParkingLotModal(Map<String, Row> tickets, ParkingLotChangeNotifier notifier) {
        this.tickets = tickets;
        this.notifier = notifier;
    }

    public void beforeChange() {
        this.notifier.notifyBeforeChange();
    }

    public void afterChange() {
        this.notifier.notifyAfterChange();
    }

    public Optional<Row> insertTicket(Row row) {
        this.beforeChange();
        Optional<Row> insertedRow =  Optional.ofNullable(this.tickets.put(row.getTicketNo(), row));
        this.afterChange();
        return insertedRow;
    }

    public Optional<Row> updateTicket(Row newRow) {
        this.beforeChange();
        Optional<Row> updatedRow = Optional.ofNullable(tickets.put(newRow.getTicketNo(), newRow));
        this.afterChange();
        return updatedRow;
    }

    public boolean deleteTicket(String ticketNo) {
        boolean isDeleted = false;
        this.beforeChange();
        Optional<Row> row = this.getTicket(ticketNo);
        if (row.isPresent()) {
            Row modifiedRow = row.get();
            modifiedRow.setStatus(EntityStatus.DELETE);
            this.updateTicket(modifiedRow);
            isDeleted = true;
        }
        this.afterChange();
        return isDeleted;
    }

    public Optional<Row> getTicket(String ticketNo) {
        this.beforeChange();
        Optional<Row> row = Optional.ofNullable(this.tickets.get(ticketNo));
        this.afterChange();
        return row;
    }
}
