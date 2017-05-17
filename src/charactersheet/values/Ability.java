package charactersheet.values;

public enum Ability {
	STRENGTH,
	DEXTERITY,
	CONSTITUTION,
	INTELLIGENCE,
	WISDOM,
	CHARISMA;

	@Override
	public String toString() {
		return name().charAt(0) + name().substring(1).toLowerCase();
	}

	public static int indexOf(final Ability a) {
		if (a == null) return -1;
		for (int b = 0; b < values().length; b++) {
			if (values()[b] == a) return b;
		}
		return -1;
	}
}
