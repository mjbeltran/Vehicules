package com.sqli.strategyconsume;

import java.util.Map;

import com.sqli.bussines.FuelPrice;
import com.sqli.conf.Config;

public class Gasoline implements ConsumeStrategyI {

	private static Gasoline gasolineInstance;

	public static Gasoline getInstace() {
		if (gasolineInstance == null) {
			gasolineInstance = new Gasoline();
		}
		return gasolineInstance;
	}

	public String consume(double kms) {
		Map<String, Double> fuelConsume = FuelPrice.fuelPrices();
		float consume = (float) (kms * fuelConsume.get(Config.GASOLINE));
		String formattedString = String.format("%.02f", consume);
		return formattedString;
	}

}
