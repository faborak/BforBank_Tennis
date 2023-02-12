package fr.test.bforbank.tennis.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fr.test.bforbank.tennis.exception.CustomException;
import fr.test.bforbank.tennis.implementation.JeuService;

@SpringBootTest
public class JeuServiceTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	private JeuService jeuService = new JeuService();

	@Before
	public void setUp() throws Exception {
		assertNotNull(jeuService);
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	public void victoireJoueurA() throws CustomException {
		jeuService.executionDuScore("ABABAA");
		assertEquals("Player A : 15 / Player B : 0\r\n"
				+ "Player A : 15 / Player B : 15\r\n"
				+ "Player A : 30 / Player B : 15\r\n"
				+ "Player A : 30 / Player B : 30\r\n"
				+ "Player A : 40 / Player B : 30\r\n"
				+ "Player A : Gagné / Player B : Perdu\r\n"
				+ "Player A wins the game\r\n"
				+ "", outContent.toString());
	}

	@Test
	public void victoirePuisEnvoiDUnAutreEvenement() throws CustomException {
		jeuService.executionDuScore("ABABAAA");
		assertEquals("Player A : 15 / Player B : 0\r\n"
				+ "Player A : 15 / Player B : 15\r\n"
				+ "Player A : 30 / Player B : 15\r\n"
				+ "Player A : 30 / Player B : 30\r\n"
				+ "Player A : 40 / Player B : 30\r\n"
				+ "Player A : Gagné / Player B : Perdu\r\n"
				+ "Player A wins the game\r\n"
				+ "", outContent.toString());
	}

	@Test
	public void victoireJoueurB() throws CustomException {
		jeuService.executionDuScore("BABABB");
		assertEquals("Player A : 0 / Player B : 15\r\n"
				+ "Player A : 15 / Player B : 15\r\n"
				+ "Player A : 15 / Player B : 30\r\n"
				+ "Player A : 30 / Player B : 30\r\n"
				+ "Player A : 30 / Player B : 40\r\n"
				+ "Player A : Perdu / Player B : Gagné\r\n"
				+ "Player B wins the game\r\n"
				+ "", outContent.toString());
	}

	@Test
	public void victoireJoueurBApresDeuce() throws CustomException {
		jeuService.executionDuScore("BABABABABABB");
		assertEquals("Player A : 0 / Player B : 15\r\n"
				+ "Player A : 15 / Player B : 15\r\n"
				+ "Player A : 15 / Player B : 30\r\n"
				+ "Player A : 30 / Player B : 30\r\n"
				+ "Player A : 30 / Player B : 40\r\n"
				+ "Player A : 40 / Player B : 40\r\n"
				+ "Player A : 40 / Player B : 40-A\r\n"
				+ "Player A : 40 / Player B : 40\r\n"
				+ "Player A : 40 / Player B : 40-A\r\n"
				+ "Player A : 40 / Player B : 40\r\n"
				+ "Player A : 40 / Player B : 40-A\r\n"
				+ "Player A : Perdu / Player B : Gagné\r\n"
				+ "Player B wins the game\r\n"
				+ "", outContent.toString());
	}

	@Test
	public void lettreIncorrecte() throws CustomException {
		assertThrows(CustomException.class, () -> jeuService.executionDuScore("ABCDEF"));
	}

}