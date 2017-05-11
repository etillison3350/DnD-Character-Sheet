package charactersheet.values;

import charactersheet.values.Cost.Coin;

public class Armor extends Item implements Purchasable {

	public static final Armor PADDED = new Armor("Padded", ArmorType.LIGHT, new Cost(5, Coin.GOLD), 11, Integer.MAX_VALUE, 0, true, 8);
	public static final Armor LEATHER = new Armor("Leather", ArmorType.LIGHT, new Cost(10, Coin.GOLD), 11, Integer.MAX_VALUE, 0, false, 10);
	public static final Armor STUDDED_LEATHER = new Armor("Studded leather", ArmorType.LIGHT, new Cost(45, Coin.GOLD), 12, Integer.MAX_VALUE, 0, false, 13);
	public static final Armor HIDE = new Armor("Hide", ArmorType.MEDIUM, new Cost(10, Coin.GOLD), 12, 2, 0, false, 12);
	public static final Armor CHAIN_SHIRT = new Armor("Chain shirt", ArmorType.MEDIUM, new Cost(50, Coin.GOLD), 13, 2, 0, false, 20);
	public static final Armor SCALE_MAIL = new Armor("Scale mail", ArmorType.MEDIUM, new Cost(50, Coin.GOLD), 14, 2, 0, true, 45);
	public static final Armor BREASTPLATE = new Armor("Breastplate", ArmorType.MEDIUM, new Cost(400, Coin.GOLD), 14, 2, 0, false, 20);
	public static final Armor HALF_PLATE = new Armor("Half plate", ArmorType.MEDIUM, new Cost(750, Coin.GOLD), 15, 2, 0, true, 40);
	public static final Armor RING_MAIL = new Armor("Ring mail", ArmorType.HEAVY, new Cost(30, Coin.GOLD), 14, 0, 0, true, 40);
	public static final Armor CHAIN_MAIL = new Armor("Chain mail", ArmorType.HEAVY, new Cost(75, Coin.GOLD), 16, 0, 13, true, 55);
	public static final Armor SPLINT = new Armor("Splint", ArmorType.HEAVY, new Cost(200, Coin.GOLD), 17, 0, 15, true, 60);
	public static final Armor PLATE = new Armor("Plate", ArmorType.HEAVY, new Cost(1500, Coin.GOLD), 18, 0, 15, true, 65);
	public static final Armor SHIELD = new Armor("Shield", ArmorType.SHIELD, new Cost(10, Coin.GOLD), 2, 0, 0, false, 6);

	public final ArmorType type;
	public final Cost cost;
	public final int armorClass;
	public final int maxAddDex;
	public final int minStr;
	public final boolean stealthDisadvantage;

	public Armor(final String name, final ArmorType type, final Cost cost, final int armorClass, final int maxAddDex, final int minStr, final boolean stealthDisadvantage, final float weight) {
		super(name, weight);
		this.type = type;
		this.cost = cost;
		this.armorClass = armorClass;
		this.maxAddDex = maxAddDex;
		this.minStr = minStr;
		this.stealthDisadvantage = stealthDisadvantage;
	}

	@Override
	public Cost getCost() {
		return cost;
	}

}
