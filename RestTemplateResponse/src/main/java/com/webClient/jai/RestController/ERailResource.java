package com.webClient.jai.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webClient.jai.request.PassengerInfo;
import com.webClient.jai.response.Ticket;


		
@RestController
@RequestMapping("/v1/api/railway")
public class ERailResource {
	/*
	 * METHOD : POST
	 * INPUT  : PassengerDetails(@RequestBody)
	 * OutPut : TIcketObject(Json)
	 * input  : "/createTicket"

	 */
	@PostMapping("/createTicket")
	public ResponseEntity<Ticket> bookTickets(@RequestBody PassengerInfo info) {
	    // Current date for booking
	   

	    Ticket t = new Ticket();
	    t.setTicketId("TAjnwaf008");               // Assuming ticket ID will be auto-generated or handled differently
	    t.setTicketStatus("CNF");                // Setting ticket status
	    t.setJourneyDate(info.getJourneyDate()); // Assuming info.getJourneyDate() returns a Date object
	    t.setTrainNumber(info.getTrainNumber()); // Assuming train number is already set in PassengerInfo
	    t.setTicketPrice(350.00);                // Static ticket price, consider making it dynamic
	    t.setFrom(info.getFrom());               // Setting source station
	    t.setTo(info.getTo());                   // Setting destination station
	    t.setPassengerName(info.getFirstName() + info.getLastName());
	    
	    try {
			Thread.sleep(7000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	    // Return the created ticket object with HTTP status 201 (CREATED)
	    return new ResponseEntity<Ticket>(t,HttpStatus.CREATED);
	}


	
}
