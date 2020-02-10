package com.skilldistillery.jets;

public class FighterJet extends Jets implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println("Dogfight is happening LIVE..");
	}

}
