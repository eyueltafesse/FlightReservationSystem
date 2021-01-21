package business;

import java.util.*;

import DataAccess.DataModel;
import DataAccess.FlightDataModel;
import Domain.Airline;
import Domain.Flight;

public final class AirLineBusiness {

	// View list of airlines flying out of an airport (search by airport three
	// letter code)

	// Airline has list of flights
	// Flight has departure and arrival airports
	// Search by airport three letter code

	private AirLineBusiness() {
	}

	public static void airlinesFlyingOutFromSpecificAirport(String airportCode) {

		List<Flight> allFlights = DataModel.flightDataModel.getall();
		List<Airline> allAirLines = DataModel.airLineDataModel.getall();

		List<Flight> flightsOutOfAnAirport = new ArrayList<>();
		List<Airline> airLinesOutOfAnAirport = new ArrayList<>();

		for (Flight f : allFlights) {
			if (f.getDepartureAirport().getCode().equals(airportCode))
				flightsOutOfAnAirport.add(f);
		}

		boolean airLineFound;
		for (Airline a : allAirLines) {
			airLineFound = false;
			for (Flight f : a.getFlights()) {
					if(airLineFound == true)
						break;
				for (Flight fo : flightsOutOfAnAirport)
					if (f.getId() == fo.getId()) {
						airLinesOutOfAnAirport.add(a);
						airLineFound = true;
						break;
					}
			}
		}

	}

}
