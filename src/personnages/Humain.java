package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int nbSous;
	protected Humain[] memoire = new Humain[30];
	protected int nbConnaissance = 0;

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

	protected void gagnerArgent(int gain) {
		nbSous += gain;
	}

	protected void perdreArgent(int perte) {
		nbSous -= perte;
	}

	public void direBonjour() {
		parler("Bonjour ! Je m’appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}

	public void acheter(String bien, int prix) {
		if (prix > nbSous) {
			parler("Je n'ai plus que " + nbSous + " sous en poche. je ne peux même pas m'offrir " + bien + " à  " + prix
					+ " sous.");
		} else {
			parler("J'ai " + nbSous + " sous en poche. je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		}
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}

	private void memoriser(Humain humain) {
		if (nbConnaissance < memoire.length) {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
		}
		else {
			for(int i = 0; i < memoire.length-1;i++) {
				memoire[i] = memoire[i+1];
			}
			memoire[nbConnaissance-1] = humain;
		}
	}

	private void repondre(Humain humain) {
		this.direBonjour();
		this.memoriser(humain);
	}

	public void faireConnaissanceAvec(Humain autreHumain) {
		this.direBonjour();
		autreHumain.repondre(this);
		this.memoriser(autreHumain);
	}
	
	public void listerConnaissance() {
		String parole = "Je connais beaucoup de monde, dont : ";
		StringBuilder connaissances = new StringBuilder();
		for(int i = 0; i < nbConnaissance; i++) {
			connaissances.append(memoire[i].getNom());
			connaissances.append(", ");
		}
		connaissances.delete(connaissances.length()-2, connaissances.length());
		parole += connaissances.toString();
		this.parler(parole);
	}

}
