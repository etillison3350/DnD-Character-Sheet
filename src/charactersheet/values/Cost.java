package charactersheet.values;

public class Cost {

	public final int copperPoints;

	public Cost(final int copper) {
		copperPoints = copper;
	}

	public Cost(final int coins, final Coin coin) {
		copperPoints = coins * coin.value;
	}

	@Override
	public int hashCode() {
		return 31 + copperPoints;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final Cost other = (Cost) obj;
		if (copperPoints != other.copperPoints) return false;
		return true;
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
