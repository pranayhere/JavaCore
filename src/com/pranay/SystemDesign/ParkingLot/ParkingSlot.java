package com.pranay.SystemDesign.ParkingLot;

import com.pranay.SystemDesign.ParkingLot.Vehicle.SlotType;

public class ParkingSlot {
	private String slotNumber;
	private SlotType type;

	public ParkingSlot(String slotNumber, SlotType type) {
		super();
		setSlotNumber(slotNumber);
		setType(type);
	}
	
	public String getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	public SlotType getType() {
		return type;
	}

	public void setType(SlotType type) {
		this.type = type;

		if (type.equals(SlotType.CAR)) {
			Car.queue.add(this);
		} else if (type.equals(SlotType.BIKE)) {
			Bike.queue.add(this);
		} else {
			Bus.queue.add(this);
		}		
	}
	
	@Override
	public String toString() {
		return String.format(this.slotNumber);
	}
}