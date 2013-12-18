package fr.arpinum;

import java.util.List;

import com.google.common.collect.Lists;

public class EvolueurCellule {

	public EvolueurCellule(Cellule cellule) {
		this.voisines = Lists.newArrayList();
		this.cellule = cellule;
	}

	public EvolueurCellule avecVoisinesVivantes(Cellule... vivantes) {
		this.voisines.addAll(Lists.newArrayList(vivantes));
		return this;
	}

	public Cellule créeEvolution() {
		for (Cellule ignorée : voisines) {
			cellule = cellule.avecUneVoisineVivante();
		}
		return cellule.créeEvolution();
	}

	private Cellule cellule;
	private List<Cellule> voisines;
}
