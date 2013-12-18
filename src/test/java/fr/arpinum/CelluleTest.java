package fr.arpinum;

import static fr.arpinum.cocoritest.Affirmations.*;

import org.junit.Test;

public class CelluleTest {

	@Test
	public void uneCellulePeutEtreMorte() {
		Cellule celluleMorte = Cellule.morte();

		alors().la(celluleMorte).nEstPasNulle();
		alors().la(celluleMorte).est(Cellule.morte());
	}

	@Test
	public void uneCellulePeutEtreVivante() {
		Cellule celluleVivante = Cellule.vivante();

		alors().la(celluleVivante).nEstPasNulle();
		alors().la(celluleVivante).est(Cellule.vivante());
		alors().la(celluleVivante).nEstPas(Cellule.morte());
	}

	@Test
	public void uneCelluleVivanteSansVoisineVivanteMeurt() {
		Cellule celluleVivante = Cellule.vivante();

		Cellule évolution = new EvolueurCellule(celluleVivante).créeEvolution();

		alors().cette(évolution).est(Cellule.morte());
	}

	@Test
	public void uneCelluleVivanteAvecDeuxVoisinesVivantesResteEnVie() {
		Cellule celluleVivante = Cellule.vivante();

		Cellule évolution = new EvolueurCellule(celluleVivante).avecVoisinesVivantes(Cellule.vivante(),
				Cellule.vivante()).créeEvolution();

		alors().cette(évolution).est(Cellule.vivante());
	}

	@Test
	public void uneCelluleVivanteAvecTroisVoisinesVivantesResteEnVie() {
		Cellule celluleVivante = Cellule.vivante();

		Cellule évolution = new EvolueurCellule(celluleVivante).avecVoisinesVivantes(Cellule.vivante(),
				Cellule.vivante(), Cellule.vivante()).créeEvolution();

		alors().cette(évolution).est(Cellule.vivante());
	}

	@Test
	public void uneCelluleMorteAvecDeuxVoisinesVivantesResteMorte() {
		Cellule celluleMorte = Cellule.morte();

		Cellule évolution = new EvolueurCellule(celluleMorte).avecVoisinesVivantes(Cellule.vivante(),
				Cellule.vivante()).créeEvolution();

		alors().cette(évolution).est(Cellule.morte());
	}

	@Test
	public void uneCelluleMorteAvecTroisVoisinesVivantesRenait() {
		Cellule celluleMorte = Cellule.morte();

		Cellule évolution = new EvolueurCellule(celluleMorte).avecVoisinesVivantes(Cellule.vivante(),
				Cellule.vivante(), Cellule.vivante()).créeEvolution();

		alors().cette(évolution).est(Cellule.vivante());
	}
}
