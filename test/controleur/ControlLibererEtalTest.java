package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village = new Village("le village des irréductibles", 10, 5);
	private Chef abraracourcix = new Chef("Abraracourcix", 10, village);
	private Gaulois gaulois = new Gaulois("Bonemine",3);
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village.setChef(abraracourcix);
	}

	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal);
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		village.ajouterHabitant(gaulois);
		assertFalse(controlLibererEtal.isVendeur("Bonemine"));
		village.installerVendeur(gaulois, "fleurs", 10);
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
	}

	@Test
	void testLibererEtal() {
		fail("Not yet implemented");
	}

}
