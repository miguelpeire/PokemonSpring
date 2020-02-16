package es.salesianos.model;

import org.springframework.stereotype.Component;

@Component
public interface Team {

	public void addPokemon(Pokemon pokemon);

	public boolean isFull();

	public int spaceAvalaible();

	public Pokemon setActivePokemon(int active);

	public void removeById(int remove);

}
