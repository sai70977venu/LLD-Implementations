package lld.parkinglotmanagement.entity;

import lld.parkinglotmanagement.types.Color;
import lld.parkinglotmanagement.types.VehicleType;

public class Vehicle {

    private final VehicleType type;

    private final String registrationNo;

    private final Color color;

    public Vehicle(VehicleType type, String registrationNo, Color color) {
        this.type = type;
        this.registrationNo = registrationNo;
        this.color = color;
    }

    public VehicleType getType() {
        return type;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public Color getColor() {
        return color;
    }
}
