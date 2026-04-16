package personnages;

public class Ronin extends Humain {
	private int honneur = 1;
	
	public Ronin(String nom, String boissonFavorite, int nbSous) {
		super(nom, boissonFavorite, nbSous);
	}
	
	public void donner(Commercant beneficiaire) {
		int sousDonnes = getNbSous()/10;
		parler("Tiens " + beneficiaire.getNom() + ", prends ces "+ sousDonnes + " sous.");
		beneficiaire.recevoir(sousDonnes);
		perdreArgent(sousDonnes);
	}
}
