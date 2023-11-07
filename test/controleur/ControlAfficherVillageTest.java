package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois gaulois = new Gaulois("Bonemine",3);
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlAfficherVillage() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		String[] villageois = {"Abraracourcix"};
		String[] romain = {"Un Romain"};
		String[] test = controlAfficherVillage.donnerNomsVillageois();
		for (int i = 0; i < test.length; i++) {
			assertEquals(test[i], villageois[i]);
			assertNotEquals(test[i],romain[i]);
		}
		village.ajouterHabitant(gaulois);
		String[] villageois2 = {"Abraracourcix","Bonemine"};
		test = controlAfficherVillage.donnerNomsVillageois();
		for (int i = 0; i < test.length; i++) {
			assertEquals(test[i], villageois2[i]);
		}
	}

	@Test
	void testDonnerNomVillage() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerNbEtals() {
		fail("Not yet implemented");
	}

}
