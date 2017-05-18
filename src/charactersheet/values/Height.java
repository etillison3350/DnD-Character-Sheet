package charactersheet.values;

public class Height {

	public int inches;

	public Height(final int inches) {
		this.inches = inches;
	}

	public Height(final int feet, final int inches) {
		this(12 * feet + inches);
	}

	@Override
	public String toString() {
		return String.format("%d\' %d\"", inches / 12, inches % 12);
	}

}
