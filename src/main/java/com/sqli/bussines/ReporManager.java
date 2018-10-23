package com.sqli.bussines;

import java.util.Arrays;
import java.util.List;

import com.sqli.conf.Config;
import com.sqli.domain.Vehicle;
import com.sqli.strategyconsume.SttrategyFactory;

public class ReporManager {

	public static String moveCar(Vehicle settingsVehicle, String numberDoors, String kms) {

		StringBuilder stringReturn = new StringBuilder();
		if (numberDoors.split(" ").length == Config.DOORS_CAR) {

			String formattedString = SttrategyFactory.getFuel(settingsVehicle.getVehicleFuel())
					.consume(Double.valueOf(kms.split(" ")[0]));
			stringReturn.append("DOORS OK, MOVING. The CAR will consume ").append(formattedString.replace(",", "."))
					.append(" L");
		} else {
			stringReturn.append(dealDoorsCar(numberDoors));
		}

		return stringReturn.toString();
	}

	public static String moveTruck(Vehicle settingsVehicle, String numberDoors, String kms) {

		StringBuilder stringReturn = new StringBuilder();
		if (numberDoors.split(" ").length == Config.DOORS_TRUCK) {
			String formattedString = SttrategyFactory.getFuel(settingsVehicle.getVehicleFuel())
					.consume(Double.valueOf(kms.split(" ")[0]));
			stringReturn.append("DOORS OK, MOVING. The TRUCK will consume ").append(formattedString.replace(",", "."))
					.append(" L");
		}

		return stringReturn.toString();
	}

	public static String moveMotorBike(Vehicle settingsVehicle, String numberDoors, String kms) {
		StringBuilder stringReturn = new StringBuilder();
		if (numberDoors.equals(Config.DOORS_MOTORBIKE)) {

			String formattedString = SttrategyFactory.getFuel(settingsVehicle.getVehicleFuel())
					.consume(Double.valueOf(kms.split(" ")[0]));
			stringReturn.append("DOORS OK, MOVING. The MOTORCYCLE will consume ")
					.append(formattedString.replace(",", ".")).append(" L");
		}

		return stringReturn.toString();
	}

	private static String dealDoorsCar(String numberDoors) {

		StringBuilder stringReturn = new StringBuilder();

		String[] doors = numberDoors.split(" ");

		List<String> wordList = Arrays.asList(doors);

		if (!wordList.contains("1")) {
			stringReturn.append("DOORS KO, BLOCKED \n" + "  _\n" + " / |\\n" + " |_|");
		}

		if (!wordList.contains("2")) {
			stringReturn.append("DOORS KO, BLOCKED \n" + "  _\n" + " | \\\n" + " |_|");
		} else if (!wordList.contains("3")) {
			stringReturn.append("DOORS KO, BLOCKED \n" + "  _\n" + " | |\n" + " /_|");
		} else if (!wordList.contains("3")) {
			stringReturn.append("DOORS KO, BLOCKED \n" + "  _\n" + " | |\n" + " |_\\");
		}

		return stringReturn.toString();
	}

}
