package charactersheet.values;

import java.util.Arrays;

public enum Alignment {

	LAWFUL_GOOD,
	LAWFUL_NEUTRAL,
	LAWFUL_EVIL,
	NEUTRAL_GOOD,
	NEUTRAL,
	NEUTRAL_EVIL,
	CHAOTIC_GOOD,
	CHAOTIC_NEUTRAL,
	CHAOTIC_EVIL;

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer();
		Arrays.stream(name().split("_")).map(s -> s.charAt(0) + s.substring(1).toLowerCase()).forEach(s -> {
			sb.append(s);
			sb.append(' ');
		});
		sb.append('(');
		sb.append(name().replaceAll("^(.)[^_]+|_(.)[^_]+", "$1$2"));
		sb.append(')');
		return sb.toString();
	}

}
