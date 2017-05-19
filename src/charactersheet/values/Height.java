package charactersheet.values;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Height {

	public static final Pattern NUMBER = Pattern.compile("(\\d+\\.?\\d*|\\d*\\.?\\d+)\\s*((?:milli|centi|kilo)?met(?:er|re)s?|miles?|yards?|feet|foot|inch(?:es)?|mi\\.?|[kcm]?m|yd\\.?|ft\\.?|in\\.?|\"|\'|)");

	public final int inches;

	public Height(final int inches) {
		this.inches = inches;
	}

	public Height(final int feet, final int inches) {
		this(12 * feet + inches);
	}

	public Height(final String string) {
		final Matcher m = NUMBER.matcher(string);
		if (!m.find()) throw new IllegalArgumentException();
		double value = 0;
		do {
			value += Double.parseDouble(m.group(1)) * conversionFactor(m.group(2));
		} while (m.find());
		inches = (int) Math.round(value);
	}

	private static double conversionFactor(final String unit) {
		if (unit.matches("millimet(?:er|re)s?")) {
			return 0.0393701;
		} else if (unit.matches("centimet(?:er|re)s?")) {
			return 0.393701;
		} else if (unit.matches("kilomet(?:er|re)s?")) {
			return 39370.1;
		} else if (unit.matches("met(?:er|re)s?")) {
			return 39.3701;
		} else if (unit.matches("miles?")) {
			return 63360;
		} else if (unit.matches("yards?")) {
			return 36;
		} else if (unit.equals("feet")) {
			return 12;
		} else if (unit.equals("foot")) {
			return 12;
		} else if (unit.matches("inch(?:es)?")) {
			return 1;
		} else if (unit.matches("mi\\.?")) {
			return 63360;
		} else if (unit.equals("km")) {
			return 39370.1;
		} else if (unit.equals("cm")) {
			return 0.393701;
		} else if (unit.equals("mm")) {
			return 0.0393701;
		} else if (unit.equals("m")) {
			return 39.3701;
		} else if (unit.matches("yd\\.?")) {
			return 36;
		} else if (unit.matches("ft\\.?")) {
			return 12;
		} else if (unit.matches("in\\.?")) {
			return 1;
		} else if (unit.equals("\"")) {
			return 1;
		} else if (unit.equals("\'")) {
			return 12;
		} else {
			return 1;
		}
	}

	@Override
	public String toString() {
		return String.format("%d\' %d\"", inches / 12, inches % 12);
	}

}
