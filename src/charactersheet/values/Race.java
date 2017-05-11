package charactersheet.values;

public class Race {

	public static final Race DWARF = new Race("Dwarf", new Race[] {new Race("Hill Dwarf"), new Race("Mountain Dwarf")});

	public final String name;
	public final Race[] subraces;
	public final Feature[] features;

	public Race(final String name, final Feature... features) {
		this(name, new Race[0], features);
	}

	public Race(final String name, final Race[] subraces, final Feature... features) {
		this.name = name;
		this.subraces = subraces;
		this.features = features;
	}

}
