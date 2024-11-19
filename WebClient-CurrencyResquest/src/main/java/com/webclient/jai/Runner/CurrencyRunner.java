package com.webclient.jai.Runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.webclient.jai.Respnse.CurrencyResponse;

@Component
public class CurrencyRunner implements CommandLineRunner {
	 private String url = "http://localhost:9999/v1/api/currency/convert/from/{from}/to/{to}";
	 

	@Override
	public void run(String... args) throws Exception {
		invokeRestApiSync("USD","INR");
		invokeRestApiAsync("USD","INR");
    
	}
	
	private void invokeRestApiAsync(String from, String to) {
		 System.out.println("Web client Started");
		WebClient webClient = WebClient.create();
		webClient.get()
		         .uri(url,from,to)
		         .retrieve()  
		         .bodyToMono(CurrencyResponse.class)
		         .subscribe(CurrencyRunner :: consumeInput);
		 System.out.println("Web client Ended");
	}
	public static void consumeInput(CurrencyResponse response) {
		System.out.println(response);
	}
	 

	
	private void invokeRestApiSync(String from, String to) {
		// Working with WebClient
		 System.out.println("Web client Started");
		WebClient webClient = WebClient.create();
		CurrencyResponse res1 =  webClient.get().uri(url,from,to).retrieve().bodyToMono(CurrencyResponse.class).block();
		 System.out.println(res1);
		 System.out.println("Web client Ended");
		
		 
		
		
	}

}
