package charactersheet.values;

public class Dice {

	public final int numDice, diceValue;

	public Dice(final int diceValue, final int numDice) {
		this.numDice = numDice;
		this.diceValue = diceValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diceValue;
		result = prime * result + numDice;
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final Dice other = (Dice) obj;
		if (diceValue != other.diceValue) return false;
		if (numDice != other.numDice) return false;
		return true;
	}

}
