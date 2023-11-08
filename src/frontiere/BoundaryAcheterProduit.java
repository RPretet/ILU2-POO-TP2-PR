package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		StringBuilder debut = new StringBuilder();
		if (!controlAcheterProduit.isAcheteurHabitant(nomAcheteur)) {
			debut.append("Je suis d�sol� mais il faut �tre un habitant de notre village pour acheter dans notre march�.");
		} else {
			debut.append("Quel produit voulez-vous acheter ?");
			System.out.println(debut.toString());
			String produit = scan.next();
			String[] nomVendeur = controlAcheterProduit.trouverVendeurs(produit);
			StringBuilder chaineVendeur = new StringBuilder();
			if (nomVendeur.length == 0) {
				chaineVendeur.append("D�sol�, personne ne vend ce produit au march�.");
				System.out.println(chaineVendeur.toString());
			} else {
				chaineVendeur.append("Chez quel commer�ant voulez-vous acheter des " + produit + " ?");
				for (int i = 0; i < nomVendeur.length; i++) {
					chaineVendeur.append("\n" + (i+1) + " - " + nomVendeur[i]);
				}
				int indexVendeur = Clavier.entrerEntier(chaineVendeur.toString()) - 1;
				StringBuilder vente = new StringBuilder();
				vente.append(nomAcheteur + " se d�place jusqu'à l'�tal du vendeur " + nomVendeur[indexVendeur]
						+ "\nBonjour " + nomAcheteur + "\nCombien de " + produit + " voulez-vous acheter ?");
				int nbProd = Clavier.entrerEntier(vente.toString());
				int achat = controlAcheterProduit.acheterProduitEtal(nbProd, nomVendeur[indexVendeur]);
				StringBuilder fin = new StringBuilder();
				if (achat == 0) {
					fin.append(nomAcheteur + " veut acheter " + nbProd + " " + produit
							+ ", malheureusement il n'y en a plus !");
				} else if (achat < nbProd) {
					fin.append(nomAcheteur + " veut acheter " + nbProd + " " + produit
							+ ", malheureusement " + nomVendeur[indexVendeur] + " n'en a plus que "
							+ achat + ". " + nomAcheteur + " ach�te tout le stock de " + nomVendeur[indexVendeur] + ".");
				} else {
					fin.append(nomAcheteur + " ach�te " + achat + " " + produit + " à " + nomVendeur[indexVendeur] + ".");
				}
				System.out.println(fin.toString());
			}
		}
	}
}
