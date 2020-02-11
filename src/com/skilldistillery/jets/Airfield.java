package com.skilldistillery.jets;

import java.io.*;
import java.util.*;

public class Airfield {
	private Scanner kb = new Scanner(System.in);
	private List<Jets> jets = new ArrayList<>();

	public Airfield() {
		readAndPopulateFromFile();

	}

	public List<Jets> readAndPopulateFromFile() {
		BufferedReader buf = null;
		try {
			FileReader fr = new FileReader("jets.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				String type = fields[0].trim();
				String model = fields[1].trim();

				double speed = Double.parseDouble(fields[2].trim());
				int range = Integer.parseInt(fields[3].trim());
				long price = Long.parseLong(fields[4].trim());

				if (type.contentEquals("FighterJet")) {
					jets.add(new FighterJet(model, speed, range, price));
				} else if (type.contentEquals("CargoPlane")) {
					jets.add(new CargoPlane(model, speed, range, price));
				} else if (type.contentEquals("JetImpl")) {
					jets.add(new JetImpl(model, speed, range, price));
				} else {
					System.out.println("I'm sorry. Was not able to recognize your input.");
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Problem with: " + e.getMessage());
		}
		return jets;
	}

	public void displayJets() {
		for (Jets aircraft : jets) {
			System.out.print(aircraft);
		}
	}

	public void makeJetsFly() {
		for (Jets jetsFlyingWow : jets) {
			jetsFlyingWow.fly();
			System.out.println();
		}
	}

	public void makeJetsFight() {
		for (Jets aircraft : jets) {
			if (aircraft instanceof FighterJet) {
				((FighterJet) aircraft).fight();
			}
		}
	}

	public void loadJets() {
		for (Jets cargo : jets) {
			if (cargo instanceof CargoPlane) {
				((CargoPlane) cargo).loadCargo();
			}
		}
	}

	public void longestRange() {
		int longestRange = Integer.MIN_VALUE;
		Jets longRange = null;
		for (Jets aircraft : jets) {
			if (aircraft.getRange() > longestRange) {
				String longest = aircraft.getRange() + " " + aircraft.getModel();
				longestRange = aircraft.getRange();
				longRange = aircraft;
			}
		}
		System.out.println("The jet with the longest range is " + longRange.getModel() + " with a range of "
				+ longRange.getRange() + " miles. " + "\nPrice tag of $ " + longRange.getPrice()
				+ " because the speed is a weasly " + longRange.getSpeedInMach() + " mach.");
	}

	public void fastestSpeed() {
		double fastestSpeed = Double.MIN_VALUE;
		Jets fastestJet = null;
		for (Jets eachJet : jets) {
			if (eachJet.getSpeed() > fastestSpeed) {
				String fastest = eachJet.getSpeed() + " " + eachJet.getModel();
				fastestSpeed = eachJet.getSpeed();
				fastestJet = eachJet;
			}
		}
		System.out.println("The jet " + fastestJet.getModel() + " has the fastest speed of "
				+ fastestJet.getSpeedInMach() + " mach. " + "\nRange (miles): " + fastestJet.getRange() + "\nPrice: $ "
				+ fastestJet.getPrice());
	}

	public void addJet(Scanner kb2) {
		System.out.println("I see you would like to ADD a jet...");
		System.out.println("Would you like to add-- 1. Fighter Jet,  2.Cargo Plane  or 3. Passenger Plane? ");
		int type = kb.nextInt();
		System.out.println("Enter your model name: ");
		String modelName = kb.next();
		System.out.println("Enter the price: ");
		long newPrice = kb.nextInt();
		System.out.println("Enter the range (in miles): ");
		int newRange = kb.nextInt();
		System.out.println("Enter the speed (MPH): ");
		int newSpeed = kb.nextInt();

		Jets addedJet = null;
		if (type == 1) {
			addedJet = new FighterJet(modelName, newSpeed, newRange, newPrice);
			jets.add(addedJet);
			System.out.println("Added a fighter jet " + addedJet.toString());
		} else if (type == 2) {
			addedJet = new CargoPlane(modelName, newSpeed, newRange, newPrice);
			jets.add(addedJet);
			System.out.println("Added a cargo plane " + addedJet.toString());
		} else if (type == 3) {
			addedJet = new JetImpl(modelName, newSpeed, newRange, newPrice);
			jets.add(addedJet);
		} else {
			System.out.println("I'm sorry, your plane has not been added yet due to an error.");
		}

	}

	public void removeJet(Scanner kb2) {
		System.out.println("I see you would like to REMOVE a jet..." + "\n Which one? Put the number in.");
		int count = 1;
		for (Jets jetsInd : jets) {
			System.out.println(count + " " + jetsInd.toString());
			count++;
		}
		int input = kb.nextInt();
		Jets removal = jets.remove(input - 1);
		System.out.println(removal.getModel() + " has been removed from the fleet.");
	}
}
