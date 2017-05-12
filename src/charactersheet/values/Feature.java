package charactersheet.values;

public class Feature {

	public final String name;
	public final boolean displayed;
	public final Addition[] effects;

	public Feature(final String name, final Addition... effects) {
		this(name, true, effects);
	}

	public Feature(final String name, final boolean displayed, final Addition... effects) {
		this.name = name;
		this.displayed = displayed;
		this.effects = effects;
	}

}
