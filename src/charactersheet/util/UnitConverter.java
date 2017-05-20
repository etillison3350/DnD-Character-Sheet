package charactersheet.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UnitConverter {

	public static final Pattern HEIGHT_NUMBER = Pattern.compile("(\\d+\\.?\\d*|\\d*\\.?\\d+)\\s*((?:milli|centi|kilo)?met(?:er|re)s?|miles?|yards?|feet|foot|inch(?:es)?|mi\\.?|[kcm]?m|yd\\.?|ft\\.?|in\\.?|\"|\'|)");
	public static final Pattern TIME_NUMBER = Pattern.compile("(\\d+\\.?\\d*|\\d*\\.?\\d+)\\s*(years?|months?|weeks?|days?|hours?|y(?:rs?)?\\.?|mos?\\.?|wks?\\.?|d\\.?|h(?:rs?)?\\.?)");
	public static final Pattern WEIGHT_NUMBER = Pattern.compile("(\\d+\\.?\\d*|\\d*\\.?\\d+)\\s*((?:metric\\s)?ton(?:ne)?s?|(?:(US|imperial|short|long)\\s)?tons?|(?:milli|kilo)?grams?|stones?|pounds?|ounces?|[ms]?t\\.?|[mM]T\\.?|[mk]?g\\.?|lbs?\\.?|oz\\.?)");

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

	public static double toPounds(final String weight) {
		final Matcher m = UnitConverter.WEIGHT_NUMBER.matcher(weight);
		if (!m.find()) throw new IllegalArgumentException();
		double value = 0;
		do {
			value += Double.parseDouble(m.group(1)) * UnitConverter.poundsIn(m.group(2));
		} while (m.find());
		return value;
	}

	public static double poundsIn(final String unit) {
		if (unit.matches("(?:metric\\s)?ton(?:ne)?s?")) {
			return 2204.62;
		} else if (unit.matches("(?:imperial|long)\\stons?")) {
			return 2240;
		} else if (unit.matches("(?:(?:US|short)\\s)?tons?")) {
			return 2000;
		} else if (unit.matches("milligrams?")) {
			return 2.20146e-6;
		} else if (unit.matches("kilograms?")) {
			return 2.20462;
		} else if (unit.matches("grams?")) {
			return 0.00220462;
		} else if (unit.matches("stones?")) {
			return 14;
		} else if (unit.matches("pounds?")) {
			return 1;
		} else if (unit.matches("ounces?")) {
			return 1. / 16;
		} else if (unit.matches("[mM]?[tT]\\.?")) {
			return 2204.62;
		} else if (unit.matches("st\\.?")) {
			return 14;
		} else if (unit.matches("mg\\.?")) {
			return 2.20146e-6;
		} else if (unit.matches("kg\\.?")) {
			return 2.20462;
		} else if (unit.matches("g\\.?")) {
			return 0.00220462;
		} else if (unit.matches("lbs?\\.?")) {
			return 1;
		} else if (unit.matches("oz\\.?")) {
			return 1. / 16;
		} else {
			return 1;
		}
	}

}
