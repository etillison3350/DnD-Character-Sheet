package charactersheet.util;

public class Height {

	public final double inches;

	public Height(final double inches) {
		this.inches = inches;
	}

	public Height(final double feet, final double inches) {
		this(12 * feet + inches);
	}

	public Height(final String string) {
		this(UnitConverter.toInches(string));
	}

	@Override
	public String toString() {
		return String.format("%d\' %d\"", (int) Math.floor(inches / 12), (int) Math.round(inches % 12));
	}

}
