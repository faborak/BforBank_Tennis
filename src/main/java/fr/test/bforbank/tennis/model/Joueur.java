package fr.test.bforbank.tennis.model;

import org.springframework.stereotype.Component;

import fr.test.bforbank.tennis.configuration.JeuConfiguration.Score;
import lombok.Getter;

@Component
public class Joueur {

	@Getter
	private Score score = Score.ZERO;

	public void incrementScore(Joueur autreJoueur) {

		switch (this.score) {
		case ZERO:
			this.score = Score.QUINZE;
			break;
		case QUINZE:
			this.score = Score.TRENTE;
			break;
		case TRENTE:
			this.score = Score.QUARANTE;
			break;
		case QUARANTE:
			gererDeuce(autreJoueur);
			break;
		case QUARANTE_A:
			this.score = Score.GAGNE;
			autreJoueur.score = Score.PERDU;
			break;
		default:
			System.out.println("Erreur dans le score du joueur " + this.score);
			break;
		}
	}

	private void gererDeuce(Joueur autreJoueur) {
		if (Score.QUARANTE.equals(autreJoueur.score)) {
			this.score = Score.QUARANTE_A;
		} else if (Score.QUARANTE_A.equals(autreJoueur.score)) {
			autreJoueur.score = Score.QUARANTE;
		} else {
			this.score = Score.GAGNE;
			autreJoueur.score = Score.PERDU;
		}
	}

}
