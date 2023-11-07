package frontiere;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			StringBuilder chaine = new StringBuilder();
			chaine.append("Je suis désolé " + nomVendeur
					+ " mais il faut être un habitant de notre village pour commencer ici.");
			System.out.println(chaine.toString());
		} else {
			StringBuilder chaine = new StringBuilder();
			chaine.append("Bonjour " + nomVendeur + " ,je vais regarder si je peux vous trouver un étal.");
			System.out.println(chaine.toString());
			if (!controlPrendreEtal.resteEtals()) {
				StringBuilder chaine2 = new StringBuilder();
				chaine2.append("Désolé " + nomVendeur + " ,je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.println(chaine2.toString());
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("C'est parfait, il me reste un étal pour vous !\nIl me faudrait quelques renseignements :\nQuel produit souhaitez-vous vendre ?");
		System.out.println(chaine.toString());
		String produit = scan.next();
		StringBuilder nb = new StringBuilder();
		nb.append("Combien souhaitez-vous en vendre ?");
		int nbProduit = Clavier.entrerEntier(nb.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			StringBuilder reponse = new StringBuilder();
			reponse.append("Le vendeur " + nomVendeur + " s'est install� � l'�tal n�" + (numeroEtal+1));
			System.out.println(reponse.toString());
		}
	}
}
