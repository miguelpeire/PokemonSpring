package es.salesianos.model;

//import java.util.Random;

public class AbstractPokeball implements Pokeballs {

	public int capturePower;
	public String name;

	@Override
	public int getCapture() {
		return capturePower;
	}

	public void setCapturePower(int capturePower) {
		this.capturePower = capturePower;
	}

	@Override
	public String getName() {

	}
}
