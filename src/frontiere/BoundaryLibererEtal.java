package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			StringBuilder non = new StringBuilder();
			non.append("Mais vous n'�tes pas inscrit sur notre march� aujourd'hui !");
			System.out.println(non.toString());
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if (Boolean.valueOf(donneesEtal[0])) {
				StringBuilder chaine = new StringBuilder();
				chaine.append("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2]);
			}
		}
	}

}
