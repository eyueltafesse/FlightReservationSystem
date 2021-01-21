package Domain;

import java.util.*;

import DataAccess.DataModel;

public class Airport {

	private final String id;
	private String code; // It must be 3 char code
	private String name;
	private Address airportAddress;

	public Airport(String code, String name, Address address) throws UserException {
		if (code.length() != 3) {
			throw new UserException("The airport code must be 3 characters");
		}
		id = UUID.randomUUID().toString();
		this.code = code;
		this.name = name;
		this.airportAddress = address;
		
		DataModel.airportDataModel.addEntity(this);
	}

	public String getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAirportAddress() {
		return airportAddress;
	}

	public void setAirportAddress(Address airportAddress) {
		this.airportAddress = airportAddress;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %s\tCode: %s\tName: %s", this.id, this.code, this.name);
	}

}
