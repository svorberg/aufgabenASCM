package aufgabeZwei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int getOptimalValue(float money, List<Flear> flears) {
		int res = 0;

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

		for (FlearExtended fE : listBuyable) {
			if (money >= fE.getPrice()) {
				res++;
				money = money - fE.getPrice();
			}
		}

		return res;
	}

}
