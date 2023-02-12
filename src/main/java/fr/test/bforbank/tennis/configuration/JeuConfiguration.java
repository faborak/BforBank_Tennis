package fr.test.bforbank.tennis.configuration;

import org.springframework.context.annotation.Configuration;

import fr.test.bforbank.tennis.exception.CustomException;

@Configuration
public class JeuConfiguration {

	public static enum Score {
		ZERO("0"), QUINZE("15"), TRENTE("30"), QUARANTE("40"), QUARANTE_A("40-A"), GAGNE("Gagné");

		public String code;

		private Score(String code) {
			this.code = code;
		}

	}

	public static enum JoueurAyantMarque {
		A, B;

		public static JoueurAyantMarque get(char value) throws CustomException {
			for (JoueurAyantMarque joueur : JoueurAyantMarque.values()) {
				if (joueur.toString().equals( Character.toString(value))) {
					return joueur;
				}
			}
			throw new CustomException("Erreur de valeur du joueur ayant marqué : " + value);
		}
	}

}
