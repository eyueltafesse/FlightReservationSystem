package business;

import Domain.*;
import DataAccess.DataModel;

public class FlightBusiness {

	public void FlightsBetween(Airport departure, Airport destination) {
		for(Flight flight : DataModel.flightDataModel.getall()) {
			if(flight.getDepartureAirport() == departure && flight.getArrivalAirport() == destination) {
				System.out.println(flight);
			}
		}
	}
	
	public void ViewReservations(Passenger psngr) {
		for(Reservation rsvn : psngr.ViewAllReservations()) {
			System.out.println(rsvn);
		}
	}
	
	
}
