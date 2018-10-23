package com.sqli.domain;

public class VehiclesFactory {

	
	public static Vehicle newVehicle(String vehicle) {
		String[] dataV = vehicle.split(":");
		Vehicle v = new Vehicle();
		v.setVehicleType(dataV[0].replace(" ",""));
		v.setVehicleFuel(dataV[1]);
		v.setVehicleDoors(Integer.valueOf(dataV[2]));
		return v;
		
	}
}
