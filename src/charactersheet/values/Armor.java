package charactersheet.values;

import charactersheet.values.Cost.Coin;

public enum Armor {

	PADDED(ArmorType.LIGHT, new Cost(5, Coin.GOLD), 11, Integer.MAX_VALUE, 0, true, 8),
	LEATHER(ArmorType.LIGHT, new Cost(10, Coin.GOLD), 11, Integer.MAX_VALUE, 0, false, 10),
	STUDDED_LEATHER(ArmorType.LIGHT, new Cost(45, Coin.GOLD), 12, Integer.MAX_VALUE, 0, false, 13),
	HIDE(ArmorType.MEDIUM, new Cost(10, Coin.GOLD), 12, 2, 0, false, 12),
	CHAIN_SHIRT(ArmorType.MEDIUM, new Cost(50, Coin.GOLD), 13, 2, 0, false, 20),
	SCALE_MAIL(ArmorType.MEDIUM, new Cost(50, Coin.GOLD), 14, 2, 0, true, 45),
	BREASTPLATE(ArmorType.MEDIUM, new Cost(400, Coin.GOLD), 14, 2, 0, false, 20),
	HALF_PLATE(ArmorType.MEDIUM, new Cost(750, Coin.GOLD), 15, 2, 0, true, 40),
	RING_MAIL(ArmorType.HEAVY, new Cost(30, Coin.GOLD), 14, 0, 0, true, 40),
	CHAIN_MAIL(ArmorType.HEAVY, new Cost(75, Coin.GOLD), 16, 0, 13, true, 55),
	SPLINT(ArmorType.HEAVY, new Cost(200, Coin.GOLD), 17, 0, 15, true, 60),
	PLATE(ArmorType.HEAVY, new Cost(1500, Coin.GOLD), 18, 0, 15, true, 65),
	SHIELD(ArmorType.SHIELD, new Cost(10, Coin.GOLD), 2, 0, 0, false, 6);

	public final ArmorType type;
	public final Cost cost;
	public final int armorClass;
	public final int maxAddDex;
	public final int minStr;
	public final boolean stealthDisadvantage;
	public final float weight;

	private Armor(final ArmorType type, final Cost cost, final int armorClass, final int maxAddDex, final int minStr, final boolean stealthDisadvantage, final float weight) {
		this.type = type;
		this.cost = cost;
		this.armorClass = armorClass;
		this.maxAddDex = maxAddDex;
		this.minStr = minStr;
		this.stealthDisadvantage = stealthDisadvantage;
		this.weight = weight;
	}

}
