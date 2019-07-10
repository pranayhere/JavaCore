package com.pranay.SystemDesign.ParkingLot;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

import com.pranay.SystemDesign.ParkingLot.Vehicle.SlotType;

public class Bus implements Vehicle {


	private String licenceNo;

	public Bus(String licenceNo) {
		super();
		this.licenceNo = licenceNo;
	}

	public static Queue<ParkingSlot> queue = new LinkedList<>();

	@Override
	public SlotType getSlotType(Vehicle vehicle) {
		return SlotType.BIKE;
	}

	@Override
	public Optional<ParkingSlot> getAvailableSlot(Vehicle vehicle) {
		System.out.println("inside getAvailableSlot car");
		if (queue.isEmpty()) {
			return Optional.ofNullable(null);
		}
		return Optional.of(queue.poll());
	}


	@Override
	public String getLicenseNo() {
		return this.licenceNo;
	}

	public void setLicenseNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
}
