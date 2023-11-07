package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] trouverVendeurs(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		String[] nomVendeurs = new String[vendeurs.length];
		for (int i = 0; i < vendeurs.length; i++) {
			nomVendeurs[i] = vendeurs[i].getNom();
		}
		return nomVendeurs;
	}
	
	public int acheterProduitEtal(int nbProd, String vendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
		int achat = etal.acheterProduit(nbProd);
		return achat;
	}
	
	public boolean isAcheteurHabitant(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
}
