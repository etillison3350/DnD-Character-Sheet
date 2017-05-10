package charactersheet.values;

public class Cost {

	public final int copperPoints;

	public Cost(final int copper) {
		copperPoints = copper;
	}

	public Cost(final int coins, final Coin coin) {
		copperPoints = coins * coin.value;
	}

	public static enum Coin {
		COPPER(1),
		SILVER(10),
		ELECTRUM(50),
		GOLD(100),
		PLATINUM(1000);

		public final int value;

		private Coin(final int value) {
			this.value = value;
		}

	}

}
