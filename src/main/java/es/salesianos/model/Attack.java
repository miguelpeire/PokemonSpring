package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

public class Attack {
	private String name;
	private List<Pokemon> pokemons = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}


}
