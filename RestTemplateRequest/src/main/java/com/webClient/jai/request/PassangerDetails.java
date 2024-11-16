package com.webClient.jai.request;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassangerDetails {
	
	private String firstName; 
	private String from;
	private String journeyDate;
	private String lastName;
	private String to;
	private String trainNumber;
	
	

}