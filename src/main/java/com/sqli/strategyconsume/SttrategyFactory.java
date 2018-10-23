package com.sqli.strategyconsume;

import org.apache.commons.lang3.StringUtils;

import com.sqli.conf.Config;

public class SttrategyFactory {

	public static ConsumeStrategyI getFuel(String getTypeFuel) {

		ConsumeStrategyI fuel = null;

		if (!StringUtils.isBlank(getTypeFuel)) {
			if (Config.DIESEL.equals(getTypeFuel)) {
				fuel = new Diesel();
			}
			if (Config.GASOLINE.equals(getTypeFuel)) {
				fuel = new Gasoline();
			}
			if (Config.HYBRID.equals(getTypeFuel)) {
				fuel = new Hybrid();
			}
		}

		return fuel;
	}

}
