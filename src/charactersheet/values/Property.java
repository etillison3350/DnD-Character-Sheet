package charactersheet.values;

public class Property {

	public final PropertyType property;
	public final int range1, range2;
	public final Dice hitDice;

	public Property(final PropertyType property) {
		this(property, -1, -1, null);
	}

	public Property(final PropertyType property, final Dice hitDice) {
		this(property, -1, -1, hitDice);
	}

	public Property(final PropertyType property, final int range1, final int range2) {
		this(property, range1, range2, null);
	}

	public Property(final PropertyType property, final int range1, final int range2, final Dice hitDice) {
		this.property = property;
		this.range1 = range1;
		this.range2 = range2;
		this.hitDice = hitDice;
	}

	public static enum PropertyType {
		AMMUNITION,
		FINESSE,
		HEAVY,
		LIGHT,
		LOADING,
		RANGE,
		REACH,
		SPECIAL,
		THROWN,
		TWO_HANDED,
		VERSATILE;
	}

}
