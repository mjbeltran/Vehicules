package com.sqli.strategyconsume;

import java.util.Map;

import com.sqli.bussines.FuelPrice;
import com.sqli.conf.Config;

public class Diesel implements ConsumeStrategyI {

	private static Diesel dieselInstance;

	public static Diesel getInstace() {
		if (dieselInstance == null) {
			dieselInstance = new Diesel();
		}
		return dieselInstance;
	}

	public String consume(double kms) {
		Map<String, Double> fuelConsume = FuelPrice.fuelPrices();
		float consume = (float) (kms * fuelConsume.get(Config.DIESEL));
		String formattedString = String.format("%.02f", consume);
		return formattedString;
	}

}
