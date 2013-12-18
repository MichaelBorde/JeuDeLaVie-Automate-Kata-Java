package fr.arpinum;

public enum Etat {
	VIVANTE {
		@Override
		public Cellule créeEvolution() {
			return Cellule.morte();
		}

		@Override
		public Cellule avecUneVoisineVivante() {
			return new Cellule(PROCHE_DE_LA_POPULATION_MINIMALE);
		}
	},
	PROCHE_DE_LA_POPULATION_MINIMALE {
		@Override
		public Cellule créeEvolution() {
			return Cellule.morte();
		}

		@Override
		public Cellule avecUneVoisineVivante() {
			return new Cellule(POPULATION_MINIMALE);
		}
	},
	POPULATION_MINIMALE {
		@Override
		public Cellule créeEvolution() {
			return Cellule.vivante();
		}

		@Override
		public Cellule avecUneVoisineVivante() {
			return new Cellule(POPULATION_MAXIMALE);
		}
	},
	POPULATION_MAXIMALE {
		@Override
		public Cellule créeEvolution() {
			return Cellule.vivante();
		}

		@Override
		public Cellule avecUneVoisineVivante() {
			return Cellule.morte();
		}
	},
	MORTE {
		@Override
		public Cellule créeEvolution() {
			return Cellule.morte();
		}

		@Override
		public Cellule avecUneVoisineVivante() {
			return Cellule.vivante();
		}
	};

	public abstract Cellule créeEvolution();

	public abstract Cellule avecUneVoisineVivante();
}
