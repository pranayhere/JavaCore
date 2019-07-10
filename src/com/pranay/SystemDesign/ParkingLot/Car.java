package com.pranay.SystemDesign.ParkingLot;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Car implements Vehicle {

	private String licenseNo;
	
	public Car(String licenseNo) {
		super();
		this.licenseNo = licenseNo;
	}

	public static Queue<ParkingSlot> queue = new LinkedList<>();

	@Override
	public SlotType getSlotType(Vehicle vehicle) {
		return SlotType.CAR;
	}

	@Override
	public Optional<ParkingSlot> getAvailableSlot(Vehicle vehicle) {
		System.out.println("inside getAvailableSlot car");
		if (queue.isEmpty()) {
			return Optional.ofNullable(null);
		}
		return Optional.of(queue.poll());
	}

	public void setLicenceNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	@Override
	public String getLicenseNo() {
		// TODO Auto-generated method stub
		return this.licenseNo;
	}
}
