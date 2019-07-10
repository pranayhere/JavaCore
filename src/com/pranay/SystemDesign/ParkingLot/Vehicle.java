package com.pranay.SystemDesign.ParkingLot;

import java.util.Optional;

public interface Vehicle {
	public enum SlotType {CAR, BUS, BIKE};
	public SlotType getSlotType(Vehicle vehicle);
	public Optional<ParkingSlot> getAvailableSlot(Vehicle vehicle);
	public String getLicenseNo();
}
