package charactersheet.values.item;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import charactersheet.values.Cost;
import charactersheet.values.Cost.Coin;
import charactersheet.values.Proficientable;

public class Tool extends Item implements Purchasable, Proficientable {

	public static final Tool ALCHEMISTS_SUPPLIES = new Tool(ToolType.ARTISANS_TOOLS, "Alchemist's supplies", 8f, new Cost(50, Coin.GOLD));
	public static final Tool BREWERS_SUPPLIES = new Tool(ToolType.ARTISANS_TOOLS, "Brewer's supplies", 9f, new Cost(20, Coin.GOLD));
	public static final Tool CALLIGRAPHERS_SUPPLIES = new Tool(ToolType.ARTISANS_TOOLS, "Calligrapher's supplies", 5f, new Cost(10, Coin.GOLD));
	public static final Tool CARPENTERS_TOOLS = new Tool(ToolType.ARTISANS_TOOLS, "Carpenter's tools", 6f, new Cost(8, Coin.GOLD));
	public static final Tool CARTOGRAPHERS_TOOLS = new Tool(ToolType.ARTISANS_TOOLS, "Cartographer's tools", 6f, new Cost(15, Coin.GOLD));
	public static final Tool COBBLERS_TOOLS = new Tool(ToolType.ARTISANS_TOOLS, "Cobbler's tools", 5f, new Cost(5, Coin.GOLD));
	public static final Tool COOKS_UTENSILS = new Tool(ToolType.ARTISANS_TOOLS, "Cook's utensils", 8f, new Cost(1, Coin.GOLD));
	public static final Tool GLASSBLOWERS_TOOLS = new Tool(ToolType.ARTISANS_TOOLS, "Glassblower's tools", 5f, new Cost(30, Coin.GOLD));
	public static final Tool JEWELERS_TOOLS = new Tool(ToolType.ARTISANS_TOOLS, "Jeweler's tools", 2f, new Cost(25, Coin.GOLD));
	public static final Tool LEATHERWORKERS_TOOLS = new Tool(ToolType.ARTISANS_TOOLS, "Leatherworker's tools", 5f, new Cost(5, Coin.GOLD));
	public static final Tool MASONS_TOOLS = new Tool(ToolType.ARTISANS_TOOLS, "Mason's tools", 8f, new Cost(10, Coin.GOLD));
	public static final Tool PAINTERS_SUPPLIES = new Tool(ToolType.ARTISANS_TOOLS, "Painter's supplies", 5f, new Cost(10, Coin.GOLD));
	public static final Tool POTTERS_TOOLS = new Tool(ToolType.ARTISANS_TOOLS, "Potter's tools", 3f, new Cost(10, Coin.GOLD));
	public static final Tool SMITHS_TOOLS = new Tool(ToolType.ARTISANS_TOOLS, "Smith's tools", 8f, new Cost(20, Coin.GOLD));
	public static final Tool TINKERS_TOOLS = new Tool(ToolType.ARTISANS_TOOLS, "Tinker's tools", 10f, new Cost(50, Coin.GOLD));
	public static final Tool WEAVERS_TOOLS = new Tool(ToolType.ARTISANS_TOOLS, "Weaver's tools", 5f, new Cost(1, Coin.GOLD));
	public static final Tool WOODCARVERS_TOOLS = new Tool(ToolType.ARTISANS_TOOLS, "Woodcarver's tools", 5f, new Cost(1, Coin.GOLD));
	public static final Tool DISGUISE_KIT = new Tool("Disguise kit", 3f, new Cost(25, Coin.GOLD));
	public static final Tool FORGERY_KIT = new Tool("Forgery kit", 5f, new Cost(15, Coin.GOLD));
	public static final Tool DICE_SET = new Tool(ToolType.GAMING_SET, "Dice set", 0f, new Cost(1, Coin.SILVER));
	public static final Tool DRAGONCHESS_SET = new Tool(ToolType.GAMING_SET, "Dragonchess set", 0.5f, new Cost(1, Coin.GOLD));
	public static final Tool PLAYING_CARD_SET = new Tool(ToolType.GAMING_SET, "Playing card set", 0f, new Cost(5, Coin.SILVER));
	public static final Tool THREE_DRAGON_ANTE = new Tool(ToolType.GAMING_SET, "Three-Dragon Ante set", 0f, new Cost(1, Coin.GOLD));
	public static final Tool HERBALISM_KIT = new Tool("Herbalism kit", 3f, new Cost(5, Coin.GOLD));
	public static final Tool BAGPIPES = new Tool(ToolType.MUSICAL_INSTRUMENT, "Bagpipes", 6f, new Cost(30, Coin.GOLD));
	public static final Tool DRUM = new Tool(ToolType.MUSICAL_INSTRUMENT, "Drum", 3f, new Cost(6, Coin.GOLD));
	public static final Tool DULCIMER = new Tool(ToolType.MUSICAL_INSTRUMENT, "Dulcimer", 10f, new Cost(25, Coin.GOLD));
	public static final Tool FLUTE = new Tool(ToolType.MUSICAL_INSTRUMENT, "Flute", 1f, new Cost(2, Coin.GOLD));
	public static final Tool LUTE = new Tool(ToolType.MUSICAL_INSTRUMENT, "Lute", 2f, new Cost(35, Coin.GOLD));
	public static final Tool LYRE = new Tool(ToolType.MUSICAL_INSTRUMENT, "Lyre", 2f, new Cost(30, Coin.GOLD));
	public static final Tool HORN = new Tool(ToolType.MUSICAL_INSTRUMENT, "Horn", 2f, new Cost(3, Coin.GOLD));
	public static final Tool PAN_FLUTE = new Tool(ToolType.MUSICAL_INSTRUMENT, "Pan flute", 2f, new Cost(12, Coin.GOLD));
	public static final Tool SHAWM = new Tool(ToolType.MUSICAL_INSTRUMENT, "Shawm", 1f, new Cost(2, Coin.GOLD));
	public static final Tool VIOL = new Tool(ToolType.MUSICAL_INSTRUMENT, "Viol", 1f, new Cost(30, Coin.GOLD));
	public static final Tool NAVIGATORS_TOOLS = new Tool("Navigator's tools", 2f, new Cost(25, Coin.GOLD));
	public static final Tool POISONERS_KIT = new Tool("Poisoner's kit", 2f, new Cost(50, Coin.GOLD));
	public static final Tool THIEVES_TOOLS = new Tool("Thieves' tools", 1f, new Cost(25, Coin.GOLD));

	private static final List<Tool> values = Arrays.asList(ALCHEMISTS_SUPPLIES, BREWERS_SUPPLIES, CALLIGRAPHERS_SUPPLIES, CARPENTERS_TOOLS, CARTOGRAPHERS_TOOLS, COBBLERS_TOOLS, COOKS_UTENSILS, GLASSBLOWERS_TOOLS, JEWELERS_TOOLS, LEATHERWORKERS_TOOLS, MASONS_TOOLS, PAINTERS_SUPPLIES, POTTERS_TOOLS, SMITHS_TOOLS, TINKERS_TOOLS, WEAVERS_TOOLS, WOODCARVERS_TOOLS, DISGUISE_KIT, FORGERY_KIT, DICE_SET, DRAGONCHESS_SET, PLAYING_CARD_SET, THREE_DRAGON_ANTE, HERBALISM_KIT, BAGPIPES, DRUM, DULCIMER, FLUTE, LUTE, LYRE,
			HORN, PAN_FLUTE, SHAWM, VIOL, NAVIGATORS_TOOLS, POISONERS_KIT, THIEVES_TOOLS);

	public final ToolType type;
	public final Cost cost;

	public Tool(final String name, final float weight, final Cost cost) {
		this(null, name, weight, cost);
	}

	public Tool(final ToolType type, final String name, final float weight, final Cost cost) {
		super(name, weight);

		this.type = type;
		this.cost = cost;
	}

	@Override
	public Cost getCost() {
		return cost;
	}

	public Tool[] values() {
		return values.toArray(new Tool[values.size()]);
	}

	public Tool[] valuesMatching(final Predicate<Tool> predicate) {
		return values.stream().filter(predicate).toArray(Tool[]::new);
	}

	public static enum ToolType {
		ARTISANS_TOOLS("Artisan's tools"),
		GAMING_SET("Gaming set"),
		MUSICAL_INSTRUMENT("Musical instrument");

		public final String name;

		private ToolType(final String name) {
			this.name = name;
		}
	}

}
