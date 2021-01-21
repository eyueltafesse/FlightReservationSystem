package Domain;

import java.util.*;

import DataAccess.DataModel;

import java.time.LocalTime;

public class Flight {

	private final String id;
	private String number; // Unique random 4 digits number
	private int capacity;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private Airport departureAirport;
	private Airport arrivalAirport;
	// To make sure that the generated random number wasn't used before
	private ArrayList<Integer> randomNumbersInUse = new ArrayList<>();

	public Flight(int numOfSeats, LocalTime departureTime, LocalTime arrivalTime, Airport departureAirport,
			Airport arrivalAirport) throws Exception {
		this.id = UUID.randomUUID().toString();
		this.number = getRandomNumber();
		this.capacity = numOfSeats;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;

		DataModel.flightDataModel.addEntity(this);

	}

	// A unique random number is generated here
	private String getRandomNumber() throws Exception {

		Random r = new Random();
		int rNumber = r.nextInt(1000);
		if (randomNumbersInUse.size() == 999)
			throw new Exception("The random numbers in use List has to be enlarged");
		while (randomNumbersInUse.contains(rNumber) || rNumber == 0) {
			rNumber = r.nextInt(1000);
		}
		randomNumbersInUse.add(rNumber);

		return rNumber + "";
	}

	public String getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %s\tNumber: %s\tCapacity: %d\tDeparture Time: %s\tArrival Time: %s\t"
				+ "From: %s\t To: %s", id, number, capacity, departureTime.toString(), arrivalTime.toString(), 
				departureAirport.getCode(), arrivalAirport.getCode());
	}

}
