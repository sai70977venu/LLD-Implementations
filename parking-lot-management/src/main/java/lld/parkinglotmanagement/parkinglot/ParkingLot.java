package lld.parkinglotmanagement.parkinglot;

public interface ParkingLot {
    public void createParkingLot();

    public void addFloors();

    public void park();

    public void unpark();

    public void getNumberOfFreeSlotsByVehicleTypePerFloor();

    public void getAllTheFreeSlotsByVehicleTypePerFloor();

    public void getAllTheOccupiedSlotsByVehicleTypePerFloor();
}
