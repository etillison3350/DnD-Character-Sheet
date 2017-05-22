package charactersheet.values.item;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import charactersheet.values.Cost;
import charactersheet.values.Cost.Coin;
import charactersheet.values.DamageType;
import charactersheet.values.Dice;
import charactersheet.values.Proficientable;
import charactersheet.values.item.WeaponProperty.PropertyType;

public class Weapon extends Item implements Purchasable, Proficientable {

	public static final Weapon CLUB = new Weapon("Club", false, false, new Cost(1, Coin.SILVER), new Dice(4, 1), DamageType.BLUDGEONING, 2, new WeaponProperty(PropertyType.LIGHT));
	public static final Weapon DAGGER = new Weapon("Dagger", false, false, new Cost(2, Coin.GOLD), new Dice(4, 1), DamageType.PIERCING, 1, new WeaponProperty(PropertyType.FINESSE), new WeaponProperty(PropertyType.LIGHT), new WeaponProperty(PropertyType.THROWN, 20, 60));
	public static final Weapon GREATCLUB = new Weapon("Greatclub", false, false, new Cost(2, Coin.SILVER), new Dice(8, 1), DamageType.BLUDGEONING, 10, new WeaponProperty(PropertyType.TWO_HANDED));
	public static final Weapon HANDAXE = new Weapon("Handaxe", false, false, new Cost(5, Coin.GOLD), new Dice(6, 1), DamageType.SLASHING, 2, new WeaponProperty(PropertyType.LIGHT), new WeaponProperty(PropertyType.THROWN, 20, 60));
	public static final Weapon JAVELIN = new Weapon("Javelin", false, false, new Cost(5, Coin.SILVER), new Dice(6, 1), DamageType.PIERCING, 2, new WeaponProperty(PropertyType.THROWN, 30, 120));
	public static final Weapon LIGHT_HAMMER = new Weapon("Light hammer", false, false, new Cost(2, Coin.GOLD), new Dice(4, 1), DamageType.BLUDGEONING, 2, new WeaponProperty(PropertyType.LIGHT), new WeaponProperty(PropertyType.THROWN, 20, 60));
	public static final Weapon MACE = new Weapon("Mace", false, false, new Cost(5, Coin.GOLD), new Dice(6, 1), DamageType.BLUDGEONING, 4);
	public static final Weapon QUARTERSTAFF = new Weapon("Quarterstaff", false, false, new Cost(2, Coin.SILVER), new Dice(6, 1), DamageType.BLUDGEONING, 4, new WeaponProperty(PropertyType.VERSATILE, new Dice(8, 1)));
	public static final Weapon SICKLE = new Weapon("Sickle", false, false, new Cost(1, Coin.GOLD), new Dice(4, 1), DamageType.SLASHING, 2, new WeaponProperty(PropertyType.LIGHT));
	public static final Weapon SPEAR = new Weapon("Spear", false, false, new Cost(1, Coin.GOLD), new Dice(6, 1), DamageType.PIERCING, 3, new WeaponProperty(PropertyType.THROWN, 20, 60), new WeaponProperty(PropertyType.VERSATILE, new Dice(8, 1)));
	public static final Weapon LIGHT_CROSSBOW = new Weapon("Light crossbow", false, true, new Cost(25, Coin.GOLD), new Dice(8, 1), DamageType.PIERCING, 5, new WeaponProperty(PropertyType.AMMUNITION, 80, 320), new WeaponProperty(PropertyType.LOADING), new WeaponProperty(PropertyType.TWO_HANDED));
	public static final Weapon DART = new Weapon("Dart", false, true, new Cost(5, Coin.COPPER), new Dice(4, 1), DamageType.PIERCING, 0.25f, new WeaponProperty(PropertyType.FINESSE), new WeaponProperty(PropertyType.THROWN, 20, 60));
	public static final Weapon SHORTBOW = new Weapon("Shortbow", false, true, new Cost(25, Coin.GOLD), new Dice(6, 1), DamageType.PIERCING, 2, new WeaponProperty(PropertyType.AMMUNITION, 80, 320), new WeaponProperty(PropertyType.TWO_HANDED));
	public static final Weapon SLING = new Weapon("Sling", false, true, new Cost(1, Coin.SILVER), new Dice(4, 1), DamageType.BLUDGEONING, 0, new WeaponProperty(PropertyType.AMMUNITION, 30, 120));
	public static final Weapon BATTLEAXE = new Weapon("Battleaxe", true, false, new Cost(10, Coin.GOLD), new Dice(8, 1), DamageType.SLASHING, 4, new WeaponProperty(PropertyType.VERSATILE, new Dice(10, 1)));
	public static final Weapon FLAIL = new Weapon("Flail", true, false, new Cost(10, Coin.GOLD), new Dice(8, 1), DamageType.BLUDGEONING, 2);
	public static final Weapon GLAIVE = new Weapon("Glaive", true, false, new Cost(20, Coin.GOLD), new Dice(10, 1), DamageType.SLASHING, 6, new WeaponProperty(PropertyType.HEAVY), new WeaponProperty(PropertyType.REACH), new WeaponProperty(PropertyType.TWO_HANDED));
	public static final Weapon GREATAXE = new Weapon("Greataxe", true, false, new Cost(30, Coin.GOLD), new Dice(12, 1), DamageType.SLASHING, 7, new WeaponProperty(PropertyType.HEAVY), new WeaponProperty(PropertyType.TWO_HANDED));
	public static final Weapon GREATSWORD = new Weapon("Greatsword", true, false, new Cost(50, Coin.GOLD), new Dice(6, 2), DamageType.SLASHING, 6, new WeaponProperty(PropertyType.HEAVY), new WeaponProperty(PropertyType.TWO_HANDED));
	public static final Weapon HALBERD = new Weapon("Halberd", true, false, new Cost(20, Coin.GOLD), new Dice(10, 1), DamageType.SLASHING, 6, new WeaponProperty(PropertyType.HEAVY), new WeaponProperty(PropertyType.REACH), new WeaponProperty(PropertyType.TWO_HANDED));
	public static final Weapon LANCE = new Weapon("Lance", true, false, new Cost(10, Coin.GOLD), new Dice(12, 1), DamageType.PIERCING, 6, new WeaponProperty(PropertyType.REACH), new WeaponProperty(PropertyType.SPECIAL));
	public static final Weapon LONGSWORD = new Weapon("Longsword", true, false, new Cost(15, Coin.GOLD), new Dice(8, 1), DamageType.SLASHING, 3, new WeaponProperty(PropertyType.VERSATILE, new Dice(10, 1)));
	public static final Weapon MAUL = new Weapon("Maul", true, false, new Cost(10, Coin.GOLD), new Dice(6, 2), DamageType.BLUDGEONING, 10, new WeaponProperty(PropertyType.HEAVY), new WeaponProperty(PropertyType.TWO_HANDED));
	public static final Weapon MORNINGSTAR = new Weapon("Morningstar", true, false, new Cost(15, Coin.GOLD), new Dice(8, 1), DamageType.PIERCING, 4);
	public static final Weapon PIKE = new Weapon("Pike", true, false, new Cost(5, Coin.GOLD), new Dice(10, 1), DamageType.PIERCING, 18, new WeaponProperty(PropertyType.HEAVY), new WeaponProperty(PropertyType.REACH), new WeaponProperty(PropertyType.TWO_HANDED));
	public static final Weapon RAPIER = new Weapon("Rapier", true, false, new Cost(25, Coin.GOLD), new Dice(8, 1), DamageType.PIERCING, 2, new WeaponProperty(PropertyType.FINESSE));
	public static final Weapon SCIMITAR = new Weapon("Scimitar", true, false, new Cost(25, Coin.GOLD), new Dice(6, 1), DamageType.SLASHING, 3, new WeaponProperty(PropertyType.FINESSE), new WeaponProperty(PropertyType.LIGHT));
	public static final Weapon SHORTSWORD = new Weapon("Shortsword", true, false, new Cost(10, Coin.GOLD), new Dice(6, 1), DamageType.PIERCING, 2, new WeaponProperty(PropertyType.FINESSE), new WeaponProperty(PropertyType.LIGHT));
	public static final Weapon TRIDENT = new Weapon("Trident", true, false, new Cost(5, Coin.GOLD), new Dice(6, 1), DamageType.PIERCING, 4, new WeaponProperty(PropertyType.THROWN, 20, 60), new WeaponProperty(PropertyType.VERSATILE, new Dice(8, 1)));
	public static final Weapon WAR_PICK = new Weapon("War pick", true, false, new Cost(5, Coin.GOLD), new Dice(8, 1), DamageType.PIERCING, 2);
	public static final Weapon WARHAMMER = new Weapon("Warhammer", true, false, new Cost(15, Coin.GOLD), new Dice(8, 1), DamageType.BLUDGEONING, 2, new WeaponProperty(PropertyType.VERSATILE, new Dice(10, 1)));
	public static final Weapon WHIP = new Weapon("Whip", true, false, new Cost(2, Coin.GOLD), new Dice(4, 1), DamageType.SLASHING, 3, new WeaponProperty(PropertyType.FINESSE), new WeaponProperty(PropertyType.REACH));
	public static final Weapon BLOWGUN = new Weapon("Blowgun", true, true, new Cost(10, Coin.GOLD), new Dice(1, 1), DamageType.PIERCING, 1, new WeaponProperty(PropertyType.AMMUNITION, 25, 100), new WeaponProperty(PropertyType.LOADING));
	public static final Weapon HAND_CROSSBOW = new Weapon("Hand crossbow", true, true, new Cost(75, Coin.GOLD), new Dice(6, 1), DamageType.PIERCING, 3, new WeaponProperty(PropertyType.AMMUNITION, 30, 120), new WeaponProperty(PropertyType.LIGHT), new WeaponProperty(PropertyType.LOADING));
	public static final Weapon HEAVY_CROSSBOW = new Weapon("Heavy crossbow", true, true, new Cost(50, Coin.GOLD), new Dice(10, 1), DamageType.PIERCING, 18, new WeaponProperty(PropertyType.AMMUNITION, 100, 400), new WeaponProperty(PropertyType.HEAVY), new WeaponProperty(PropertyType.LOADING), new WeaponProperty(PropertyType.TWO_HANDED));
	public static final Weapon LONGBOW = new Weapon("Longbow", true, true, new Cost(50, Coin.GOLD), new Dice(8, 1), DamageType.PIERCING, 2, new WeaponProperty(PropertyType.AMMUNITION, 150, 600), new WeaponProperty(PropertyType.HEAVY), new WeaponProperty(PropertyType.TWO_HANDED));
	public static final Weapon NET = new Weapon("Net", true, true, new Cost(1, Coin.GOLD), new Dice(0, 0), null, 3, new WeaponProperty(PropertyType.SPECIAL), new WeaponProperty(PropertyType.THROWN, 5, 15));

	private static final List<Weapon> values = Arrays.asList(CLUB, DAGGER, GREATCLUB, HANDAXE, JAVELIN, LIGHT_HAMMER, MACE, QUARTERSTAFF, SICKLE, SPEAR, LIGHT_CROSSBOW, DART, SHORTBOW, SLING, BATTLEAXE, FLAIL, GLAIVE, GREATAXE, GREATSWORD, HALBERD, LANCE, LONGSWORD, MAUL, MORNINGSTAR, PIKE, RAPIER, SCIMITAR, SHORTSWORD, TRIDENT, WAR_PICK, WARHAMMER, WHIP, BLOWGUN, HAND_CROSSBOW, HEAVY_CROSSBOW, LONGBOW, NET);

	public static final Weapon[] SIMPLE = valuesMatching(w -> !w.martial);
	public static final Weapon[] MARTIAL = valuesMatching(w -> w.martial);

	public final boolean martial;
	public final boolean ranged;
	public final Cost cost;
	public final Dice damageDice;
	public final DamageType damageType;
	public final WeaponProperty[] property;

	private Weapon(final String name, final boolean martial, final boolean ranged, final Cost cost, final Dice damageDice, final DamageType damageType, final float weight, final WeaponProperty... property) {
		super(name, weight);

		this.martial = martial;
		this.ranged = ranged;
		this.cost = cost;
		this.damageDice = damageDice;
		this.damageType = damageType;
		this.property = property;
	}

	public static final Weapon[] values() {
		return values.toArray(new Weapon[values.size()]);
	}

	public static Weapon[] valuesMatching(final Predicate<Weapon> predicate) {
		return values.stream().filter(predicate).toArray(Weapon[]::new);
	}

	@Override
	public Cost getCost() {
		return cost;
	}

}
