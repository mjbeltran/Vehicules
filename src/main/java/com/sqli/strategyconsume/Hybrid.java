package com.sqli.strategyconsume;

import java.util.Map;

import com.sqli.bussines.FuelPrice;
import com.sqli.conf.Config;

public class Hybrid implements ConsumeStrategyI {

	private static Hybrid hybridInstance;

	public static Hybrid getInstace() {
		if (hybridInstance == null) {
			hybridInstance = new Hybrid();
		}
		return hybridInstance;
	}

	public String consume(double kms) {
		Map<String, Double> fuelConsume = FuelPrice.fuelPrices();
		float consume = (float) (kms * fuelConsume.get(Config.HYBRID));
		String formattedString = String.format("%.02f", consume);
		return formattedString;
	}
}
