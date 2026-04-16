package personnages;

public class Samourai extends Ronin {
	private String seigneur;
	
	public Samourai(String nom, String seigneur, String boissonFavorite, int nbSous) {
		super(nom, boissonFavorite, nbSous);
		this.seigneur = seigneur;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		this.parler("Je suis fier de servir le seigneur " + seigneur);
	}
	
	public void boire(String boisson) {
		parler("Quest-ce qque je vais choisir comme boisson ? Tiens je vais prendre " + boisson);
	}
}
