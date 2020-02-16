package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTeam implements Team {
	protected List<Pokemon> pokemons = new ArrayList<Pokemon>();

	public int capacity = 6;

	private int sumPokemones() {
		int sum = 0;
//		for (Pokemon item : pokemons) {
//			try {
//				sum;
//			} catch (Exception e) {
//			}
//		}
		return sum;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	@Override
	public void addPokemon(Pokemon pokemon) {
//		int weight = Integer.parseInt(pokemon.getPeso());
//		if (spaceAvalaible() < weight) {
//			System.out.println("no se pudo añadir el elemento " + pokemon.getName());
//		} else {
		pokemons.add(pokemon);
//		}
	}

	public Pokemon setActivePokemon(int active) {
		Pokemon pokemon = new Pokemon();

		pokemon.setAttackPower(pokemons.get(active).getAttackPower());
		pokemon.setHP(pokemons.get(active).getHP());
		pokemon.setLevel(pokemons.get(active).getLevel());
		pokemon.setVidaMaxima(pokemons.get(active).getVidaMaxima());
		pokemon.setName(pokemons.get(active).getName());
//		pokemon.setPeso(pokemons.get(active).getPeso());
		pokemon.setStatus(pokemons.get(active).getStatus());
//		pokemon.setType(pokemons.get(active).getType());

		return pokemon;
	}

	@Override
	public int spaceAvalaible() {
		return capacity - sumPokemones();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public boolean isFull() {
		return capacity <= sumPokemones();
	}
	
	public void removeById(int b) {
		pokemons.remove(b);
	}


}
