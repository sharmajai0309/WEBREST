package in.pwskills.nitin.restcontroller;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.response.CurrencyResponse;
//http://localhost:9999/v1/api/currency/convertFromUSDToINR/from/USD/to/INR
@RestController
@RequestMapping("/v1/api/currency")
public class CurrencyConverter  {
    
    /**
     * Method: GET
     * Path: /convertFromUSDToINR/from/{from}/to/{to}
     * Input: @PathVariable (from, to)
     * Return Type: ResponseEntity<CurrencyResponse>
     */
    @GetMapping("/convert/from/{from}/to/{to}")
    public ResponseEntity<CurrencyResponse> convertCurrencyData(
            @PathVariable String from,
            @PathVariable String to) {
        
        // Simulating currency conversion
        CurrencyResponse response = new CurrencyResponse();
        response.setCurrencyId(1);
        response.setCurrencyFrom(from);
        response.setCurrencyTo(to);
        response.setCurrencyValue(83); // Example conversion value

        // Simulate processing time (optional, not recommended for production)
       
        
        return  ResponseEntity.ok(response);
    }
}
