package es.salesianos.model;

import org.springframework.stereotype.Component;

@Component
//@Profile("level1")
public class TeamLevel1 extends AbstractTeam {

	public TeamLevel1() {
		capacity = 20;
	}

}
