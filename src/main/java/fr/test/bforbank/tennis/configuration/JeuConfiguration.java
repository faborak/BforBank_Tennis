package fr.test.bforbank.tennis.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JeuConfiguration {

	public static enum Score {
		ZERO("0"), QUINZE("15"), TRENTE("30"), QUARANTE("40"), QUARANTE_A("40-A");

		public String code;

		private Score(String code) {
			this.code = code;
		}
	}

	public static enum JoueurAyantMarque {
		A, B, UNEXPECTED;

		public static JoueurAyantMarque get(String value) {
			for (JoueurAyantMarque joueur : JoueurAyantMarque.class.getEnumConstants()) {
				if (joueur.toString() == value) {
					return joueur;
				}
			}
			return UNEXPECTED;
		}
	}
	
}
