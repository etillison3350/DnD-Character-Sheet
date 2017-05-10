package charactersheet.values;

import charactersheet.values.Cost.Coin;
import charactersheet.values.Property.PropertyType;

public enum Weapon {

	CLUB(false, false, new Cost(1, Coin.SILVER), new Dice(4, 1), DamageType.BLUDGEONING, 2, new Property(PropertyType.LIGHT)),
	DAGGER(false, false, new Cost(2, Coin.GOLD), new Dice(4, 1), DamageType.PIERCING, 1, new Property(PropertyType.FINESSE), new Property(PropertyType.LIGHT), new Property(PropertyType.THROWN, 20, 60)),
	GREATCLUB(false, false, new Cost(2, Coin.SILVER), new Dice(8, 1), DamageType.BLUDGEONING, 10, new Property(PropertyType.TWO_HANDED)),
	HANDAXE(false, false, new Cost(5, Coin.GOLD), new Dice(6, 1), DamageType.SLASHING, 2, new Property(PropertyType.LIGHT), new Property(PropertyType.THROWN, 20, 60)),
	JAVELIN(false, false, new Cost(5, Coin.SILVER), new Dice(6, 1), DamageType.PIERCING, 2, new Property(PropertyType.THROWN, 30, 120)),
	LIGHT_HAMMER(false, false, new Cost(2, Coin.GOLD), new Dice(4, 1), DamageType.BLUDGEONING, 2, new Property(PropertyType.LIGHT), new Property(PropertyType.THROWN, 20, 60)),
	MACE(false, false, new Cost(5, Coin.GOLD), new Dice(6, 1), DamageType.BLUDGEONING, 4),
	QUARTERSTAFF(false, false, new Cost(2, Coin.SILVER), new Dice(6, 1), DamageType.BLUDGEONING, 4, new Property(PropertyType.VERSATILE, new Dice(8, 1))),
	SICKLE(false, false, new Cost(1, Coin.GOLD), new Dice(4, 1), DamageType.SLASHING, 2, new Property(PropertyType.LIGHT)),
	SPEAR(false, false, new Cost(1, Coin.GOLD), new Dice(6, 1), DamageType.PIERCING, 3, new Property(PropertyType.THROWN, 20, 60), new Property(PropertyType.VERSATILE, new Dice(8, 1))),
	LIGHT_CROSSBOW(false, true, new Cost(25, Coin.GOLD), new Dice(8, 1), DamageType.PIERCING, 5, new Property(PropertyType.AMMUNITION, 80, 320), new Property(PropertyType.LOADING), new Property(PropertyType.TWO_HANDED)),
	DART(false, true, new Cost(5, Coin.COPPER), new Dice(4, 1), DamageType.PIERCING, 0.25f, new Property(PropertyType.FINESSE), new Property(PropertyType.THROWN, 20, 60)),
	SHORTBOW(false, true, new Cost(25, Coin.GOLD), new Dice(6, 1), DamageType.PIERCING, 2, new Property(PropertyType.AMMUNITION, 80, 320), new Property(PropertyType.TWO_HANDED)),
	SLING(false, true, new Cost(1, Coin.SILVER), new Dice(4, 1), DamageType.BLUDGEONING, 0, new Property(PropertyType.AMMUNITION, 30, 120)),
	BATTLEAXE(true, false, new Cost(10, Coin.GOLD), new Dice(8, 1), DamageType.SLASHING, 4, new Property(PropertyType.VERSATILE, new Dice(10, 1))),
	FLAIL(true, false, new Cost(10, Coin.GOLD), new Dice(8, 1), DamageType.BLUDGEONING, 2),
	GLAIVE(true, false, new Cost(20, Coin.GOLD), new Dice(10, 1), DamageType.SLASHING, 6, new Property(PropertyType.HEAVY), new Property(PropertyType.REACH), new Property(PropertyType.TWO_HANDED)),
	GREATAXE(true, false, new Cost(30, Coin.GOLD), new Dice(12, 1), DamageType.SLASHING, 7, new Property(PropertyType.HEAVY), new Property(PropertyType.TWO_HANDED)),
	GREATSWORD(true, false, new Cost(50, Coin.GOLD), new Dice(6, 2), DamageType.SLASHING, 6, new Property(PropertyType.HEAVY), new Property(PropertyType.TWO_HANDED)),
	HALBERD(true, false, new Cost(20, Coin.GOLD), new Dice(10, 1), DamageType.SLASHING, 6, new Property(PropertyType.HEAVY), new Property(PropertyType.REACH), new Property(PropertyType.TWO_HANDED)),
	LANCE(true, false, new Cost(10, Coin.GOLD), new Dice(12, 1), DamageType.PIERCING, 6, new Property(PropertyType.REACH), new Property(PropertyType.SPECIAL)),
	LONGSWORD(true, false, new Cost(15, Coin.GOLD), new Dice(8, 1), DamageType.SLASHING, 3, new Property(PropertyType.VERSATILE, new Dice(10, 1))),
	MAUL(true, false, new Cost(10, Coin.GOLD), new Dice(6, 2), DamageType.BLUDGEONING, 10, new Property(PropertyType.HEAVY), new Property(PropertyType.TWO_HANDED)),
	MORNINGSTAR(true, false, new Cost(15, Coin.GOLD), new Dice(8, 1), DamageType.PIERCING, 4),
	PIKE(true, false, new Cost(5, Coin.GOLD), new Dice(10, 1), DamageType.PIERCING, 18, new Property(PropertyType.HEAVY), new Property(PropertyType.REACH), new Property(PropertyType.TWO_HANDED)),
	RAPIER(true, false, new Cost(25, Coin.GOLD), new Dice(8, 1), DamageType.PIERCING, 2, new Property(PropertyType.FINESSE)),
	SCIMITAR(true, false, new Cost(25, Coin.GOLD), new Dice(6, 1), DamageType.SLASHING, 3, new Property(PropertyType.FINESSE), new Property(PropertyType.LIGHT)),
	SHORTSWORD(true, false, new Cost(10, Coin.GOLD), new Dice(6, 1), DamageType.PIERCING, 2, new Property(PropertyType.FINESSE), new Property(PropertyType.LIGHT)),
	TRIDENT(true, false, new Cost(5, Coin.GOLD), new Dice(6, 1), DamageType.PIERCING, 4, new Property(PropertyType.THROWN, 20, 60), new Property(PropertyType.VERSATILE, new Dice(8, 1))),
	WAR_PICK(true, false, new Cost(5, Coin.GOLD), new Dice(8, 1), DamageType.PIERCING, 2),
	WARHAMMER(true, false, new Cost(15, Coin.GOLD), new Dice(8, 1), DamageType.BLUDGEONING, 2, new Property(PropertyType.VERSATILE, new Dice(10, 1))),
	WHIP(true, false, new Cost(2, Coin.GOLD), new Dice(4, 1), DamageType.SLASHING, 3, new Property(PropertyType.FINESSE), new Property(PropertyType.REACH)),
	BLOWGUN(true, true, new Cost(10, Coin.GOLD), new Dice(1, 1), DamageType.PIERCING, 1, new Property(PropertyType.AMMUNITION, 25, 100), new Property(PropertyType.LOADING)),
	HAND_CROSSBOW(true, true, new Cost(75, Coin.GOLD), new Dice(6, 1), DamageType.PIERCING, 3, new Property(PropertyType.AMMUNITION, 30, 120), new Property(PropertyType.LIGHT), new Property(PropertyType.LOADING)),
	HEAVY_CROSSBOW(true, true, new Cost(50, Coin.GOLD), new Dice(10, 1), DamageType.PIERCING, 18, new Property(PropertyType.AMMUNITION, 100, 400), new Property(PropertyType.HEAVY), new Property(PropertyType.LOADING), new Property(PropertyType.TWO_HANDED)),
	LONGBOW(true, true, new Cost(50, Coin.GOLD), new Dice(8, 1), DamageType.PIERCING, 2, new Property(PropertyType.AMMUNITION, 150, 600), new Property(PropertyType.HEAVY), new Property(PropertyType.TWO_HANDED)),
	NET(true, true, new Cost(1, Coin.GOLD), new Dice(0, 0), null, 3, new Property(PropertyType.SPECIAL), new Property(PropertyType.THROWN, 5, 15));

	public final boolean martial;
	public final boolean ranged;
	public final Cost cost;
	public final Dice damageDice;
	public final DamageType damageType;
	public final float weight;
	public final Property[] property;

	private Weapon(final boolean martial, final boolean ranged, final Cost cost, final Dice damageDice, final DamageType damageType, final float weight, final Property... property) {
		this.martial = martial;
		this.ranged = ranged;
		this.cost = cost;
		this.damageDice = damageDice;
		this.damageType = damageType;
		this.weight = weight;
		this.property = property;
	}

}
