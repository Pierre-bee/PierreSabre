package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int nbSous;

	public Humain(String nom, String boissonFavorite, int nbSous) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.nbSous = nbSous;
	}

	public String getNom() {
		return nom;
	}

	public int getNbSous() {
		return nbSous;
	}

	private void gagnerArgent(int gain) {
		nbSous += gain;
	}
	
	private void perdreArgent(int perte) {
		nbSous -= perte;
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m’appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}
	
	public void  acheter(String bien, int prix) {
		if(prix > nbSous) {
			parler("Je n'ai plus que " + nbSous + " sous en poche. je ne peux même pas m'offrir " + bien + " à  " + prix + " sous.");
		}
		else {
			parler("J'ai " + nbSous + " sous en poche. je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		}
	}
	
	private void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	
	
}
