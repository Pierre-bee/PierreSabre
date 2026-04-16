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
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		int force = honneur*2;
		if (force < adversaire.getReputation()) {
			honneur --;
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(getNbSous());
			perdreArgent(getNbSous());
		}
		else {
			honneur++;
			parler("Je t'ai eu petit Yakuza !");
			gagnerArgent(adversaire.getNbSous());
			adversaire.perdre();
		}
	}
}
