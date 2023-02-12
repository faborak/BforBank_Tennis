package fr.test.bforbank.tennis;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.test.bforbank.tennis.implementation.JeuService;

public class JeuServiceTest {
	
	@Autowired
	private JeuService jeuService;

//    @Before
//    public void setUp() throws Exception {
//    	assertNotNull(jeuService);
//    }
//
//    @Test
//    public void testVictoireJoueur1() throws Exception {
//    	jeuService.executionDuScore("ABABAA");
//    }

}