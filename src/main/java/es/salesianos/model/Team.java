package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Team")
public class Team {

	protected List<Pokemon> pokemons = new ArrayList<Pokemon>();
	protected List<Pokemon> pokemonsCaptured = new ArrayList<Pokemon>();
	
	public int capacity = 6;

	private int sumPokemones() {
		int sum = 0;
		for (Pokemon item : pokemons) {
			try {
				sum += 1;
			} catch (Exception e) {
			}
		}
		return sum;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
	
	public List<Pokemon> getPokemonsCaptured() {
		return pokemonsCaptured;
	}

	public void setPokemonsCaptured(List<Pokemon> pokemonsCaptured) {
		this.pokemonsCaptured = pokemonsCaptured;
	}
	
	public boolean isFull() {
		if (sumPokemones() == capacity)
			return true;
		else
			return false;
	}

	public void addPokemon(Pokemon pokemon) {
		if (isFull()) {
			System.out.println("Team is full");
		} else {
			
		pokemons.add(pokemon);
		}
	}
	
	public void addPokemonCaptured(Pokemon pokemon) {
		pokemonsCaptured.add(pokemon);
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
		pokemon.setRace(pokemons.get(active).getRace());
//		pokemon.setType(pokemons.get(active).getType());

		return pokemon;
	}

	public int spaceAvalaible() {
		return capacity - sumPokemones();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void removeById(int remove) {
		pokemons.remove(remove);
	}

	

}
