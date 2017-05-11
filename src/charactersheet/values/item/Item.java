package charactersheet.values.item;

public class Item {

	public final String name;
	public final float weight;

	public Item(final String name, final float weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public float getWeight() {
		return weight;
	}

}
