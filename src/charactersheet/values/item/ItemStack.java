package charactersheet.values.item;

public class ItemStack {

	public final Item item;
	public final int count;

	public ItemStack(final Item item) {
		this(item, 1);
	}

	public ItemStack(final Item item, final int count) {
		this.item = item;
		this.count = count;
	}

}
