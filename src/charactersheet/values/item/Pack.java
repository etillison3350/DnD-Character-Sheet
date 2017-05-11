package charactersheet.values.item;

public enum Pack {

	BURGLAR(16, new ItemStack(Gear.BACKPACK), new ItemStack(Gear.BALL_BEARINGS), new ItemStack(new Item("string (10 ft)", 0)), new ItemStack(Gear.BELL), new ItemStack(Gear.CANDLE, 5), new ItemStack(Gear.CROWBAR), new ItemStack(Gear.HAMMER), new ItemStack(Gear.PITON, 10), new ItemStack(Gear.HOODED_LANTERN), new ItemStack(Gear.OIL, 2), new ItemStack(Gear.RATIONS, 5), new ItemStack(Gear.TINDERBOX), new ItemStack(Gear.WATERSKIN), new ItemStack(Gear.HEMPEN_ROPE)),
	DIPLOMAT(39, new ItemStack(Gear.CHEST), new ItemStack(Gear.MAP_OR_SCROLL_CASE, 2), new ItemStack(Gear.FINE_CLOTHES), new ItemStack(Gear.INK), new ItemStack(Gear.INK_PEN), new ItemStack(Gear.LAMP), new ItemStack(Gear.OIL, 2), new ItemStack(Gear.PAPER, 5), new ItemStack(Gear.PERFUME), new ItemStack(Gear.SEALING_WAX), new ItemStack(Gear.SOAP)),
	DUNGEONEER(12, new ItemStack(Gear.BACKPACK), new ItemStack(Gear.CROWBAR), new ItemStack(Gear.HAMMER), new ItemStack(Gear.PITON, 10), new ItemStack(Gear.TORCH, 10), new ItemStack(Gear.TINDERBOX), new ItemStack(Gear.RATIONS, 10), new ItemStack(Gear.WATERSKIN), new ItemStack(Gear.HEMPEN_ROPE)),
	ENTERTAINER(40, new ItemStack(Gear.BACKPACK), new ItemStack(Gear.BEDROLL), new ItemStack(Gear.COSTUME_CLOTHES, 2), new ItemStack(Gear.CANDLE, 5), new ItemStack(Gear.RATIONS, 5), new ItemStack(Gear.WATERSKIN), new ItemStack(Tool.HERBALISM_KIT)),
	EXPLORER(10, new ItemStack(Gear.BACKPACK), new ItemStack(Gear.BEDROLL), new ItemStack(Gear.MESS_KIT), new ItemStack(Gear.TINDERBOX), new ItemStack(Gear.TORCH, 10), new ItemStack(Gear.RATIONS, 10), new ItemStack(Gear.WATERSKIN), new ItemStack(Gear.HEMPEN_ROPE)),
	PRIEST(19, new ItemStack(Gear.BACKPACK), new ItemStack(Gear.BLANKET), new ItemStack(Gear.CANDLE, 10), new ItemStack(Gear.TINDERBOX), new ItemStack(new Item("Alms box", 0)), new ItemStack(new Item("Incense (1 block)", 0), 2), new ItemStack(new Item("Censer", 0)), new ItemStack(new Item("Vestments", 0)), new ItemStack(Gear.RATIONS, 2), new ItemStack(Gear.WATERSKIN)),
	SCHOLAR(40, new ItemStack(Gear.BACKPACK), new ItemStack(new Item("Book of Lore", 0)), new ItemStack(Gear.INK), new ItemStack(Gear.INK_PEN), new ItemStack(Gear.PARCHMENT, 10), new ItemStack(new Item("Little bag of sand", 0)), new ItemStack(new Item("Small knife", 0)));

	public final int cost;
	public final ItemStack[] contents;

	private Pack(final int cost, final ItemStack... contents) {
		this.cost = cost;
		this.contents = contents;
	}

}
