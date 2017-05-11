package charactersheet.values.item;

import charactersheet.values.Cost;
import charactersheet.values.Cost.Coin;

public class Gear extends Item implements Purchasable {

	public static final Gear ABACUS = new Gear("Abacus", new Cost(2, Coin.GOLD), 2, "");
	public static final Gear ACID = new Gear("Acid (vial)", new Cost(25, Coin.GOLD), 1, "");
	public static final Gear ALCHEMISTS_FIRE = new Gear("Alchemist’s fire (flask)", new Cost(50, Coin.GOLD), 1, "");
	public static final Gear ARROWS = new Gear("Arrows (20)", new Cost(1, Coin.GOLD), 1, "AMMUNITION");
	public static final Gear BLOWGUN_NEEDLES = new Gear("Blowgun needles (50)", new Cost(1, Coin.GOLD), 1, "AMMUNITION");
	public static final Gear CROSSBOW_BOLTS = new Gear("Crossbow bolts (20)", new Cost(1, Coin.GOLD), 1.5f, "AMMUNITION");
	public static final Gear SLING_BULLETS = new Gear("Sling bullets (20)", new Cost(4, Coin.COPPER), 1.5f, "AMMUNITION");
	public static final Gear ANTITOXIN = new Gear("Antitoxin (vial)", new Cost(50, Coin.GOLD), 0, "");
	public static final Gear CRYSTAL = new Gear("Crystal", new Cost(10, Coin.GOLD), 1, "ARCANE FOCUS");
	public static final Gear ORB = new Gear("Orb", new Cost(20, Coin.GOLD), 3, "ARCANE FOCUS");
	public static final Gear ROD = new Gear("Rod", new Cost(10, Coin.GOLD), 2, "ARCANE FOCUS");
	public static final Gear STAFF = new Gear("Staff", new Cost(5, Coin.GOLD), 4, "ARCANE FOCUS");
	public static final Gear WAND = new Gear("Wand", new Cost(10, Coin.GOLD), 1, "ARCANE FOCUS");
	public static final Gear BACKPACK = new Gear("Backpack", new Cost(2, Coin.GOLD), 5, "");
	public static final Gear BALL_BEARINGS = new Gear("Ball bearings (bag of 1,000)", new Cost(1, Coin.GOLD), 2, "");
	public static final Gear BARREL = new Gear("Barrel", new Cost(2, Coin.GOLD), 70, "");
	public static final Gear BASKET = new Gear("Basket", new Cost(4, Coin.SILVER), 2, "");
	public static final Gear BEDROLL = new Gear("Bedroll", new Cost(1, Coin.GOLD), 7, "");
	public static final Gear BELL = new Gear("Bell", new Cost(1, Coin.GOLD), 0, "");
	public static final Gear BLANKET = new Gear("Blanket", new Cost(5, Coin.SILVER), 3, "");
	public static final Gear BLOCK_AND_TACKLE = new Gear("Block and tackle", new Cost(1, Coin.GOLD), 5, "");
	public static final Gear BOOK = new Gear("Book", new Cost(25, Coin.GOLD), 5, "");
	public static final Gear GLASS_BOTTLE = new Gear("Bottle, glass", new Cost(2, Coin.GOLD), 2, "");
	public static final Gear BUCKET = new Gear("Bucket", new Cost(5, Coin.COPPER), 2, "");
	public static final Gear CALTROPS = new Gear("Caltrops (bag of 20)", new Cost(1, Coin.GOLD), 2, "");
	public static final Gear CANDLE = new Gear("Candle", new Cost(1, Coin.COPPER), 0, "");
	public static final Gear CROSSBOW_BOLT_CASE = new Gear("Case, crossbow bolt", new Cost(1, Coin.GOLD), 1, "");
	public static final Gear MAP_OR_SCROLL_CASE = new Gear("Case, map or scroll", new Cost(1, Coin.GOLD), 1, "");
	public static final Gear CHAIN = new Gear("Chain (10 feet)", new Cost(5, Coin.GOLD), 10, "");
	public static final Gear CHALK = new Gear("Chalk (1 piece)", new Cost(1, Coin.COPPER), 0, "");
	public static final Gear CHEST = new Gear("Chest", new Cost(5, Coin.GOLD), 25, "");
	public static final Gear CLIMBERS_KIT = new Gear("Climber's kit", new Cost(25, Coin.GOLD), 12, "");
	public static final Gear COMMON_CLOTHES = new Gear("Clothes, common", new Cost(5, Coin.SILVER), 3, "");
	public static final Gear COSTUME_CLOTHES = new Gear("Clothes, costume", new Cost(5, Coin.GOLD), 4, "");
	public static final Gear FINE_CLOTHES = new Gear("Clothes, fine", new Cost(15, Coin.GOLD), 6, "");
	public static final Gear TRAVELERS_CLOTHES = new Gear("Clothes, traveler’s", new Cost(2, Coin.GOLD), 4, "");
	public static final Gear COMPONENT_POUCH = new Gear("Component pouch", new Cost(25, Coin.GOLD), 2, "");
	public static final Gear CROWBAR = new Gear("Crowbar", new Cost(2, Coin.GOLD), 5, "");
	public static final Gear SPRIG_OF_MISTLETOE = new Gear("Sprig of mistletoe", new Cost(1, Coin.GOLD), 0, "DRUIDIC FOCUS");
	public static final Gear TOTEM = new Gear("Totem", new Cost(1, Coin.GOLD), 0, "DRUIDIC FOCUS");
	public static final Gear WOODEN_STAFF = new Gear("Wooden staff", new Cost(5, Coin.GOLD), 4, "DRUIDIC FOCUS");
	public static final Gear YEW_WAND = new Gear("Yew wand", new Cost(10, Coin.GOLD), 1, "DRUIDIC FOCUS");
	public static final Gear FISHING_TACKLE = new Gear("Fishing tackle", new Cost(1, Coin.GOLD), 4, "");
	public static final Gear FLASK_OR_TANKARD = new Gear("Flask or tankard", new Cost(2, Coin.COPPER), 1, "");
	public static final Gear GRAPPLING_HOOK = new Gear("Grappling hook", new Cost(2, Coin.GOLD), 4, "");
	public static final Gear HAMMER = new Gear("Hammer", new Cost(1, Coin.GOLD), 3, "");
	public static final Gear SLEDGE_HAMMER = new Gear("Hammer, sledge", new Cost(2, Coin.GOLD), 10, "");
	public static final Gear HEALERS_KIT = new Gear("Healer’s kit", new Cost(5, Coin.GOLD), 3, "");
	public static final Gear AMULET = new Gear("Amulet", new Cost(5, Coin.GOLD), 1, "HOLY SYMBOL");
	public static final Gear EMBLEM = new Gear("Emblem", new Cost(5, Coin.GOLD), 0, "HOLY SYMBOL");
	public static final Gear RELIQUARY = new Gear("Reliquary", new Cost(5, Coin.GOLD), 2, "HOLY SYMBOL");
	public static final Gear HOLY_WATER = new Gear("Holy water (flask)", new Cost(25, Coin.GOLD), 1, "");
	public static final Gear HOURGLASS = new Gear("Hourglass", new Cost(25, Coin.GOLD), 1, "");
	public static final Gear HUNTING_TRAP = new Gear("Hunting trap", new Cost(5, Coin.GOLD), 25, "");
	public static final Gear INK = new Gear("Ink (1 ounce bottle)", new Cost(10, Coin.GOLD), 0, "");
	public static final Gear INK_PEN = new Gear("Ink pen", new Cost(2, Coin.COPPER), 0, "");
	public static final Gear JUG_OR_PITCHER = new Gear("Jug or pitcher", new Cost(2, Coin.COPPER), 4, "");
	public static final Gear LADDER = new Gear("Ladder (10-foot)", new Cost(1, Coin.SILVER), 25, "");
	public static final Gear LAMP = new Gear("Lamp", new Cost(5, Coin.SILVER), 1, "");
	public static final Gear BULLSEYE_LANTERN = new Gear("Lantern, bullseye", new Cost(10, Coin.GOLD), 2, "");
	public static final Gear HOODED_LANTERN = new Gear("Lantern, hooded", new Cost(5, Coin.GOLD), 2, "");
	public static final Gear LOCK = new Gear("Lock", new Cost(10, Coin.GOLD), 1, "");
	public static final Gear MAGNIFYING_GLASS = new Gear("Magnifying glass", new Cost(100, Coin.GOLD), 0, "");
	public static final Gear MANACLES = new Gear("Manacles", new Cost(2, Coin.GOLD), 6, "");
	public static final Gear MESS_KIT = new Gear("Mess kit", new Cost(2, Coin.SILVER), 1, "");
	public static final Gear STEEL_MIRROR = new Gear("Mirror, steel", new Cost(5, Coin.GOLD), 1 / 2, "");
	public static final Gear OIL = new Gear("Oil (flask)", new Cost(1, Coin.SILVER), 1, "");
	public static final Gear PAPER = new Gear("Paper (one sheet)", new Cost(2, Coin.SILVER), 0, "");
	public static final Gear PARCHMENT = new Gear("Parchment (one sheet)", new Cost(1, Coin.SILVER), 0, "");
	public static final Gear PERFUME = new Gear("Perfume (vial)", new Cost(5, Coin.GOLD), 0, "");
	public static final Gear MINERS_PICK = new Gear("Pick, miner’s", new Cost(2, Coin.GOLD), 10, "");
	public static final Gear PITON = new Gear("Piton", new Cost(5, Coin.COPPER), 0.25f, "");
	public static final Gear BASIC_POISON = new Gear("Poison, basic (vial)", new Cost(100, Coin.GOLD), 0, "");
	public static final Gear POLE = new Gear("Pole (10-foot)", new Cost(5, Coin.COPPER), 7, "");
	public static final Gear IRON_POT = new Gear("Pot, iron", new Cost(2, Coin.GOLD), 10, "");
	public static final Gear POTION_OF_HEALING = new Gear("Potion of healing", new Cost(50, Coin.GOLD), 0.5f, "");
	public static final Gear POUCH = new Gear("Pouch", new Cost(5, Coin.SILVER), 1, "");
	public static final Gear QUIVER = new Gear("Quiver", new Cost(1, Coin.GOLD), 1, "");
	public static final Gear PORTABLE_RAM = new Gear("Ram, portable", new Cost(4, Coin.GOLD), 35, "");
	public static final Gear RATIONS = new Gear("Rations (1 day)", new Cost(5, Coin.SILVER), 2, "");
	public static final Gear ROBES = new Gear("Robes", new Cost(1, Coin.GOLD), 4, "");
	public static final Gear HEMPEN_ROPE = new Gear("Rope, hempen (50 feet)", new Cost(1, Coin.GOLD), 10, "");
	public static final Gear SILK_ROPE = new Gear("Rope, silk (50 feet)", new Cost(10, Coin.GOLD), 5, "");
	public static final Gear SACK = new Gear("Sack", new Cost(1, Coin.COPPER), 0.5f, "");
	public static final Gear MERCHANTS_SCALE = new Gear("Scale, merchant’s", new Cost(5, Coin.GOLD), 3, "");
	public static final Gear SEALING_WAX = new Gear("Sealing wax", new Cost(5, Coin.SILVER), 0, "");
	public static final Gear SHOVEL = new Gear("Shovel", new Cost(2, Coin.GOLD), 5, "");
	public static final Gear SIGNAL_WHISTLE = new Gear("Signal whistle", new Cost(5, Coin.COPPER), 0, "");
	public static final Gear SIGNET_RING = new Gear("Signet ring", new Cost(5, Coin.GOLD), 0, "");
	public static final Gear SOAP = new Gear("Soap", new Cost(2, Coin.COPPER), 0, "");
	public static final Gear SPELLBOOK = new Gear("Spellbook", new Cost(50, Coin.GOLD), 3, "");
	public static final Gear IRON_SPIKES = new Gear("Spikes, iron (10)", new Cost(1, Coin.GOLD), 5, "");
	public static final Gear SPYGLASS = new Gear("Spyglass 1,", new Cost(1000, Coin.GOLD), 1, "");
	public static final Gear TWO_PERSON_TENT = new Gear("Tent, two-person", new Cost(2, Coin.GOLD), 20, "");
	public static final Gear TINDERBOX = new Gear("Tinderbox", new Cost(5, Coin.SILVER), 1, "");
	public static final Gear TORCH = new Gear("Torch", new Cost(1, Coin.COPPER), 1, "");
	public static final Gear VIAL = new Gear("Vial", new Cost(1, Coin.GOLD), 0, "");
	public static final Gear WATERSKIN = new Gear("Waterskin", new Cost(2, Coin.SILVER), 5, "");
	public static final Gear WHETSTONE = new Gear("Whetstone", new Cost(1, Coin.COPPER), 1, "");

	public final Cost cost;
	public final String subsetOf;

	public Gear(final String name, final Cost cost, final float weight, final String subsetOf) {
		super(name, weight);
		this.cost = cost;
		this.subsetOf = subsetOf;
	}

	@Override
	public Cost getCost() {
		return cost;
	}
}
