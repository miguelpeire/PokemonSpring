package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("superball")
public class Superball extends AbstractPokeball {

	public Superball() {
		capturePower = 25;
		name = "superball";
	}
}
