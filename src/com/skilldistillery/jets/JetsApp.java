package com.skilldistillery.jets;

import java.util.*;

public class JetsApp {
	private Airfield airfield = new Airfield();

	public Airfield getAirfield() {
		return airfield;
	}

	public void setAirfield(Airfield airfield) {
		this.airfield = airfield;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		JetsApp ja = new JetsApp();
		ja.menu(kb);

	}

	public void menu(Scanner kb) {

		int choice = -1;
		while (choice != 9) {
			System.out.println(" 1. List fleet ");
			System.out.println(" 2. Fly all jets ");
			System.out.println(" 3. View fastest jets");
			System.out.println(" 4. View jet with longest range");
			System.out.println(" 5. Load all Cargo Jets ");
			System.out.println(" 6. Dogfight!");
			System.out.println(" 7. Add a jet to Fleet");
			System.out.println(" 8. Remove a jet from Fleet ");
			System.out.println(" 9. Quit ");

			choice = kb.nextInt();
			switch (choice) {
			case 1:
				airfield.displayJets();
				break;
			case 2:
				// tell all jets to fly
				airfield.makeJetsFly();
				break;
			case 3:
				// view fastest jets
				airfield.fastestSpeed();
				break;
			case 4:
				// view jet with longest range
				airfield.longestRange();
				break;
			case 5:
				// load all cargo jets
				airfield.loadJets();
				break;
			case 6:
				// dogfight
				airfield.makeJetsFight();
				break;
			case 7:
				// add a jet from Fleet
				airfield.addJet(kb);
				break;
			case 8:
				// Remove a jet from Fleet
				airfield.removeJet(kb);
				break;
			case 9:
				// quit
				System.exit(0);
				break;
			default:
				System.err.println("Please only input a number from 1-9.");
				break;
			}
		}

	}
}
