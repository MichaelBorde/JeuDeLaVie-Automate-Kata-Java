package fr.arpinum;

public class Cellule {

	public static Cellule morte() {
		return MORTE;
	}

	public static Cellule vivante() {
		return VIVANTE;
	}

	Cellule(Etat état) {
		this.état = état;
	}

	Cellule créeEvolution() {
		return état.créeEvolution();
	}

	Cellule avecUneVoisineVivante() {
		return état.avecUneVoisineVivante();
	}

	public static final Cellule MORTE = new Cellule(Etat.MORTE);
	public static final Cellule VIVANTE = new Cellule(Etat.VIVANTE);

	private final Etat état;
}
