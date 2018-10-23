package com.sqli.bussines;

import java.util.HashMap;
import java.util.Map;

import com.sqli.conf.Config;
import com.sqli.domain.Vehicle;
import com.sqli.domain.VehiclesFactory;

public class Vehicles {

	private Map<String, Vehicle> listVehicles = new HashMap<String, Vehicle>();

	public Vehicles(String vehicle) {

		String[] vehicles = vehicle.split(Config.VEHICLES_SEPARATOR);
		Vehicle v;
		for (int i = 0; i < vehicles.length; i++) {
			v = VehiclesFactory.newVehicle(vehicles[i]);
			listVehicles.put(v.getVehicleType(), v);

		}
	}

	public String move(String typeVehicle, String numberDoors, String kms) {

		Vehicle settingsVehicle = listVehicles.get(typeVehicle);

		if (settingsVehicle.getVehicleType().equals(Config.CAR)) {

			return ReporManager.moveCar(settingsVehicle, numberDoors, kms);

		} else if (settingsVehicle.getVehicleType().equals(Config.TRUCK)) {

			return ReporManager.moveTruck(settingsVehicle, numberDoors, kms);
		} else if (settingsVehicle.getVehicleType().equals(Config.MOTORCYCLE)) {

			return ReporManager.moveMotorBike(settingsVehicle, numberDoors, kms);
		}

		return null;
	}

}
