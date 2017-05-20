package charactersheet.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UnitConverter {

	public static final Pattern HEIGHT_NUMBER = Pattern.compile("(\\d+\\.?\\d*|\\d*\\.?\\d+)\\s*((?:milli|centi|kilo)?met(?:er|re)s?|miles?|yards?|feet|foot|inch(?:es)?|mi\\.?|[kcm]?m|yd\\.?|ft\\.?|in\\.?|\"|\'|)");
	public static final Pattern TIME_NUMBER = Pattern.compile("(\\d+\\.?\\d*|\\d*\\.?\\d+)\\s*(years?|months?|weeks?|days?|hours?|y(?:rs?)?\\.?|mos?\\.?|wks?\\.?|d\\.?|h(?:rs?)?\\.?)");
	public static final Pattern WEIGHT_NUMBER = Pattern.compile("(\\d+\\.?\\d*|\\d*\\.?\\d+)\\s*((?:(?:metric|imperial|US)\\s)?ton(?:ne)?s?|(?:milli|centi|kilo)?grams?|stones?|pounds?|ounces?|y(?:rs?)?\\.?|mos?\\.?|wks?\\.?|d\\.?|h(?:rs?)?\\.?)");

	private UnitConverter() {}

	public static double toInches(final String height) {
		final Matcher m = UnitConverter.HEIGHT_NUMBER.matcher(height);
		if (!m.find()) throw new IllegalArgumentException();
		double value = 0;
		do {
			value += Double.parseDouble(m.group(1)) * UnitConverter.inchesIn(m.group(2));
		} while (m.find());
		return value;
	}

	public static double inchesIn(final String unit) {
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

	public static double toYears(final String time) {
		final Matcher m = UnitConverter.TIME_NUMBER.matcher(time);
		if (!m.find()) throw new IllegalArgumentException();
		double value = 0;
		do {
			value += Double.parseDouble(m.group(1)) * UnitConverter.yearsIn(m.group(2));
		} while (m.find());
		return value;
	}

	public static double yearsIn(final String unit) {
		if (unit.matches("years?")) {
			return 1;
		} else if (unit.matches("months?")) {
			return 0.0833334;
		} else if (unit.matches("weeks?")) {
			return 0.0191781;
		} else if (unit.matches("days?")) {
			return 0.00273973;
		} else if (unit.matches("hours?")) {
			return 0.000114155;
		} else if (unit.matches("y(?:rs?)?\\.?")) {
			return 1;
		} else if (unit.matches("mos?\\.?")) {
			return 0.0833334;
		} else if (unit.matches("wks?\\.?")) {
			return 0.0191781;
		} else if (unit.matches("d\\.?")) {
			return 0.00273973;
		} else if (unit.matches("h(?:rs?)?\\.?")) {
			return 0.000114155;
		} else {
			return 1;
		}
	}

	public static double poundsIn(final String unit) {
		return 1; // TODO;
	}

}
