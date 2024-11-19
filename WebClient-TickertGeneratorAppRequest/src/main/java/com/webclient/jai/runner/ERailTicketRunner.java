package com.webclient.jai.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.webclient.jai.request.PassengerInfo;
import com.webclient.jai.response.Ticket;

@Service
public class ERailTicketRunner implements CommandLineRunner {
private String url = "http://localhost:9999/v1/api/railway/createTicket";
	
	@Override
	public void run(String... args) throws Exception {

		PassengerInfo body = new PassengerInfo();
		body.setFirstName("Ashish");
		body.setLastName("Gosh");
		body.setJourneyDate("21/09/2024");
		body.setFrom("Bengaluru");
		body.setTo("Delhi");
		body.setTrainNumber("Rajdhani");
		
		invokeASynchRestApi(body);
		
	}

//	private void invokeSynchRestApi(PassengerInfo body) {
//	    WebClient webClient = WebClient.create();
//
//	    System.out.println("***SynchRequest : WEBCLIENT Started ****");
//
//	    try {
//	        Ticket ticket = webClient
//	            .post()
//	            .uri(url)
//	            .body(BodyInserters.fromValue(body))
//	            .retrieve()
//	            .onStatus(
//	                status -> status.isError(),
//	                response -> response.bodyToMono(String.class).map(RuntimeException::new)
//	            )
//	            .bodyToMono(Ticket.class)
//	            .block();
//
//	        System.out.println("Response Received: " + ticket);
//	    } catch (Exception e) {
//	        System.err.println("Error during WebClient request: " + e.getMessage());
//	    }
//
//	    System.out.println("***SynchRequest : WEBCLIENT Ended ****");
//	}
	private void invokeASynchRestApi(PassengerInfo body) {
	    WebClient webClient = WebClient.create();

	    System.out.println("***AsynchRequest : WEBCLIENT Started ****");

	    try {
	        // Asynchronous request with subscribe()
	        webClient
	            .post()
	            .uri(url)
	            .body(BodyInserters.fromValue(body))
	            .retrieve()
	            .bodyToMono(Ticket.class)
	            .subscribe(ERailTicketRunner::consumerInput); // Callback for the response
	    } catch (Exception e) {
	        System.err.println("Error during WebClient request: " + e.getMessage());
	    }

	    System.out.println("***AsynchRequest : WEBCLIENT Ended ****");
	}

	// Static method to process the response
	public static void consumerInput(Ticket t) {
	    System.out.println("Response Received: " + t);
	}
}

	

