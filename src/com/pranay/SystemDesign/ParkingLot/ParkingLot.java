package com.pranay.SystemDesign.ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingLot {
	public static Map<String, String> assignedSlots = new HashMap<>();
	
	private String name;
	private int zipCode;
	private List<ParkingSlot> parkingSlots;
	
	public ParkingLot(String name, int zipCode, List<ParkingSlot> parkingSlots) {
		super();
		setName(name);
		setZipCode(zipCode);
		setParkingSlots(parkingSlots);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public List<ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(List<ParkingSlot> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}
	
	public void park(Vehicle vehicle) {
		Optional<ParkingSlot> slot = vehicle.getAvailableSlot(vehicle);
		if (!slot.isPresent()) {
			System.out.println("No Slot is available");
			return;
		}
		ParkingSlot parkingSlot = slot.get();
		System.out.println("Available slot : "+parkingSlot.getSlotNumber());
		assignedSlots.put(vehicle.getLicenseNo(), parkingSlot.getSlotNumber());
	}
}