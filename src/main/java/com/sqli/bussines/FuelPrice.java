package com.sqli.bussines;

import java.util.HashMap;
import java.util.Map;

public class FuelPrice {

	// - Diesel: 5%
	// - Gasoline: 6%
	// - Hybrid: 3%

	private static Map<String, Double> fuelConsume = new HashMap<String, Double>();

	public static Map<String, Double> fuelPrices() {
		fuelConsume.put("Diesel", 0.05);
		fuelConsume.put("Gasoline", 0.06);
		fuelConsume.put("Hybrid", 0.03);

		return fuelConsume;
	}

}
