package com.webClient.jai.runner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.webClient.jai.T.Ticket;
import com.webClient.jai.request.PassangerDetails;


@Component
public class Erailclient implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
    	String URL = "http://localhost:8888/v1/api/railway/createTicket";
    	
    	//sending a request PassangerDetails
    	PassangerDetails info = new PassangerDetails();
         
        info.setFirstName("Jai");
        info.setLastName("Sharma");
        info.setJourneyDate("12 April");
        info.setTrainNumber("1254");
        info.setTo("Indore");
        info.setFrom("Mumbai");

        // Log or print to verify
        System.out.println(info);
        
        //creating the header object for holding object
        HttpHeaders header = new HttpHeaders();
        header.add("Accept","application/json");
        header.add("content-type","application/json");
        
        //creating post request from rest template;
        HttpEntity<PassangerDetails> reEntity = new HttpEntity<PassangerDetails>(info, header);
        
        RestTemplate rt = new RestTemplate();
        ResponseEntity<Ticket>ticketEnity = rt.exchange(URL,HttpMethod.POST, reEntity, Ticket.class);
        
        System.out.println(ticketEnity.getStatusCode().value());
        System.out.print(ticketEnity.getBody());
        
        
        
        
        
    }
}
