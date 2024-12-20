package com.webclient.jai.Respnse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyResponse {

	private Integer currencyId;
	private String currencyFrom;
	private String currencyTo;
	private Integer currencyValue;
}

