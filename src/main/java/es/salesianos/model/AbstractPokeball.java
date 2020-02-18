package es.salesianos.model;

//import java.util.Random;

public class AbstractPokeball implements Pokeballs {

	public int capturePower;

	@Override
	public int getCapture() {
		return capturePower;
	}

	public void setCapturePower(int capturePower) {
		this.capturePower = capturePower;
	}

//	@Override
//	public void capturePokemon(Pokemon pokemon, AbstractTeam team) {
//		Random percentage = new Random();
//		int chance = percentage.nextInt(99)+1;
//		if(chance <= capturePower) {	
//			team.addPokemon(pokemon);
//	}
//}
}
