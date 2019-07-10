package com.pranay.SystemDesign.ParkingLot;

import java.util.ArrayList;
import java.util.List;

import com.pranay.SystemDesign.ParkingLot.Vehicle.SlotType;

public class Main {

	public static void main(String[] args) {
		List<ParkingSlot> parkingSlots = new ArrayList<>();
		parkingSlots.add(new ParkingSlot("1", SlotType.CAR));
		parkingSlots.add(new ParkingSlot("2", SlotType.CAR));
		parkingSlots.add(new ParkingSlot("3", SlotType.CAR));
		
		parkingSlots.add(new ParkingSlot("4", SlotType.BIKE));
		parkingSlots.add(new ParkingSlot("5", SlotType.BIKE));
		parkingSlots.add(new ParkingSlot("6", SlotType.BIKE));

		parkingSlots.add(new ParkingSlot("7", SlotType.BUS));
		parkingSlots.add(new ParkingSlot("8", SlotType.BUS));
		parkingSlots.add(new ParkingSlot("9", SlotType.BUS));
		
		ParkingLot parkingLot = new ParkingLot("pl1", 400072, parkingSlots);
		
		System.out.println("Car Queue : " + Car.queue);
		System.out.println("Bike Queue : " + Bike.queue);
		System.out.println("Bus Queue : " + Bus.queue);
		
		parkingLot.park(new Car("CAR123"));
		parkingLot.park(new Car("CAR111"));
		parkingLot.park(new Car("CAR122"));
		parkingLot.park(new Car("CAR133"));
		
		System.out.println("Car CAR122 parked at " + parkingLot.assignedSlots.get("CAR122"));
		
		parkingLot.park(new Bike("BIKE123"));
		parkingLot.park(new Bike("BIKE111"));
		parkingLot.park(new Bike("BIKE122"));
		parkingLot.park(new Bike("BIKE133"));
		
		System.out.println("Bike BIKE111 parked at " + parkingLot.assignedSlots.get("BIKE111"));
		
		parkingLot.park(new Bus("BUS123"));
		parkingLot.park(new Bus("BUS111"));
		parkingLot.park(new Bus("BUS122"));
		parkingLot.park(new Bus("BUS133"));
		
		System.out.println("Bike BUS123 parked at " + parkingLot.assignedSlots.get("BUS123"));
		
	}

}
