package charactersheet.values;

public class Feature {

	public final String name, description;
	public final IntegerSource[] effects;

	public Feature(final String name, final String description, final IntegerSource[] effects) {
		this.name = name;
		this.description = description;
		this.effects = effects;
	}

}
