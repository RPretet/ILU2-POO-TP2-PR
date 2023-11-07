package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		StringBuilder chaine = new StringBuilder();
		if (infosMarche.length == 0) {
			chaine.append("Le marché est vide, revenez plus tard.");
		} else {
			chaine.append(nomAcheteur + ", vous trouverez au marché :\n");
			String vendeur, quantite, produit;
			for (int i = 0; i < infosMarche.length; i++) {
				vendeur = infosMarche[i];
				i++;
				quantite = infosMarche[i];
				i++;
				produit = infosMarche[i];
				chaine.append("- " + vendeur + " qui vend " + quantite + " " + produit +"\n");
			}
		}
		System.out.println(chaine.toString());
	}
}
