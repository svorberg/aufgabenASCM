package aufgabeDrei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Gibt die anzahl der besten flöhe zurück, welche mit dem Geld zu kaufen
	 * sind
	 * 
	 * @param money
	 * @param flears
	 * @return int
	 */
	public static int getOptimalValue(float money, List<Flear> flears) {
		int res = 0;

		// Da es nicht Aufbage war die Klasse Flear zu verändern, habe ich mir
		// erlaubt einen "erweiterten Floh" zu konstruieren.
		//
		// Mir war wichtig das Verhältnis zwischen rating und price zu ermitteln
		// um die Flöhe entsprechend sortieren zu können
		class FlearExtended extends Flear {
			Double ratingForMoney = (double) 0;

			public FlearExtended(Flear f) {
				super(f.getName(), f.getPrice(), f.getRating());
				setRatingForMoney();
			}

			private void setRatingForMoney() {
				this.ratingForMoney = (double) (this.getRating() / this.getPrice());
			}

			public Double getRatingForMoney() {
				return this.ratingForMoney;
			}
		}

		ArrayList<FlearExtended> listBuyable = new ArrayList<>();

		// Aus allen Flears einen FlearExtended machen, die nicht an sich schon
		// zu teuer sind (soll die zu sortierende Liste möglichst klein halten
		for (Flear f : flears) {
			if (f.getPrice() <= money) {
				listBuyable.add(new FlearExtended(f));
			}
		}

		listBuyable.sort(new Comparator<FlearExtended>() {
			@Override
			public int compare(FlearExtended o1, FlearExtended o2) {
				return o1.getRatingForMoney().compareTo(o2.getRatingForMoney()) * -1;
			}
		});

		// Solange Geld da ist, den nächstbesten Floh kaufen
		for (FlearExtended fE : listBuyable) {
			if (money >= fE.getPrice()) {
				res++;
				money = money - fE.getPrice();
			}
		}

		return res;
	}

}
